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

export const LOGS = createRequestTypes('LOGS')
export const LOAD_LOGS = 'LOAD_LOGS'
export const TRAIL = createRequestTypes('TRAIL')
export const CREATE_TRAIL = 'CREATE_TRAIL'

export const loadLogs = () => action(LOAD_LOGS, {endpoint: '/api/timber/list', method: 'GET'})

export const MOCK_SETTING_DEFINITION = 'MOCK_SETTING_DEFINITION'
export const mockSettingDefinition = (def) => action(MOCK_SETTING_DEFINITION, {def})

export const CHANGE_SETTING_VALUE = 'CHANGE_SETTING_VALUE'
export const changeSettingValue = (name, value) => action(CHANGE_SETTING_VALUE, {name, value})
