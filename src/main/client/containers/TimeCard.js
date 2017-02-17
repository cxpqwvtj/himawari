import React, { PropTypes } from 'react'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'

import {Toolbar, ToolbarGroup, ToolbarSeparator, ToolbarTitle} from 'material-ui/Toolbar'
import { Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn } from 'material-ui/Table'
import RaisedButton from 'material-ui/RaisedButton'

import AppBaseComponent from '../components/AppBaseComponent'

import * as actions from '../actions'

class TimeCard extends AppBaseComponent {
  static propTypes = {
    actions: PropTypes.object.isRequired,
    params: PropTypes.object.isRequired
  }

  render() {
    return (
      <div>
        <div style={{margin: '10px'}}>
          <RaisedButton label='TOP' onClick={() => {super.handleUrlChange('/')}} />
          <RaisedButton label='テスト' onClick={() => {this.props.actions.timecardLoadAction(this.props.params.yearMonth)}} />
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
                <TableHeaderColumn>年月日</TableHeaderColumn>
                <TableHeaderColumn>開始時間</TableHeaderColumn>
                <TableHeaderColumn>終了時間</TableHeaderColumn>
                <TableHeaderColumn>休暇タイプ</TableHeaderColumn>
                <TableHeaderColumn>備考</TableHeaderColumn>
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
    params: ownProps.params
  }
}

function mapDispatchToProps(dispatch) {
  return { actions: bindActionCreators(actions, dispatch) }
}

export default connect(mapStateToProps, mapDispatchToProps)(TimeCard)
