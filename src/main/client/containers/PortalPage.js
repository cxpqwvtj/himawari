import React, { PropTypes } from 'react'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'

import RaisedButton from 'material-ui/RaisedButton'

import AppBaseComponent from '../components/AppBaseComponent'

import { ROUTES } from '../constants'
import * as actions from '../actions'

class PortalPage extends AppBaseComponent {
  static propTypes = {
    actions: PropTypes.object.isRequired
  }

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
        <div style={{margin: '10px'}}>
          <RaisedButton label='logout' onClick={() => {this.props.actions.logoutAction()}} />
        </div>
        <div style={{margin: '10px'}}>
          <a href='/swagger-ui'>swagger-ui</a>
        </div>
        <div style={{margin: '10px'}}>
          <a href='/swagger-editor/#/?import=/swagger/swagger.yml'>swagger-editor</a>
        </div>
      </div>
    )
  }
}

function mapStateToProps(state, ownProps) {
  return {
  }
}

function mapDispatchToProps(dispatch) {
  return { actions: bindActionCreators(actions, dispatch) }
}

export default connect(mapStateToProps, mapDispatchToProps)(PortalPage)
