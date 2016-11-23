import React, { PropTypes } from 'react'
import Immutable from 'immutable'
import { Field, reduxForm } from 'redux-form'
import jsyaml from 'js-yaml'

import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table'
import RaisedButton from 'material-ui/RaisedButton'
import TextField from 'material-ui/TextField'
import Checkbox from 'material-ui/Checkbox'

import AppBaseComponent from '../components/AppBaseComponent'

import SettingsYaml from 'raw!../../../../docs/mock/settings.yml'

export class MockSetting extends AppBaseComponent {
  static propTypes = {
  }

  constructor(props) {
    super(props)
    this.state = {
      yaml: jsyaml.safeLoad(SettingsYaml)
    }
  }

  render() {
    const properties = Immutable.fromJS(this.state.yaml.properties)
    const elements = properties.map((v, k) => {
      const opts = v.get('options')
      const options = opts ? opts.map((opt, index) => {
        return <RaisedButton label={opt.get('value')} key={index} style={{marginLeft: '10px'}} />
      }) : undefined
      return v.get('type').indexOf('bool') < 0 ? (
        <div key={k}>
          <Field name={k} type="text" component={({ input, label, meta: { touched, error }, ...custom }) => (
            <TextField hintText={label}
              floatingLabelText={label}
              errorText={touched && error}
              {...input}
              {...custom}
            />
          )} label={v.get('title')} />
          {options}
        </div>
      ) : (
        <div key={k}>
          <Field name={v.get('title')} component={({ input, label }) => (
            <Checkbox label={label}
              checked={input.value ? true : false}
              onCheck={input.onChange}
            />
            )} label={v.get('title')}
          />
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
