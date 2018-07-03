import React, { Component } from 'react'
import PropTypes from 'prop-types'
import { Provider } from 'react-redux'
import { Route, Switch } from 'react-router-dom'
import { ConnectedRouter } from 'connected-react-router/immutable'

import PortalPage from './PortalPage'
import Login from './Login'
import TimeCardEntry from './TimeCardEntry'
import TimeCard from './TimeCard'

export default class Root extends Component {
  render() {
    const { store, history } = this.props
    return (
      <Provider store={store}>
        <ConnectedRouter history={history}>
          <Switch>
            <Route exact path='/' component={PortalPage} />
            <Route exact path='/login' component={Login} />
            <Route exact path='/timecards/entry' component={TimeCardEntry} />
            <Route exact path='/timecards/entry/:date' component={TimeCardEntry} />
            <Route exact path='/timecards(/:yearMonth)' component={TimeCard} />
            <Route component={PortalPage} />
          </Switch>
        </ConnectedRouter>
      </Provider>
    )
  }
}

Root.propTypes = {
  store: PropTypes.object.isRequired,
  history: PropTypes.object.isRequired
}
