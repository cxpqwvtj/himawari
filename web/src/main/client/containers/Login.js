import React from 'react'
import { connect } from 'react-redux'
import TextField from '@material-ui/core/TextField'
import Button from '@material-ui/core/Button'

import AppBaseComponent from '../components/AppBaseComponent'

class Login extends AppBaseComponent {

  render() {
    return (
      <div>
        <div style={{ textAlign: 'center' }}>
          <span>ログイン</span>
        </div>
        <div style={{ textAlign: 'center' }}>
          <TextField floatingLabelText='メールアドレス' />
        </div>
        <div style={{ textAlign: 'center' }}>
          <TextField floatingLabelText='パスワード' />
        </div>
        <div style={{ textAlign: 'center' }}>
          <Button label="Default" style={{ margin: '12px' }} onClick={() => { super.handleUrlChange('/login') }} />
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
})(Login)
