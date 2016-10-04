import React from 'react'
import { Route, IndexRoute } from 'react-router'
import App from './containers/App'
import Login from './containers/Login'

export default (
  <Route path={`${process.env.CONTEXT_PATH}/`} component={App}>
    <IndexRoute component={Login} />
    <Route path='login' component={Login} />
  </Route>
)
