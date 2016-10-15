import React, { Component, PropTypes } from 'react'
import { connect } from 'react-redux'
import { browserHistory } from 'react-router'
import TextField from 'material-ui/TextField'

class Top extends Component {
  static propTypes = {
  }

  handleUrlChange = (nextValue) => {
    browserHistory.push(`${process.env.CONTEXT_PATH}${nextValue}`)
  }

  render() {
    return (
      <div>
        <div style={{textAlign: 'center'}}>
          <span>ログイン</span>
        </div>
        <div style={{textAlign: 'center'}}>
          <TextField floatingLabelText='メールアドレス' />
        </div>
        <div style={{textAlign: 'center'}}>
          <TextField floatingLabelText='パスワード' />
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
})(Top)
