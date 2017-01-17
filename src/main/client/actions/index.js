const REQUEST = 'REQUEST'
const SUCCESS = 'SUCCESS'
const FAILURE = 'FAILURE'

function createRequestTypes(base) {
  return [REQUEST, SUCCESS, FAILURE].reduce((acc, type) => {
    acc[type] = `${base}_${type}`
    return acc
  }, {})
}

function action(type, payload = {}) {
  return {type, payload}
}

export const LOGOUT_REQUEST = createRequestTypes('LOGOUT_REQUEST')
export const logoutRequestTypes = {
  request: (param) => action(LOGOUT_REQUEST.REQUEST, {param}),
  success: (param, response) => action(LOGOUT_REQUEST.SUCCESS, {param, response}),
  failure: (param, error) => action(LOGOUT_REQUEST.FAILURE, {param, error}),
}
export const LOGOUT_ACTION = 'LOGOUT_ACTION'
export const logoutAction = () => {
  const param = {
    endpoint: '/logout',
    method: 'POST'
  }
  return action(LOGOUT_ACTION, param)
}

export const MOCK_SETTING_DEFINITION = 'MOCK_SETTING_DEFINITION'
export const mockSettingDefinition = (def) => action(MOCK_SETTING_DEFINITION, {def})

export const CHANGE_SETTING_VALUE = 'CHANGE_SETTING_VALUE'
export const changeSettingValue = (name, value) => action(CHANGE_SETTING_VALUE, {name, value})
