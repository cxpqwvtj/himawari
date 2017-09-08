import { Component } from 'react'
import { browserHistory } from 'react-router'

export default class AppBaseComponent extends Component {

  handleUrlChange(nextValue) {
    browserHistory.push(`${process.env.CONTEXT_PATH}${nextValue}`)
  }
}
