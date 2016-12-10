import React, { PropTypes } from 'react'
import { connect } from 'react-redux'

import { MuiThemeProvider, getMuiTheme } from 'material-ui/styles'
import AppBar from 'material-ui/AppBar'
import IconButton from 'material-ui/IconButton'
import FlatButton from 'material-ui/FlatButton'
import FirstPageIcon from 'material-ui/svg-icons/navigation/first-page'
import injectTapEventPlugin from 'react-tap-event-plugin'

import AppBaseComponent from '../components/AppBaseComponent'

injectTapEventPlugin()

class App extends AppBaseComponent {
  static propTypes = {
    children: PropTypes.node,
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
            iconElementLeft={<IconButton><FirstPageIcon /></IconButton>}
            iconElementRight={
              <FlatButton
                label='Sign in'
                labelStyle={{textTransform: 'none'}}
                onClick={() => {super.handleUrlChange('/login')}}
              />
            }
          />
          {children}
        </div>
      </MuiThemeProvider>
    )
  }
}

function mapStateToProps(state, ownProps) {
  return {
  }
}

export default connect(mapStateToProps, {
})(App)
