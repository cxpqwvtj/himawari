import React, { PropTypes } from 'react'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import Immutable from 'immutable'
import moment from 'moment'

import LinearProgress from 'material-ui/LinearProgress'
import {Toolbar, ToolbarGroup, ToolbarSeparator, ToolbarTitle} from 'material-ui/Toolbar'
import { Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn } from 'material-ui/Table'
import RaisedButton from 'material-ui/RaisedButton'

import AppBaseComponent from '../components/AppBaseComponent'

import * as actions from '../actions'
import { ROUTES } from '../constants'

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
    const yearMonth = moment(this.props.timecard.get('yearMonth'), 'YYYYMM')
    const res = this.props.timecard.get('days', Immutable.fromJS([])).reduce((r, v) => {
      return r.merge({[v.get('bizDate')]: v})
    }, Immutable.fromJS({}))
    const days = Immutable.Range(0, yearMonth.clone().endOf('month').diff(yearMonth.clone().startOf('month'), 'days') + 1, 1).map(v => {
      return yearMonth.clone().add(v, 'days')
    }).map(v => {
      return res.get(v.format('YYYY-MM-DD')) || Immutable.fromJS({bizDate: v.format('YYYY-MM-DD')})
    })
    const rows = days.map((v, i) => {
      const bizDate = moment(v.get('bizDate'))
      const start = v.get('startDatetime') ? moment(v.get('startDatetime')).format('HH:mm') : ''
      const end = v.get('endDatetime') ? moment(v.get('endDatetime')).format('HH:mm') : ''
      const backgroundColor = bizDate.weekday() === 0 ? '#e7bdbd': bizDate.weekday() === 6 ? '#a7d0eb' : undefined
      return (
        <TableRow key={i} style={{backgroundColor}}>
          <TableRowColumn>{bizDate.format('MM/DD(ddd)')}</TableRowColumn>
          <TableRowColumn>{start}</TableRowColumn>
          <TableRowColumn>{end}</TableRowColumn>
          <TableRowColumn>{v.get('vacationTypeCode')}</TableRowColumn>
          <TableRowColumn>{v.get('note')}</TableRowColumn>
        </TableRow>
      )
    })
    const buttonMargin = {margin: '10px'}
    const prevMonth = yearMonth.clone().add(-1, 'months').format('YYYYMM')
    const nextMonth = yearMonth.clone().add(1, 'months').format('YYYYMM')
    return (
      <div>
        <div>
          <RaisedButton label='前月' style={buttonMargin} onClick={() => {
            super.handleUrlChange(ROUTES.USER_TIMECARD(prevMonth))
            this.props.actions.timecardLoadAction(prevMonth)
          }} />
          <RaisedButton label='次月' style={buttonMargin} onClick={() => {
            super.handleUrlChange(ROUTES.USER_TIMECARD(nextMonth))
            this.props.actions.timecardLoadAction(nextMonth)
          }} />
        </div>
        <Toolbar>
          <ToolbarGroup>
            <ToolbarTitle text={yearMonth.format('YYYY年MM月')} />
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
