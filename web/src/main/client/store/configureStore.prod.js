import { createStore, applyMiddleware } from 'redux'
import createSagaMiddleware, { END } from 'redux-saga'
import { connectRouter, routerMiddleware } from 'connected-react-router/immutable'

import rootReducer from '../reducers'

export default function configureStore(initialState, history) {
  const sagaMiddleware = createSagaMiddleware()
  const store = createStore(
    connectRouter(history)(rootReducer),
    initialState,
    applyMiddleware(routerMiddleware(history), sagaMiddleware)
  )

  store.runSaga = sagaMiddleware.run
  store.close = () => store.dispatch(END)
  return store
}
