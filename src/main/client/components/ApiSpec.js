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
    const children = property.get('properties')
    console.log(level, name, property.get('description'), property.get('type').join(', '))
    if (children === undefined) return
    Immutable.List(Object.keys(children.toJS())).flatMap((key) => {
      const childProperty = children.get(key)
      if (childProperty.get('type').contains('object')) {
        this.propertyRows(key, childProperty, level + 1)
      } else if (childProperty.get('type').contains('array')) {
        const items = childProperty.get('items').get('properties')
        Immutable.List(Object.keys(items.toJS())).map((itemName) => {
          this.propertyRows(itemName, items.get(itemName), level + 1)
        })
      }
    })
  }

  render() {
    this.propertyRows('ROOT', Immutable.fromJS(Parser.parse(schemaJson)), 0)
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
            {/*rows*/}
          </TableBody>
        </Table>
      </div>
    )
  }
}
