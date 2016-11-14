import React, { PropTypes } from 'react'
import Parser from 'json-schema-parser'
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
    const settings = Immutable.fromJS(jsyaml.safeLoad(SettingsYaml).properties)
    const elements = settings.map((setting, index) => {
      const opts = setting.get('options')
      const options = opts ? opts.map((opt, index) => {
        return <RaisedButton label={opt.get('value')} key={index} style={{marginLeft: '10px'}} />
      }) : undefined
      return setting.get('type').indexOf('bool') < 0 ? (
        <div key={index}>
          <TextField
            floatingLabelText={setting.get('title')}
            defaultValue={setting.get('default')}
          />
          {options}
        </div>
      ) : (
        <div key={index}>
          <Checkbox
            label={setting.get('title')}
            defaultChecked={setting.get('default')}
            style={{padding: '15px 0px 5px'}}
          />
        </div>
      )
    })
    return (
      <div style={{margin: '10px 50px'}}>
        {elements}
      </div>
    )
  }
}
