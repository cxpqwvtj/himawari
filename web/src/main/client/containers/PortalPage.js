import React from 'react'
import PropTypes from 'prop-types'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import moment from 'moment'

import Button from '@material-ui/core/Button'

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
        <div style={{ margin: '10px' }}>
          <Button label='ENTRY' onClick={() => {super.handleUrlChange(ROUTES.TIMECARD_ENTRY())}} />
        </div>
        <div style={{ margin: '10px' }}>
          <Button label='TimeCard' onClick={() => {super.handleUrlChange(ROUTES.USER_TIMECARD(moment().format('YYYYMM')))}} />
        </div>
        <div style={{ margin: '10px' }}>
          <Button href='/swagger-ui' label='swagger-ui' />
        </div>
        <div style={{ margin: '10px' }}>
          <Button href='/swagger-editor/#/?import=/swagger/swagger.yml' label='swagger-editor' />
        </div>
        <div style={{ margin: '10px' }}>
          <Button href='/login' label='ログイン' />
        </div>
        <form action='/logout' method='POST' style={{ margin: '10px' }}>
          <Button type='submit' label='ログアウト' />
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
