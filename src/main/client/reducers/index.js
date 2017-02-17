import { combineReducers } from 'redux'
import { routerReducer as routing } from 'react-router-redux'
import { reducer as formReducer } from 'redux-form'
import Immutable from 'immutable'

import * as Actions from '../actions'

function mockSettingDefinition(state = {}, action) {
  if (action.type === Actions.MOCK_SETTING_DEFINITION) {
    return Object.assign({}, state, action.payload)
  }
  return state
}

function api(state = {}, action) {
  if (action.payload && action.payload.response) {
    return Object.assign({}, state, {[action.type]: action.payload.response})
  }
  return state
}

const rootReducer = combineReducers({
  routing,
  form: formReducer.plugin({
    mockSettingForm: (state={}, action) => {
      if (action.type === Actions.CHANGE_SETTING_VALUE) {
        return {
          ...state,
          values: {
            ...state.values,
            [action.payload.name]: action.payload.value
          },
          fields: {
            ...state.fields,
            [action.payload.name]: undefined
          }
        }
      } else if (action.type === Actions.MOCK_SETTING_DEFINITION) {
        return {
          ...state,
          values: {
            ...Immutable.fromJS(action.payload.def.properties).map((v) => v.get('default')).toJS(),
          },
          fields: {
            ...state.fields
          }
        }
      }
      return state
    }
  }),
  mockSettingDefinition,
  api
})

export default rootReducer
