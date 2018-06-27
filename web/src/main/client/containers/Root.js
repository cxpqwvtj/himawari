import React, { Component } from 'react'
import PropTypes from 'prop-types'
import { Provider } from 'react-redux'
import { Route } from 'react-router'
import { ConnectedRouter } from 'react-router-redux'

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
          <div>
            <Route path='/' component={PortalPage} />
            <Route path='/login' component={Login} />
            <Route path='/timecards/entry(/:date)' component={TimeCardEntry} />
            <Route path='/timecards(/:yearMonth)' component={TimeCard} />
          </div>
        </ConnectedRouter>
      </Provider>
    )
  }
}

Root.propTypes = {
  store: PropTypes.object.isRequired,
  history: PropTypes.object.isRequired
}
