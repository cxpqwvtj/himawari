import { combineReducers } from 'redux-immutablejs'
import { LOCATION_CHANGE } from 'react-router-redux'
import { reducer as formReducer } from 'redux-form'
import Immutable from 'immutable'
import moment from 'moment'

import * as Actions from '../actions'

const routingInitialState = Immutable.fromJS({
  locationBeforeTransitions: null
})
function routing(state = routingInitialState, action) {
  if (action.type === LOCATION_CHANGE) {
    return state.set('locationBeforeTransitions', action.payload)
  }
  return state
}

function api(state = Immutable.fromJS({}), action) {
  if (action.payload && action.payload.response) {
    return state.merge({[action.type]: action.payload.response})
  } else if (action.type.endsWith('_FAILURE') && Immutable.fromJS(action).getIn(['payload', 'error'])) {
    return state.merge({error: action.payload.error})
  } else if (action.type === Actions.DELETE_ERROR_ACTION) {
    return state.delete('error').toJS()
  }
  return state
}

const rootReducer = combineReducers({
  routing,
  api,
  form: formReducer.plugin({
    timecardEntry: (state={values: {vacationType: 'NOTHING'}}, action) => {
      if (action.type === Actions.INITIALIZE_TIMECARD_ENTRY) {
        return {
          ...state,
          values: {
            ...state.values,
            ...action.payload
          },
          fields: {
            ...state.fields
          }
        }
      } else if (action.meta && action.meta.form === 'timecardEntry' && action.type === '@@redux-form/BLUR') {
        const entryDate = moment(state.values.entryDate).startOf('day')
        const value = (() => {
          if (isNaN(parseInt(action.payload, 10))) {
            return action.payload
          }
          if (action.payload.length === 1 || action.payload.length === 2) {
            return entryDate.clone().hour(action.payload).format('HH:mm')
          } else if (action.payload.length === 3) {
            return entryDate.clone().hour(action.payload[0]).minute(action.payload.substring(1)).format('HH:mm')
          } else if (action.payload.length === 4) {
            return entryDate.clone().hour(action.payload.substring(0, 2)).minute(action.payload.substring(2)).format('HH:mm')
          }
          return action.payload
        })()
        return {
          ...state,
          values: {
            ...state.values,
            [action.meta.field]: value
          },
          fields: {
            ...state.fields
          }
        }
      }
      return state
    }
  })
})

export default rootReducer
