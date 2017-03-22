import React from 'react'
import { Route, IndexRoute } from 'react-router'

import App from './containers/App'
import PortalPage from './containers/PortalPage'
import Login from './containers/Login'
import TimeCardEntry from './containers/TimeCardEntry'
import TimeCard from './containers/TimeCard'

export default (
  <Route path={`${process.env.CONTEXT_PATH}/`} component={App}>
    <IndexRoute component={PortalPage} />
    <Route path='login' component={Login} />
    <Route path='timecards/entry(/:date)' component={TimeCardEntry} />
    <Route path='timecards(/:yearMonth)' component={TimeCard} />
  </Route>
)
