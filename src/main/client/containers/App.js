import React, { Component, PropTypes } from 'react'
import { connect } from 'react-redux'
import { browserHistory } from 'react-router'
import { MuiThemeProvider, getMuiTheme } from 'material-ui/styles'

import injectTapEventPlugin from 'react-tap-event-plugin'
injectTapEventPlugin()

class App extends Component {
  static propTypes = {
    children: PropTypes.node,
  }

  handleUrlChange = (nextValue) => {
    browserHistory.push(`${process.env.CONTEXT_PATH}${nextValue}`)
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
