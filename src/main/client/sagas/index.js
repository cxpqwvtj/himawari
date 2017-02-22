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
    startDatetime: day.get('startDatetime') ? moment(day.get('startDatetime')).format('HH:mm') : '',
    endDatetime: day.get('endDatetime') ? moment(day.get('endDatetime')).format('HH:mm') : ''
  }))
}
function* watchGetTimecard() {
  while(true) {
    const requestParam = yield take(actions.TIMECARD_LOAD_ACTION)
    yield fork(getTimecard, requestParam.payload)
  }
}

const fetchTimecardEntry = fetchEntity.bind(null, actions.timecardEntryTypes, api.fetchData)
function* postTimecardEntry(requestParam) {
  const state = yield select((state) => Immutable.fromJS(state))
  const entry = state.getIn(['form', 'timecardEntry', 'values'])
  const bizDate = moment(entry.get('entryDate')).format('YYYY-MM-DD') 
  const startDatetime = entry.get('startDatetime') ? moment(`${bizDate} ${entry.get('startDatetime')}`, 'YYYY-MM-DD HH:mm').format('YYYY-MM-DDTHH:mm:ssZ') : ''
  const endDatetime = entry.get('endDatetime') ? moment(`${bizDate} ${entry.get('endDatetime')}`, 'YYYY-MM-DD HH:mm').format('YYYY-MM-DDTHH:mm:ssZ') : ''
  yield call(fetchTimecardEntry, Object.assign(requestParam, {body: {days: [{bizDate, startDatetime, endDatetime}]}}))
}
function* watchPostTimecardEntry() {
  while(true) {
    const requestParam = yield take(actions.TIMECARD_ENTRY_ACTION)
    yield fork(postTimecardEntry, requestParam.payload)
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
    fork(watchPostTimecardEntry),
    fork(watchLogout)
  ]
}
