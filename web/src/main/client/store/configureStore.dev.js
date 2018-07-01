import { createStore, applyMiddleware, compose } from 'redux'
import { createLogger } from 'redux-logger'
import createSagaMiddleware, { END } from 'redux-saga'
import { Iterable } from 'immutable'
import { connectRouter, routerMiddleware } from 'connected-react-router/immutable'

import rootReducer from '../reducers'

export default function configureStore(initialState, history) {
  const sagaMiddleware = createSagaMiddleware()
  const store = createStore(
    connectRouter(history)(rootReducer),
    initialState,
    compose(
      applyMiddleware(routerMiddleware(history), sagaMiddleware, createLogger({
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
      store.replaceReducer(connectRouter(history)(rootReducer))
    })
  }

  store.runSaga = sagaMiddleware.run
  store.close = () => store.dispatch(END)
  return store
}
