import React from 'react'
import PropTypes from 'prop-types'
import { bindActionCreators } from 'redux'
import { Link } from 'react-router-dom'
import { connect } from 'react-redux'
import Button from '@material-ui/core/Button'
import moment from 'moment'

import AppBaseComponent from '../components/AppBaseComponent'
import App from './App'
import { ROUTES } from '../constants'
import * as actions from '../actions'

class PortalPage extends AppBaseComponent {
  static propTypes = {
    actions: PropTypes.object.isRequired
  }

  render() {
    return (
      <App>
        <div style={{ marginTop: '140px' }}>
          <Button variant='contained' color='primary' component={Link} to='/timecards/entry/1'>ログイン</Button>
        </div>
        <div style={{ margin: '10px' }}>
          <Button label='ENTRY'>ENTRY</Button>
        </div>
        <div style={{ margin: '10px' }}>
          <Button label='ENTRY' onClick={() => {super.handleUrlChange(ROUTES.TIMECARD_ENTRY())}}>ENTRY</Button>
        </div>
        <div style={{ margin: '10px' }}>
          <Button label='TimeCard' onClick={() => {super.handleUrlChange(ROUTES.USER_TIMECARD(moment().format('YYYYMM')))}}>TimeCard</Button>
        </div>
        <div style={{ margin: '10px' }}>
          <Button href='/swagger-ui' label='swagger-ui'>swagger</Button>
        </div>
        <div style={{ margin: '10px' }}>
          <Button href='/swagger-editor/#/?import=/swagger/swagger.yml' label='swagger-editor'>swagger</Button>
        </div>
        <div style={{ margin: '10px' }}>
          <Button href='/login' label='ログイン'>ログイン</Button>
        </div>
        <form action='/logout' method='POST' style={{ margin: '10px' }}>
          <Button type='submit' label='ログアウト'>ログアウト</Button>
        </form>
      </App>
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
