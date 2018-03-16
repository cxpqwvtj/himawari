import React from 'react'
import PropTypes from 'prop-types'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import { Link } from 'react-router'
import Immutable from 'immutable'
import moment from 'moment'

import { Toolbar, ToolbarGroup, ToolbarTitle } from 'material-ui/Toolbar'
import { Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn } from 'material-ui/Table'
import RaisedButton from 'material-ui/RaisedButton'

import AppBaseComponent from '../components/AppBaseComponent'

import * as actions from '../actions'
import { ROUTES, ENUMS } from '../constants'

class TimeCard extends AppBaseComponent {
  static propTypes = {
    actions: PropTypes.object.isRequired,
    params: PropTypes.object.isRequired,
    timecard: PropTypes.object
  }

  componentWillMount() {
    this.props.actions.timecardLoadAction(this.props.params.yearMonth)
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.params.yearMonth !== this.props.params.yearMonth) {
      this.props.actions.timecardLoadAction(nextProps.params.yearMonth)
    }
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
      const vacationTypeName = (ENUMS.VACATION_TYPE[v.get('vacationType')] || {}).description
      return (
        <TableRow key={i} style={{backgroundColor}}>
          <TableRowColumn><Link to={ROUTES.TIMECARD_ENTRY(`/${bizDate.format('YYYYMMDD')}`)}>{bizDate.format('MM/DD(ddd)')}</Link></TableRowColumn>
          <TableRowColumn>{start}</TableRowColumn>
          <TableRowColumn>{end}</TableRowColumn>
          <TableRowColumn>{vacationTypeName}</TableRowColumn>
          <TableRowColumn>{v.get('note')}</TableRowColumn>
        </TableRow>
      )
    })
    const buttonMargin = {margin: '10px'}
    const currentMonth = yearMonth.clone().format('YYYYMM')
    const prevMonth = yearMonth.clone().add(-1, 'months').format('YYYYMM')
    const nextMonth = yearMonth.clone().add(1, 'months').format('YYYYMM')
    return (
      <div>
        <div>
          <RaisedButton label='前月' style={buttonMargin} onClick={() => { super.handleUrlChange(ROUTES.USER_TIMECARD(prevMonth)) }} />
          <RaisedButton label='次月' style={buttonMargin} onClick={() => { super.handleUrlChange(ROUTES.USER_TIMECARD(nextMonth)) }} />
          <RaisedButton label='EXCEL' style={buttonMargin} onClick={() => { window.open(ROUTES.USER_TIMECARD_EXCEL(currentMonth), '_blank') }} />
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
  return {
    timecard: state.getIn(['api', 'TIMECARD_LOAD_SUCCESS']),
    params: ownProps.params
  }
}

function mapDispatchToProps(dispatch) {
  return { actions: bindActionCreators(actions, dispatch) }
}

export default connect(mapStateToProps, mapDispatchToProps)(TimeCard)
