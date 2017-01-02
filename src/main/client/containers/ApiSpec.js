import React, { PropTypes } from 'react'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import Immutable from 'immutable'

import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table'
import TextField from 'material-ui/TextField'

import AppBaseComponent from '../components/AppBaseComponent'

import * as actions from '../actions'

import { schema } from '../constants'

export class ApiSpec extends AppBaseComponent {
  static propTypes = {
  }

  levelColomnStyle = { width: '10px' }
  typeColomnStyle = { width: '50px' }

  constructor(props) {
    super(props)

    this.state = {
      searchText: ''
    }
  }

  handleChange = (event) => {
    this.setState({
      searchText: event.target.value,
    })
  }

  createTable(name, property) {
    const rows = property.get('properties').map((v, k) => this.propertyRows(k, v, 1)).toList().flatMap((v) => v)
    return (
      <div key={name} style={{marginTop: 20}}>
        <hr />
        <div>{name}</div>
        <div>title {property.get('title')}</div>
        <div>description {property.get('description')}</div>
        <div>stability {property.get('stability')}</div>
        <div>strictProperties {property.get('strictProperties') ? 'true' : 'false'}</div>
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
    const specs = Immutable.fromJS(schema).map((v, k) => {
      return this.createTable(k, v)
    }).toList()
    return (
      <div style={{margin: '10px 50px'}}>
        <div>
          <TextField
            hintText='api1'
            floatingLabelText='search'
            value={this.state.searchText}
            onChange={this.handleChange}
          />
        </div>
        {specs}
      </div>
    )
  }
}

function mapStateToProps(state, ownProps) {
  return {
  }
}

function mapDispatchToProps(dispatch) {
  return { actions: bindActionCreators(actions, dispatch) }
}

export default connect(mapStateToProps, mapDispatchToProps)(ApiSpec)
