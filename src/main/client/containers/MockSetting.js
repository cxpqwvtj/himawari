import React, { PropTypes } from 'react'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import { Field, reduxForm } from 'redux-form'
import { Checkbox, RadioButtonGroup, SelectField, TextField, Toggle } from 'redux-form-material-ui'
import RaisedButton from 'material-ui/RaisedButton'

import Immutable from 'immutable'
import jsyaml from 'js-yaml'

import AppBaseComponent from '../components/AppBaseComponent'

import * as actions from '../actions'
import SettingsYaml from 'raw!../../../../docs/mock/settings.yml'

export class MockSetting extends AppBaseComponent {
  static propTypes = {
    actions: PropTypes.object.isRequired
  }

  render() {
    const properties = Immutable.fromJS(jsyaml.safeLoad(SettingsYaml).properties)
    const elements = properties.map((v, k) => {
      const opts = v.get('options')
      const options = opts ? opts.map((opt, index) => {
        return <RaisedButton label={opt.get('value')} key={index} style={{marginLeft: '10px'}} onClick={() => this.props.actions.changeSearchText(k, opt.get('value'))} />
      }) : undefined
      return v.get('type').indexOf('bool') < 0 ? (
        <div key={`div${k}`}>
          <Field name={k} type="text" component={TextField} hintText={v.get('title')} floatingLabelText={v.get('title')} />
          {options}
        </div>
      ) : (
        <div key={`div${k}`} style={{marginTop: '30px'}}>
          <Field name={v.get('title')} component={Checkbox} label={v.get('title')} />
        </div>
      )
    }).toList()
    return (
      <div style={{margin: '10px 50px'}}>
        <div style={{marginBottom: '20px'}}>
          <RaisedButton label='TOPへ' onClick={() => super.handleUrlChange('/')} />
        </div>
        {elements}
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

export default connect(mapStateToProps, mapDispatchToProps)(reduxForm({
  form: 'mockSettingForm'
})(MockSetting))
