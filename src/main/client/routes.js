import React from 'react'
import { Route, IndexRoute } from 'react-router'

import App from './containers/App'
import PortalPage from './containers/PortalPage'
import Login from './containers/Login'
import TimeCard from './containers/TimeCard'
import ApiSpec from './components/ApiSpec'
import MockSetting from './components/MockSetting'

export default (
  <Route path={`${process.env.CONTEXT_PATH}/`} component={App}>
    <IndexRoute component={PortalPage} />
    <Route path='login' component={Login} />
    <Route path='timecards(/:yearMonth)' component={TimeCard} />
    <Route path='docs/api' component={ApiSpec} />
    <Route path='mock/setting' component={MockSetting} />
  </Route>
)
