import React from 'react'
import { Route, IndexRoute } from 'react-router'
import * as Containers from './containers'

export default (
  <Route path={`${process.env.CONTEXT_PATH}/`} component={Containers.App}>
    <IndexRoute component={Containers.Login} />
    <Route path='login' component={Containers.Login} />
  </Route>
)
