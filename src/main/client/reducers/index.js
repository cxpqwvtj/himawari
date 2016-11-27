import { combineReducers } from 'redux'
import { routerReducer as routing } from 'react-router-redux'
import { reducer as formReducer } from 'redux-form'
import { MOCK_SETTING_DEFINITION, CHANGE_SEARCH_TEXT } from '../actions'

function mockSettingDefinition(state = {}, action) {
  if (action.type === MOCK_SETTING_DEFINITION) {
    return Object.assign({}, state, action.payload)
  }
  return state
}

const rootReducer = combineReducers({
  routing,
  form: formReducer.plugin({
    mockSettingForm: (state, action) => {
      if (action.type === CHANGE_SEARCH_TEXT) {
        return {
          ...state,
          values: {
            ...state.values,
            [action.payload.name]: action.payload.text
          },
          fields: {
            ...state.values,
            [action.payload.name]: undefined
          }
        }
      }
      return state
    }
  }),
  mockSettingDefinition
})

export default rootReducer
