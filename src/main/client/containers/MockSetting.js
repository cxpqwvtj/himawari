import React, { PropTypes } from 'react'
import Immutable from 'immutable'
import { Field, reduxForm } from 'redux-form'
import jsyaml from 'js-yaml'
import { Checkbox, RadioButtonGroup, SelectField, TextField, Toggle } from 'redux-form-material-ui'

import RaisedButton from 'material-ui/RaisedButton'

import AppBaseComponent from '../components/AppBaseComponent'

import SettingsYaml from 'raw!../../../../docs/mock/settings.yml'

export class MockSetting extends AppBaseComponent {
  static propTypes = {
  }

  render() {
    const properties = Immutable.fromJS(jsyaml.safeLoad(SettingsYaml).properties)
    const elements = properties.map((v, k) => {
      const opts = v.get('options')
      const options = opts ? opts.map((opt, index) => {
        return <RaisedButton label={opt.get('value')} key={index} style={{marginLeft: '10px'}} />
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

export default reduxForm({
  form: 'searchForm'
})(MockSetting)
