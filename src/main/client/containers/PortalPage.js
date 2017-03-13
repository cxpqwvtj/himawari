import React, { PropTypes } from 'react'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import moment from 'moment'

import RaisedButton from 'material-ui/RaisedButton'

import AppBaseComponent from '../components/AppBaseComponent'
import App from './App'

import { ROUTES } from '../constants'
import * as actions from '../actions'

class PortalPage extends AppBaseComponent {
  static propTypes = {
    history: PropTypes.object.isRequired,
    actions: PropTypes.object.isRequired
  }

  render() {
    const { history } = this.props
    const contents = (
      <div>
        <div style={{margin: '10px'}}>
          <RaisedButton label='ENTRY' onClick={() => {history.push(ROUTES.TIMECARD_ENTRY())}} />
        </div>
        <div style={{margin: '10px'}}>
          <RaisedButton label='TimeCard' onClick={() => {super.handleUrlChange(ROUTES.USER_TIMECARD(moment().format('YYYYMM')))}} />
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
    return (
      <App children={contents} history={history} />
    )
  }
}

function mapStateToProps(state, ownProps) {
  return {
    history: ownProps.history
  }
}

function mapDispatchToProps(dispatch) {
  return { actions: bindActionCreators(actions, dispatch) }
}

export default connect(mapStateToProps, mapDispatchToProps)(PortalPage)
