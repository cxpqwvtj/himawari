import React, { PropTypes } from 'react'
import Immutable from 'immutable'
import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table'
import RaisedButton from 'material-ui/RaisedButton'
import TextField from 'material-ui/TextField'
import Checkbox from 'material-ui/Checkbox'
import jsyaml from 'js-yaml'

import AppBaseComponent from '../components/AppBaseComponent'

import SettingsYaml from 'raw!../../../../docs/mock/settings.yml'

export default class MockSetting extends AppBaseComponent {
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
        <div key={k}>
          <TextField
            floatingLabelText={v.get('title')}
            defaultValue={v.get('default')}
          />
          {options}
        </div>
      ) : (
        <div key={k}>
          <Checkbox
            label={v.get('title')}
            defaultChecked={v.get('default')}
            style={{padding: '15px 0px 5px'}}
          />
        </div>
      )
    }).toList()
    return (
      <div style={{margin: '10px 50px'}}>
        {elements}
      </div>
    )
  }
}
