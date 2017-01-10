import 'isomorphic-fetch'

function callApi(requestParam) {
  const fullUrl = `${process.env.CONTEXT_PATH}${requestParam.endpoint}`
  const csrfToken = document.cookie.split(';').filter((v) => v.trim().startsWith('XSRF-TOKEN')).reduce((r, v) => {
    return {'X-XSRF-TOKEN': v.split('=')[1]}
  }, {})
  const param = Object.assign({
    method: requestParam.method,
    credentials: 'same-origin',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      ...csrfToken
    }
  }, requestParam.method === 'POST' ? { body: JSON.stringify(requestParam.body || null)} : {})

  return fetch(fullUrl, param
    ).then(response =>
      response.json().then(json => ({ json, response }))
    ).then(({ json, response }) => {
      if (!response.ok || !!json.error) {
        return Promise.reject(json)
      }

      return Object.assign({},
        json,
        { someone: 'someone' }
      )
    })
    .then(
      response => ({response}),
      error => ({error: error.message || 'Something bad happened'})
    )
}

// api services
export const fetchData = requestParam => callApi(requestParam)
