import React, { PropTypes } from 'react'
import { connect } from 'react-redux'
import AppBar from 'material-ui/AppBar'
import Drawer from 'material-ui/Drawer'
import MenuItem from 'material-ui/MenuItem'
import TextField from 'material-ui/TextField'
import RaisedButton from 'material-ui/RaisedButton'

import AppBaseComponent from '../components/AppBaseComponent'

class Dashboard extends AppBaseComponent {
  static propTypes = {
  }

  render() {
    return (
      <div>
        <Drawer docked={true} zDepth={0} containerStyle={{backgroundColor: '#FAFAFA'}} >
          <MenuItem>Menu Item</MenuItem>
        </Drawer>
        <AppBar title="Title" iconClassNameRight="muidocs-icon-navigation-expand-more" style={{position: 'fixed', top: '0px', width: '100%'}} />
        <div style={{top: '100px'}}>
          <div>
            メインコンテンツ<br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
          </div>
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
})(Dashboard)
