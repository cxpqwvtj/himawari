import React from 'react'
import PropTypes from 'prop-types'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import Immutable from 'immutable'

import { MuiThemeProvider, createMuiTheme } from '@material-ui/core/styles'
import AppBar from '@material-ui/core/AppBar'
import Snackbar from '@material-ui/core/Snackbar'
import IconButton from '@material-ui/core/IconButton'
import Button from '@material-ui/core/Button'
import FirstPage from '@material-ui/icons/FirstPage'

import AppBaseComponent from '../components/AppBaseComponent'

import * as actions from '../actions'

class App extends AppBaseComponent {
  static propTypes = {
    children: PropTypes.node,
    actions: PropTypes.object.isRequired,
    error: PropTypes.object.isRequired
  }

  render() {
    const { children } = this.props

    const muiTheme = createMuiTheme({
      // テーマ設定
    })

    return (
      <MuiThemeProvider muiTheme={muiTheme}>
        <div>
          <AppBar
            title="Himawari"
            iconElementLeft={<IconButton onClick={() => super.handleUrlChange('')}><FirstPage /></IconButton>}
            iconElementRight={
              <Button
                variant="contained"
                label='Sign in'
                labelStyle={{ textTransform: 'none' }}
                onClick={() => {super.handleUrlChange('/login')}}
              />
            }
          />
          <Snackbar open={!!this.props.error.get('message')} autoHideDuration={4000} message={`${this.props.error.get('status', '')}:${this.props.error.get('message', '')}`} onRequestClose={() => this.props.actions.deleteErrorAction()} />
          {children}
        </div>
      </MuiThemeProvider>
    )
  }
}

function mapStateToProps(state, ownProps) {
  return {
    error: state.getIn(['api', 'error'], Immutable.Map())
  }
}

function mapDispatchToProps(dispatch) {
  return { actions: bindActionCreators(actions, dispatch) }
}

export default connect(mapStateToProps, mapDispatchToProps)(App)
