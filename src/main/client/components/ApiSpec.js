import React, { PropTypes } from 'react'
import Parser from 'json-schema-parser'
import Immutable from 'immutable'
import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table'
import FlatButton from 'material-ui/FlatButton'

import AppBaseComponent from '../components/AppBaseComponent'

import timecard from '../../../../docs/schema/schemata/timecard.yml'

export default class ApiSpec extends AppBaseComponent {
  static propTypes = {
  }

  levelColomnStyle = { width: '10px' }
  typeColomnStyle = { width: '50px' }
  rowHeightStyle = { height: '30px' }

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
              <TableHeaderColumn style={Object.assign({}, this.rowHeightStyle, this.levelColomnStyle)}>level</TableHeaderColumn>
              <TableHeaderColumn style={Object.assign({}, this.rowHeightStyle)}>name</TableHeaderColumn>
              <TableHeaderColumn style={Object.assign({}, this.rowHeightStyle, this.typeColomnStyle)}>type</TableHeaderColumn>
              <TableHeaderColumn style={Object.assign({}, this.rowHeightStyle)}>description</TableHeaderColumn>
              <TableHeaderColumn style={Object.assign({}, this.rowHeightStyle)}>format</TableHeaderColumn>
              <TableHeaderColumn style={Object.assign({}, this.rowHeightStyle)}>pattern</TableHeaderColumn>
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
      <TableRow key={`${level}${name}`} style={Object.assign({}, this.rowHeightStyle)}>
        <TableRowColumn style={Object.assign({}, this.rowHeightStyle, this.levelColomnStyle, { paddingLeft: `${24 + ((level - 1) * 5)}px` })}>{level}</TableRowColumn>
        <TableRowColumn style={Object.assign({}, this.rowHeightStyle)}>{name}</TableRowColumn>
        <TableRowColumn style={Object.assign({}, this.rowHeightStyle, this.typeColomnStyle)}>{types.join(', ')}</TableRowColumn>
        <TableRowColumn style={Object.assign({}, this.rowHeightStyle)}>{description}</TableRowColumn>
        <TableRowColumn style={Object.assign({}, this.rowHeightStyle)}>{format}</TableRowColumn>
        <TableRowColumn style={Object.assign({}, this.rowHeightStyle)}>{pattern}</TableRowColumn>
      </TableRow>
    )
    const children = properties ? properties.map((v, k) => this.propertyRows(k, v, level + 1) ).toList().flatMap((v) => v) : undefined
    return children ? rows.concat(children) : rows
  }

  render() {
    const spec = this.createTable('timecard', Immutable.fromJS(Parser.parse(timecard)))
    return (
      <div style={{margin: '10px 50px'}}>
        <div>
          <FlatButton label='TOP' onClick={() => {super.handleUrlChange('')}} />
        </div>
        {spec}
      </div>
    )
  }
}
