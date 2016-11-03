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
    console.log(level, name, property.get('description'))
    const properties = property.get('properties')
    if (properties) {
      properties.map((v, k) => this.propertyRows(k, v, level + 1))
    } else if (property.get('items') && property.get('items').get('properties')) {
      property.get('items').get('properties').map((v, k) => this.propertyRows(k, v, level + 1))
    }
    return (
      <TableRow>
        <TableRowColumn>{level}</TableRowColumn>
        <TableRowColumn>{name}</TableRowColumn>
        <TableRowColumn>{property.get('description')}</TableRowColumn>
        <TableRowColumn>{property.get('type')}</TableRowColumn>
      </TableRow>
    )
  }

  render() {
    const schema = Parser.parse(schemaJson)
    const properties = Immutable.fromJS(schema.properties)
    console.log(properties.flatMap((v, k) => this.propertyRows(k, v, 0)).map((v, k) => v).toJS())
    const rows = undefined
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
