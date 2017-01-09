import { take, put, call, fork, select } from 'redux-saga/effects'
import { api } from '../services'
import * as actions from '../actions'

function* fetchEntity(entity, apiFunction, param, url) {
  yield put(entity.request(param))
  const {response, error} = yield call(apiFunction, url || param)
  if (response) {
    yield put(entity.success(param, response))
  } else {
    yield put(entity.failure(param, error))
  }
}

export const fetchLogout = fetchEntity.bind(null, actions.logoutRequestTypes, api.fetchData)
function* postLogout(requestParam) {
  yield call(fetchLogout, requestParam)
}
function* watchLogout() {
  while(true) {
    const requestParam = yield take(actions.LOGOUT_ACTION)
    yield fork(postLogout, requestParam.payload)
  }
}


export default function* root() {
  yield [
    fork(watchLogout)
  ]
}
