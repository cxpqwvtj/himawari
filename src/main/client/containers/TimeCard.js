import React, { PropTypes } from 'react'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import Immutable from 'immutable'
import moment from 'moment'

import {Toolbar, ToolbarGroup, ToolbarSeparator, ToolbarTitle} from 'material-ui/Toolbar'
import { Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn } from 'material-ui/Table'
import RaisedButton from 'material-ui/RaisedButton'

import AppBaseComponent from '../components/AppBaseComponent'

import * as actions from '../actions'

class TimeCard extends AppBaseComponent {
  static propTypes = {
    actions: PropTypes.object.isRequired,
    params: PropTypes.object.isRequired,
    timecard: PropTypes.object
  }

  componentDidMount() {
    this.props.actions.timecardLoadAction(this.props.params.yearMonth)
  }

  render() {
    if (!this.props.timecard) {
      return <div></div>
    }
    const rows = this.props.timecard.get('days', Immutable.fromJS([])).map((v, i) => {
      const bizDate = moment(v.get('bizDate')).format('YYYY/MM/DD(ddd)')
      const start = v.get('startDatetime') ? moment(v.get('startDatetime')).format('HH:mm') : ''
      const end = v.get('endDatetime') ? moment(v.get('endDatetime')).format('HH:mm') : ''
      return (
        <TableRow key={i}>
          <TableRowColumn>{bizDate}</TableRowColumn>
          <TableRowColumn>{start}</TableRowColumn>
          <TableRowColumn>{end}</TableRowColumn>
          <TableRowColumn>{v.get('vacationTypeCode')}</TableRowColumn>
          <TableRowColumn>{v.get('note')}</TableRowColumn>
        </TableRow>
      )
    })
    const buttonMargin = {margin: '10px'}
    return (
      <div>
        <div>
          <RaisedButton label='TOP' style={buttonMargin} onClick={() => {super.handleUrlChange('/')}} />
          <RaisedButton label='テスト' style={buttonMargin} onClick={() => {this.props.actions.timecardLoadAction(this.props.params.yearMonth)}} />
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
              {rows}
            </TableBody>
          </Table>
        </div>
      </div>
    )
  }
}

function mapStateToProps(state, ownProps) {
  const s = Immutable.fromJS(state)
  return {
    timecard: s.getIn(['api', 'TIMECARD_LOAD_SUCCESS']),
    params: ownProps.params
  }
}

function mapDispatchToProps(dispatch) {
  return { actions: bindActionCreators(actions, dispatch) }
}

export default connect(mapStateToProps, mapDispatchToProps)(TimeCard)
