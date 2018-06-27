import { createStore, applyMiddleware, compose } from 'redux'
import { createLogger } from 'redux-logger'
import createSagaMiddleware, { END } from 'redux-saga'
import { Iterable } from 'immutable'
import { routerMiddleware } from 'react-router-redux'

import rootReducer from '../reducers'

export default function configureStore(initialState, history) {
  const sagaMiddleware = createSagaMiddleware()
  const store = createStore(
    rootReducer,
    initialState,
    compose(
      applyMiddleware(sagaMiddleware, routerMiddleware(history), createLogger({
        collapsed: () => true,
        stateTransformer: (state) => {
          if (Iterable.isIterable(state)) return state.toJS()
          else return state
        }
      }))
    )
  )

  if (module.hot) {
    module.hot.accept('../reducers', () => {
      const nextRootReducer = require('../reducers').default
      store.replaceReducer(nextRootReducer)
    })
  }

  store.runSaga = sagaMiddleware.run
  store.close = () => store.dispatch(END)
  return store
}
