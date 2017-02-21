import { take, put, call, fork, select } from 'redux-saga/effects'
import Immutable from 'immutable'
import moment from 'moment'

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

export const fetchTimecard = fetchEntity.bind(null, actions.timecardLoadTypes, api.fetchData)
function* getTimecard(requestParam) {
  yield call(fetchTimecard, requestParam)
  const state = yield select((state) => Immutable.fromJS(state))
  const entryDate = state.getIn(['form', 'timecardEntry', 'values', 'entryDate'], moment().toDate())
  const day = state.getIn(['api', 'TIMECARD_LOAD_SUCCESS', 'days'], Immutable.List()).filter(v => v.get('bizDate', '') === moment(entryDate).format('YYYY-MM-DD')).first() || Immutable.Map()
  yield put(actions.initializeTimecardEntry({
    entryDate,
    startDatetime: moment(day.get('startDatetime')).format('HH:mm'),
    endDatetime: moment(day.get('endDatetime')).format('HH:mm')
  }))
}
function* watchGetTimecard() {
  while(true) {
    const requestParam = yield take(actions.TIMECARD_LOAD_ACTION)
    yield fork(getTimecard, requestParam.payload)
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
    fork(watchGetTimecard),
    fork(watchLogout)
  ]
}
