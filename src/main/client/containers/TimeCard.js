import React, { PropTypes } from 'react'
import { connect } from 'react-redux'

import {Toolbar, ToolbarGroup, ToolbarSeparator, ToolbarTitle} from 'material-ui/Toolbar'
import { Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn } from 'material-ui/Table'
import RaisedButton from 'material-ui/RaisedButton'

import AppBaseComponent from '../components/AppBaseComponent'

class TimeCard extends AppBaseComponent {
  static propTypes = {
  }

  render() {
    return (
      <div>
        <div style={{margin: '10px'}}>
          <RaisedButton label='TOP' onClick={() => {super.handleUrlChange('/')}} />
        </div>
        <Toolbar>
          <ToolbarGroup>
            <ToolbarTitle text="2017/01" />
          </ToolbarGroup>
        </Toolbar>
        <div>
          <Table>
            <TableHeader displaySelectAll={false} adjustForCheckbox={false}>
              <TableRow>
                <TableHeaderColumn>Date</TableHeaderColumn>
                <TableHeaderColumn>Start</TableHeaderColumn>
                <TableHeaderColumn>End</TableHeaderColumn>
              </TableRow>
            </TableHeader>
            <TableBody displayRowCheckbox={false}>
              <TableRow>
                <TableRowColumn>1/1</TableRowColumn>
                <TableRowColumn>9:00</TableRowColumn>
                <TableRowColumn>18:00</TableRowColumn>
              </TableRow>
              <TableRow>
                <TableRowColumn>1/2</TableRowColumn>
                <TableRowColumn>9:00</TableRowColumn>
                <TableRowColumn>18:00</TableRowColumn>
              </TableRow>
              <TableRow>
                <TableRowColumn>1/3</TableRowColumn>
                <TableRowColumn>9:00</TableRowColumn>
                <TableRowColumn>18:00</TableRowColumn>
              </TableRow>
              <TableRow>
                <TableRowColumn>1/4</TableRowColumn>
                <TableRowColumn>9:00</TableRowColumn>
                <TableRowColumn>18:00</TableRowColumn>
              </TableRow>
            </TableBody>
          </Table>
        </div>
      </div>
    )
  }
}

function mapStateToProps(state, ownProps) {
  return {
  }
}

export default connect(mapStateToProps, {
})(TimeCard)
