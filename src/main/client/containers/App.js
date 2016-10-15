import React, { PropTypes } from 'react'
import { connect } from 'react-redux'
import { browserHistory } from 'react-router'
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
    return (
      <MuiThemeProvider muiTheme={getMuiTheme()}>
        {children}
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
