export const ROUTES = {
  TIMECARD_ENTRY: '/timecards/entry',
  USER_TIMECARD: (yearMonth) => `/timecards/${yearMonth}`,
  API_SPEC: '/dev/docs/api',
  MOCK_SETTING: '/dev/mock/setting'
}

export const API_URL = {
  JSON_SCHEMA: '/api/dev/docs/jsonschema',
  USER_TIMECARD: (yearMonth) => `/api/v1/timecards/${yearMonth}`,
}

export const HTTP_METHOD = {
  GET: 'GET',
  POST: 'POST'
}