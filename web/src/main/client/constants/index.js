export const ROUTES = {
  TIMECARD_ENTRY: (date = '') => `/timecards/entry${date}`,
  USER_TIMECARD: (yearMonth) => `/timecards/${yearMonth}`,
  USER_TIMECARD_EXCEL: (yearMonth) => `/excel/timecards/${yearMonth}`,
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

export const ENUMS = {
  VACATION_TYPE: {
    NOTHING: {
      name: 'NOTHING',
      description: '設定なし'
    },
    PAID_DAY_OFF: {
      name: 'PAID_DAY_OFF',
      description: '有給休暇'
    },
    SP_DAY_OFF: {
      name: 'SP_DAY_OFF',
      description: '特別休暇'
    },
    AM_OFF: {
      name: 'AM_OFF',
      description: '午前休'
    },
    PM_OFF: {
      name: 'PM_OFF',
      description: '午後休'
    },
    TRANSFER_DAY_OFF: {
      name: 'TRANSFER_DAY_OFF',
      description: '振替休暇'
    }
  }
}