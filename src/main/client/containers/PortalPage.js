import React from 'react'
import { connect } from 'react-redux'
import AppBar from 'material-ui/AppBar'
import IconButton from 'material-ui/IconButton'
import FlatButton from 'material-ui/FlatButton'
import { NavigationMenu } from 'material-ui/svg-icons'

import AppBaseComponent from '../components/AppBaseComponent'
import ApiSpec from '../components/ApiSpec'

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
          <FlatButton label='TimeCard' onClick={() => {super.handleUrlChange('/timecards/201701')}} />
        </div>
        <div>
          <ApiSpec />
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
