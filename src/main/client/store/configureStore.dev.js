import { createStore, applyMiddleware, compose } from 'redux'
import createLogger from 'redux-logger'
import rootReducer from '../reducers'
import createSagaMiddleware, { END } from 'redux-saga'
import { routerMiddleware } from 'react-router-redux'

export default function configureStore(initialState, history) {
  const sagaMiddleware = createSagaMiddleware()
  const rooterMiddleware = routerMiddleware(history)
  const store = createStore(
    rootReducer,
    initialState,
    compose(
      applyMiddleware(rooterMiddleware, sagaMiddleware, createLogger({
        collapsed: () => true
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
