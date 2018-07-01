import React from 'react'
import { render } from 'react-dom'
import { createBrowserHistory } from 'history'
import Immutable from 'immutable'

import Root from './containers/Root'
import configureStore from './store/configureStore'
import rootSaga from './sagas'

const history = createBrowserHistory({ basename: `${window.CONTEXT_PATH}` })

const store = configureStore(Immutable.Map(), history)
store.runSaga(rootSaga)

render(
  <Root store={store} history={history} />,
  document.getElementById('root')
)