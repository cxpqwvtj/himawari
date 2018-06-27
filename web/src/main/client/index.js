import React from 'react'
import { render } from 'react-dom'
import createHistory from 'history/createBrowserHistory'

import Root from './containers/Root'
import configureStore from './store/configureStore'
import rootSaga from './sagas'

const store = configureStore()
store.runSaga(rootSaga)

const history = createHistory()

render(
  <Root store={store} history={history} />,
  document.getElementById('root')
)