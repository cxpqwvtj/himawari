import React, { PropTypes } from 'react'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'

import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table'
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
          <RaisedButton label='TimeCard' onClick={() => {super.handleUrlChange(ROUTES.USER_TIMECARD('201701'))}} />
        </div>
        <div style={{margin: '10px'}}>
          <RaisedButton label='API' onClick={() => {super.handleUrlChange(ROUTES.API_SPEC)}} />
        </div>
        <div style={{margin: '10px'}}>
          <RaisedButton label='mock setting' onClick={() => {super.handleUrlChange(ROUTES.MOCK_SETTING)}} />
        </div>
        <div style={{margin: '10px'}}>
          <RaisedButton href='/swagger-ui' label='swagger-ui' />
        </div>
        <div style={{margin: '10px'}}>
          <RaisedButton href='/swagger-editor/#/?import=/swagger/swagger.yml' label='swagger-editor' />
        </div>
        <div style={{margin: '10px'}}>
          <RaisedButton href='/login' label='ログイン' />
        </div>
        <form action='/logout' method='POST' style={{margin: '10px'}}>
          <RaisedButton type='submit' label='ログアウト' />
        </form>
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
