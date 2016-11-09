import React, { PropTypes } from 'react'
import Parser from 'json-schema-parser'
import Immutable from 'immutable'
import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table'
import FlatButton from 'material-ui/FlatButton'
import TextField from 'material-ui/TextField'
import jsyaml from 'js-yaml'

import AppBaseComponent from '../components/AppBaseComponent'

import src from 'raw!../../../../docs/schema/schemata/timecard.yml'

export default class ApiSpec extends AppBaseComponent {
  static propTypes = {
  }

  levelColomnStyle = { width: '10px' }
  typeColomnStyle = { width: '50px' }

  createTable(name, property) {
    const rows = property.get('properties').map((v, k) => this.propertyRows(k, v, 1)).toList().flatMap((v) => v)
    return (
      <div key={name}>
        <div>{name}</div>
        <div>title {property.get('title')}</div>
        <div>description {property.get('description')}</div>
        <div>stability {property.get('stability')}</div>
        <div>strictProperties {property.get('strictProperties')}</div>
        <Table>
          <TableHeader adjustForCheckbox={false} displaySelectAll={false}>
            <TableRow>
              <TableHeaderColumn style={Object.assign({}, this.levelColomnStyle)}>level</TableHeaderColumn>
              <TableHeaderColumn style={Object.assign({})}>name</TableHeaderColumn>
              <TableHeaderColumn style={Object.assign({}, this.typeColomnStyle)}>type</TableHeaderColumn>
              <TableHeaderColumn style={Object.assign({})}>description</TableHeaderColumn>
              <TableHeaderColumn style={Object.assign({})}>format</TableHeaderColumn>
              <TableHeaderColumn style={Object.assign({})}>pattern</TableHeaderColumn>
            </TableRow>
          </TableHeader>
          <TableBody displayRowCheckbox={false}>
            {rows}
          </TableBody>
        </Table>
      </div>
    )
  }

  propertyRows(name, property, level) {
    const description = property.get('description')
    const types = property.get('type') || Immutable.List.of()
    const format = property.get('format')
    const pattern = property.get('pattern')
    const itemsProperties = property.get('items') && property.get('items').get('properties') ? property.get('items').get('properties') : undefined
    const properties = property.get('properties') || itemsProperties
    const rows = Immutable.List.of(
      <TableRow key={`${level}${name}`} style={Object.assign({})}>
        <TableRowColumn style={Object.assign({}, this.levelColomnStyle, { paddingLeft: `${24 + ((level - 1) * 5)}px` })}>{level}</TableRowColumn>
        <TableRowColumn style={Object.assign({})}>{name}</TableRowColumn>
        <TableRowColumn style={Object.assign({}, this.typeColomnStyle)}>{types.join(', ')}</TableRowColumn>
        <TableRowColumn style={Object.assign({})}>{description}</TableRowColumn>
        <TableRowColumn style={Object.assign({})}>{format}</TableRowColumn>
        <TableRowColumn style={Object.assign({})}>{pattern}</TableRowColumn>
      </TableRow>
    )
    const children = properties ? properties.map((v, k) => this.propertyRows(k, v, level + 1) ).toList().flatMap((v) => v) : undefined
    return children ? rows.concat(children) : rows
  }

  render() {
    const timecard = []
    jsyaml.safeLoadAll(src, (v) => timecard.push(v))
    const spec = this.createTable('timecard', Immutable.fromJS(Parser.parse(timecard[0])))
    return (
      <div style={{margin: '10px 50px'}}>
        <div>
          <FlatButton label='TOP' onClick={() => {super.handleUrlChange('')}} />
        </div>
        <div>
        <TextField
          hintText='api1'
          floatingLabelText='search'
        />
      </div>
        {spec}
      </div>
    )
  }
}
