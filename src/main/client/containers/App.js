import React, { PropTypes } from 'react'
import { connect } from 'react-redux'
import { MuiThemeProvider, getMuiTheme } from 'material-ui/styles'
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
