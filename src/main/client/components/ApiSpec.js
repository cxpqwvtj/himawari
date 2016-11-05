import React, { PropTypes } from 'react'
import Parser from 'json-schema-parser'
import Immutable from 'immutable'
import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table'

import AppBaseComponent from '../components/AppBaseComponent'

import schemaJson from '../../../../docs/schema/schema.json'

export default class ApiSpec extends AppBaseComponent {
  static propTypes = {
  }

  propertyRows(name, property, level) {
    const description = property.get('description')
    const types = property.get('type') || Immutable.List.of()
    const itemsProperties = property.get('items') && property.get('items').get('properties') ? property.get('items').get('properties') : undefined
    const properties = property.get('properties') || itemsProperties
    const rows = Immutable.List.of(
      <TableRow key={`${level}${name}`}>
        <TableRowColumn>{level}</TableRowColumn>
        <TableRowColumn>{name}</TableRowColumn>
        <TableRowColumn>{description}</TableRowColumn>
        <TableRowColumn>{types.join(', ')}</TableRowColumn>
      </TableRow>
    )
    const children = properties ? properties.map((v, k) => this.propertyRows(k, v, level + 1) ).toList().flatMap((v) => v) : undefined
    return children ? rows.concat(children) : rows
  }

  render() {
    const schema = Parser.parse(schemaJson)
    const properties = Immutable.fromJS(schema.properties)
    const rows = properties.map((v, k) => this.propertyRows(k, v, 0)).toList().flatMap((v) => v)
    return (
      <div>
        <Table>
          <TableHeader>
            <TableRow>
              <TableHeaderColumn>level</TableHeaderColumn>
              <TableHeaderColumn>name</TableHeaderColumn>
              <TableHeaderColumn>description</TableHeaderColumn>
              <TableHeaderColumn>type</TableHeaderColumn>
            </TableRow>
          </TableHeader>
          <TableBody>
            {rows}
          </TableBody>
        </Table>
      </div>
    )
  }
}
