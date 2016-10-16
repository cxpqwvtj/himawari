import React from 'react'
import { connect } from 'react-redux'
import AppBar from 'material-ui/AppBar'
import IconButton from 'material-ui/IconButton'
import FlatButton from 'material-ui/FlatButton'
import { NavigationMenu } from 'material-ui/svg-icons'

import AppBaseComponent from '../components/AppBaseComponent'

class PortalPage extends AppBaseComponent {
  render() {
    return (
      <div>
        <AppBar
          title="Himawari"
          iconElementLeft={<IconButton><NavigationMenu /></IconButton>}
          iconElementRight={
            <FlatButton
              label="Sign in"
              labelStyle={{textTransform: 'none'}}
              onClick={() => {super.handleUrlChange('/login')}}
            />
          }
        />
        <div>PortalPage</div>
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
