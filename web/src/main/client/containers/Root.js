import React, { Component } from 'react'
import PropTypes from 'prop-types'
import { Provider } from 'react-redux'
import { Route, Switch } from 'react-router-dom'
import { ConnectedRouter } from 'connected-react-router/immutable'
import { MuiThemeProvider, createMuiTheme } from '@material-ui/core/styles'
import { MuiPickersUtilsProvider } from 'material-ui-pickers'
import MomentUtils from 'material-ui-pickers/utils/moment-utils'
import moment from 'moment'
import 'moment/locale/ja'

import PortalPage from './PortalPage'
import Login from './Login'
import TimeCardEntry from './TimeCardEntry'
import TimeCard from './TimeCard'

export default class Root extends Component {
  render() {
    const { store, history } = this.props

    const muiTheme = createMuiTheme({
      palette: {
        primary: {
          light: '#757ce8',
          main: window.PRIMARY_COLOR,
          dark: '#002884',
          contrastText: '#fff',
        },
        secondary: {
          light: '#ff7961',
          main: '#f44336',
          dark: '#ba000d',
          contrastText: '#000',
        },
      },
    })

    return (
      <MuiThemeProvider theme={muiTheme}>
        <Provider store={store}>
          <MuiPickersUtilsProvider
            utils={MomentUtils}
            moment={moment}
            locale='ja'
            format='YYYY/MM/DD'
          >
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
          </MuiPickersUtilsProvider>
        </Provider>
      </MuiThemeProvider>
    )
  }
}

Root.propTypes = {
  store: PropTypes.object.isRequired,
  history: PropTypes.object.isRequired
}
