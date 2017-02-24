import { API_URL, HTTP_METHOD } from '../constants'

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

export const TIMECARD_LOAD_TYPES = createRequestTypes('TIMECARD_LOAD')
export const timecardLoadTypes = {
  request: (param) => action(TIMECARD_LOAD_TYPES.REQUEST, {param}),
  success: (param, response) => action(TIMECARD_LOAD_TYPES.SUCCESS, {param, response}),
  failure: (param, error) => action(TIMECARD_LOAD_TYPES.FAILURE, {param, error}),
}
export const TIMECARD_LOAD_ACTION = 'TIMECARD_LOAD_ACTION'
export const timecardLoadAction = (yearMonth) => {
  const param = {
    endpoint: API_URL.USER_TIMECARD(yearMonth),
    method: HTTP_METHOD.GET
  }
  return action(TIMECARD_LOAD_ACTION, param)
}

export const TIMECARD_ENTRY_TYPES = createRequestTypes('TIMECARD_ENTRY')
export const timecardEntryTypes = {
  request: (param) => action(TIMECARD_ENTRY_TYPES.REQUEST, {param}),
  success: (param, response) => action(TIMECARD_ENTRY_TYPES.SUCCESS, {param, response}),
  failure: (param, error) => action(TIMECARD_ENTRY_TYPES.FAILURE, {param, error}),
}
export const TIMECARD_ENTRY_ACTION = 'TIMECARD_ENTRY_ACTION'
export const timecardEntryAction = () => {
  const param = {
    endpoint: API_URL.TIMECARD_ENTRY,
    method: HTTP_METHOD.POST
  }
  return action(TIMECARD_ENTRY_ACTION, param)
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

export const DELETE_ERROR_ACTION = 'DELETE_ERROR_ACTION'
export const deleteErrorAction = () => action(DELETE_ERROR_ACTION, {})

export const MOCK_SETTING_DEFINITION = 'MOCK_SETTING_DEFINITION'
export const mockSettingDefinition = (def) => action(MOCK_SETTING_DEFINITION, {def})

export const CHANGE_SETTING_VALUE = 'CHANGE_SETTING_VALUE'
export const changeSettingValue = (name, value) => action(CHANGE_SETTING_VALUE, {name, value})

export const INITIALIZE_TIMECARD_ENTRY = 'INITIALIZE_TIMECARD_ENTRY'
export const initializeTimecardEntry = (payload) => action(INITIALIZE_TIMECARD_ENTRY, payload)

export const CREATE_TIMECARD_XLSX_ACTION = 'CREATE_TIMECARD_XLSX_ACTION'
export const createTimecardXlsxAction = (payload) => action(CREATE_TIMECARD_XLSX_ACTION, payload)
