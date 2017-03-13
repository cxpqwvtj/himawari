import React, { PropTypes } from 'react'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import Immutable from 'immutable'

import { MuiThemeProvider, getMuiTheme } from 'material-ui/styles'
import AppBar from 'material-ui/AppBar'
import Snackbar from 'material-ui/Snackbar'
import IconButton from 'material-ui/IconButton'
import FlatButton from 'material-ui/FlatButton'
import FirstPageIcon from 'material-ui/svg-icons/navigation/first-page'
import injectTapEventPlugin from 'react-tap-event-plugin'

import AppBaseComponent from '../components/AppBaseComponent'

import * as actions from '../actions'

injectTapEventPlugin()

class App extends AppBaseComponent {
  static propTypes = {
    history: PropTypes.object.isRequired,
    children: PropTypes.node,
    actions: PropTypes.object.isRequired,
    error: PropTypes.object.isRequired
  }

  render() {
    const { children } = this.props

    const muiTheme = getMuiTheme({
      tableRowColumn: {
        height: '30px'
      },
      tableRow: {
        height: '30px'
      }
    })

    return (
      <MuiThemeProvider muiTheme={muiTheme}>
        <div>
          <AppBar
            title="Himawari"
            iconElementLeft={<IconButton onClick={() => this.props.history.push('/')}><FirstPageIcon /></IconButton>}
            iconElementRight={
              <FlatButton
                label='Sign in'
                labelStyle={{textTransform: 'none'}}
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
  const api = Immutable.fromJS(state.api)
  return {
    error: api.get('error', Immutable.Map()),
    history: ownProps.history
  }
}

function mapDispatchToProps(dispatch) {
  return { actions: bindActionCreators(actions, dispatch) }
}

export default connect(mapStateToProps, mapDispatchToProps)(App)
