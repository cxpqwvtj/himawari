import React, { PropTypes } from 'react'
import ReactDOM from 'react-dom'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import Immutable from 'immutable'
import moment from 'moment'

import LinearProgress from 'material-ui/LinearProgress'
import {Toolbar, ToolbarGroup, ToolbarSeparator, ToolbarTitle} from 'material-ui/Toolbar'
import { Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn } from 'material-ui/Table'
import RaisedButton from 'material-ui/RaisedButton'
import { RadioButton } from 'material-ui/RadioButton'

import { reduxForm, Field } from 'redux-form'
import { Checkbox, RadioButtonGroup, SelectField, TextField, Toggle, DatePicker, TimePicker } from 'redux-form-material-ui'
import TextFieldOrg from 'material-ui/TextField'

import AppBaseComponent from '../components/AppBaseComponent'

import * as actions from '../actions'
import { ROUTES, WORDING } from '../constants'

class TimeCardEntry extends AppBaseComponent {
  static propTypes = {
    actions: PropTypes.object.isRequired,
    state: PropTypes.object.isRequired,
    bizDate: PropTypes.object.isRequired
  }

  componentWillMount() {
    const {bizDate} = this.props
    if (!this.props.state.getIn(['api', 'TIMECARD_LOAD_SUCCESS'])) {
      this.props.actions.timecardLoadAction(bizDate.format('YYYYMM'))
      this.props.actions.initializeTimecardEntry({entryDate: bizDate.clone().toDate()})
    } else {
      const day = this.props.state.getIn(['api', 'TIMECARD_LOAD_SUCCESS', 'days'], Immutable.List()).filter(v => v.get('bizDate') === bizDate.format('YYYY-MM-DD')).first() || Immutable.Map()
      this.props.actions.initializeTimecardEntry({
        entryDate: bizDate.clone().toDate(),
        startDatetime: day.get('startDatetime') ? moment(day.get('startDatetime')).format('HH:mm') : '',
        endDatetime: day.get('endDatetime') ? moment(day.get('endDatetime')).format('HH:mm') : ''
      })
    }
  }

  componentDidMount() {
    this.selectStartDatetime()
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.bizDate.format('YYYYMMDD') !== this.props.bizDate.format('YYYYMMDD')) {
      const day = this.props.state.getIn(['api', 'TIMECARD_LOAD_SUCCESS', 'days'], Immutable.List()).filter(v => v.get('bizDate') === nextProps.bizDate.format('YYYY-MM-DD')).first() || Immutable.Map()
      this.props.actions.initializeTimecardEntry({
        entryDate: nextProps.bizDate.clone().toDate(),
        startDatetime: day.get('startDatetime') ? moment(day.get('startDatetime')).format('HH:mm') : '',
        endDatetime: day.get('endDatetime') ? moment(day.get('endDatetime')).format('HH:mm') : ''
      })
    }
  }

  selectStartDatetime() {
    this.inputStartDatetime.getRenderedComponent().getRenderedComponent().focus()
    this.inputStartDatetime.getRenderedComponent().getRenderedComponent().input.setSelectionRange(0, this.inputStartDatetime.getRenderedComponent().getRenderedComponent().input.value.length)
  }

  render() {
    const date = this.props.bizDate
    const dateColor = date.weekday() === 0 ? 'red': date.weekday() === 6 ? 'blue' : undefined
    return (
      <div style={{margin: '10px'}}>
        <RaisedButton label='一覧' style={{marginLeft: '10px'}} onClick={() => super.handleUrlChange(ROUTES.USER_TIMECARD(date.format('YYYYMM')))} />
        <RaisedButton label='前日' style={{marginLeft: '10px'}} onClick={() => super.handleUrlChange(ROUTES.TIMECARD_ENTRY(`/${date.clone().add(-1, 'days').format('YYYYMMDD')}`))} />
        <RaisedButton label='翌日' style={{marginLeft: '10px'}} onClick={() => super.handleUrlChange(ROUTES.TIMECARD_ENTRY(`/${date.clone().add(1, 'days').format('YYYYMMDD')}`))} />
        <form>
          <div>
            <Field name='entryDate' component={DatePicker} autoOk={true} formatDate={(date) => date ? moment(date).format('YYYY/MM/DD(ddd)') : ''} container='inline' floatingLabelText="業務日" inputStyle={{color: dateColor}} />
          </div>
          <div>
            <Field name='startDatetime' component={TextField} floatingLabelText='開始時間' hintText='09:00' withRef ref={(input) => this.inputStartDatetime = input} />
          </div>
          <div>
            <Field name='endDatetime' component={TextField} floatingLabelText='終了時間' hintText='18:00' />
          </div>
          <div>
            <RaisedButton label='登録' onClick={() => {
              this.props.actions.timecardEntryAction()
              super.handleUrlChange(ROUTES.TIMECARD_ENTRY(`/${date.clone().add(1, 'days').format('YYYYMMDD')}`))
              this.selectStartDatetime()
            }} />
          </div>
          <div>
            <Field name='note' component={TextField} floatingLabelText='備考' hintText='客先作業 -> 帰社' />
          </div>
          <div>
            <Field name='vacationType' component={RadioButtonGroup}>
              <RadioButton value='NOTHING' label={WORDING.VACATION_TYPE.NOTHING} />
              <RadioButton value='PAID_DAY_OFF' label={WORDING.VACATION_TYPE.PAID_DAY_OFF} />
              <RadioButton value='SP_DAY_OFF' label={WORDING.VACATION_TYPE.SP_DAY_OFF} />
              <RadioButton value='AM_OFF' label={WORDING.VACATION_TYPE.AM_OFF} />
              <RadioButton value='PM_OFF' label={WORDING.VACATION_TYPE.PM_OFF} />
              <RadioButton value='TRANSFER_DAY_OFF' label={WORDING.VACATION_TYPE.TRANSFER_DAY_OFF} />
            </Field>
          </div>
        </form>
      </div>
    )
  }
}

function mapStateToProps(state, ownProps) {
  const paramDate = moment(ownProps.params.date, 'YYYYMMDD')
  const bizDate = paramDate.isValid() ? paramDate : moment().startOf('day')
  return {
    state: Immutable.fromJS(state),
    bizDate
  }
}

function mapDispatchToProps(dispatch) {
  return { actions: bindActionCreators(actions, dispatch) }
}

export default connect(mapStateToProps, mapDispatchToProps)(reduxForm({
  form: 'timecardEntry'
})(TimeCardEntry))
