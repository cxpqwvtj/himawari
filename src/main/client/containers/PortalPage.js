import React from 'react'
import { connect } from 'react-redux'

import RaisedButton from 'material-ui/RaisedButton'

import AppBaseComponent from '../components/AppBaseComponent'
import { ROUTES } from '../constants'

class PortalPage extends AppBaseComponent {
  render() {
    return (
      <div>
        <div style={{margin: '10px'}}>
          <RaisedButton label='TimeCard' onClick={() => {super.handleUrlChange('/timecards/201701')}} />
        </div>
        <div style={{margin: '10px'}}>
          <RaisedButton label='API' onClick={() => {super.handleUrlChange(ROUTES.API_SPEC)}} />
        </div>
        <div style={{margin: '10px'}}>
          <RaisedButton label='mock setting' onClick={() => {super.handleUrlChange(ROUTES.MOCK_SETTING)}} />
        </div>
      </div>
    )
  }
}

function mapStateToProps(state, ownProps) {
  return {
  }
}

export default connect(mapStateToProps, {
})(PortalPage)
