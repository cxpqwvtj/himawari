export const ROUTES = {
  TIMECARD_ENTRY: (date = '') => `/timecards/entry${date}`,
  USER_TIMECARD: (yearMonth) => `/timecards/${yearMonth}`,
  API_SPEC: '/dev/docs/api',
  MOCK_SETTING: '/dev/mock/setting'
}

export const API_URL = {
  JSON_SCHEMA: '/api/dev/docs/jsonschema',
  USER_TIMECARD: (yearMonth) => `/api/v1/timecards/${yearMonth}`,
  TIMECARD_ENTRY: '/api/v1/user/days'
}

export const HTTP_METHOD = {
  GET: 'GET',
  POST: 'POST'
}

export const WORDING = {
  VACATION_TYPE: {
    NOTHING: '設定なし',
    PAID_DAY_OFF: '有給休暇',
    SP_DAY_OFF: '特別休暇',
    AM_OFF: '午前休',
    PM_OFF: '午後休',
    TRANSFER_DAY_OFF: '振替休暇'
  }
}