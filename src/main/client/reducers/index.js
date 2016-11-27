import { combineReducers } from 'redux'
import { routerReducer as routing } from 'react-router-redux'
import { reducer as formReducer } from 'redux-form'
import { CHANGE_SEARCH_TEXT } from '../actions'

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
  })
})

export default rootReducer
