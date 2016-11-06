import React, { PropTypes } from 'react'
import Parser from 'json-schema-parser'
import Immutable from 'immutable'
import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table'
import FlatButton from 'material-ui/FlatButton'

import AppBaseComponent from '../components/AppBaseComponent'

import schemaJson from '../../../../docs/schema/schema.json'

export default class ApiSpec extends AppBaseComponent {
  static propTypes = {
  }

  levelColomnStyle = { width: '10px' }

  jsonTable(name, property) {
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
              <TableHeaderColumn style={this.levelColomnStyle}>level</TableHeaderColumn>
              <TableHeaderColumn>name</TableHeaderColumn>
              <TableHeaderColumn>description</TableHeaderColumn>
              <TableHeaderColumn>type</TableHeaderColumn>
              <TableHeaderColumn>format</TableHeaderColumn>
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
    const format = property.get('format') || property.get('pattern')
    const itemsProperties = property.get('items') && property.get('items').get('properties') ? property.get('items').get('properties') : undefined
    const properties = property.get('properties') || itemsProperties
    const rows = Immutable.List.of(
      <TableRow key={`${level}${name}`}>
        <TableRowColumn style={Object.assign({}, this.levelColomnStyle, { paddingLeft: `${24 + ((level - 1) * 5)}px` })}>{level}</TableRowColumn>
        <TableRowColumn>{name}</TableRowColumn>
        <TableRowColumn>{description}</TableRowColumn>
        <TableRowColumn>{types.join(', ')}</TableRowColumn>
        <TableRowColumn>{format}</TableRowColumn>
      </TableRow>
    )
    const children = properties ? properties.map((v, k) => this.propertyRows(k, v, level + 1) ).toList().flatMap((v) => v) : undefined
    return children ? rows.concat(children) : rows
  }

  render() {
    const schema = Parser.parse(schemaJson)
    const properties = Immutable.fromJS(schema.properties)
    const jsonSpecs = properties.map((v, k) => this.jsonTable(k, v)).toList()
    return (
      <div style={{margin: '10px'}}>
        <div>
          <FlatButton label='TOP' onClick={() => {super.handleUrlChange('')}} />
        </div>
        {jsonSpecs}
      </div>
    )
  }
}
