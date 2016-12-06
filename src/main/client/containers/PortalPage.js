import React from 'react'
import { connect } from 'react-redux'
import AppBar from 'material-ui/AppBar'
import IconButton from 'material-ui/IconButton'
import FlatButton from 'material-ui/FlatButton'
import RaisedButton from 'material-ui/RaisedButton'
import { NavigationMenu } from 'material-ui/svg-icons'

import AppBaseComponent from '../components/AppBaseComponent'
import { ROUTES } from '../constants'

class PortalPage extends AppBaseComponent {
  render() {
    return (
      <div>
        <AppBar
          title="Himawari"
          iconElementLeft={<IconButton><NavigationMenu /></IconButton>}
          iconElementRight={
            <FlatButton
              label='Sign in'
              labelStyle={{textTransform: 'none'}}
              onClick={() => {super.handleUrlChange('/login')}}
            />
          }
        />
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
