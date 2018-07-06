import React from 'react'
import PropTypes from 'prop-types'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import { Link } from 'react-router-dom'
import Immutable from 'immutable'
import moment from 'moment'

import Button from '@material-ui/core/Button'
import Radio from '@material-ui/core/Radio'
import FormControlLabel from '@material-ui/core/FormControlLabel'
import { DatePicker } from 'material-ui-pickers'

import { reduxForm, Field } from 'redux-form/immutable'
import { RadioGroup, TextField } from 'redux-form-material-ui'

import AppBaseComponent from '../components/AppBaseComponent'

import * as actions from '../actions'
import { ROUTES, ENUMS } from '../constants'

class TimeCardEntry extends AppBaseComponent {
  static propTypes = {
    actions: PropTypes.object.isRequired,
    state: PropTypes.object.isRequired,
    bizDate: PropTypes.object.isRequired
  }

  componentWillMount() {
    const { bizDate } = this.props
    if (!this.props.state.getIn(['api', 'TIMECARD_LOAD_SUCCESS'])) {
      this.props.actions.timecardLoadAction(bizDate.format('YYYYMM'))
      this.props.actions.initializeTimecardEntry({ entryDate: bizDate.clone().toDate() })
    } else {
      const day = this.props.state.getIn(['api', 'TIMECARD_LOAD_SUCCESS', 'days'], Immutable.List()).filter(v => v.get('bizDate') === bizDate.format('YYYY-MM-DD')).first() || Immutable.Map()
      this.props.actions.initializeTimecardEntry({
        entryDate: bizDate.clone().toDate(),
        startDatetime: day.get('startDatetime') ? moment(day.get('startDatetime')).format('HH:mm') : '',
        endDatetime: day.get('endDatetime') ? moment(day.get('endDatetime')).format('HH:mm') : '',
        vacationType: day.get('vacationType') || ENUMS.VACATION_TYPE.NOTHING.name,
        note: day.get('note')
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
        endDatetime: day.get('endDatetime') ? moment(day.get('endDatetime')).format('HH:mm') : '',
        vacationType: day.get('vacationType') || ENUMS.VACATION_TYPE.NOTHING.name,
        note: day.get('note')
      })
    }
  }

  selectStartDatetime() {
    // this.inputStartDatetime.getRenderedComponent().getRenderedComponent().input.setSelectionRange(0, this.inputStartDatetime.getRenderedComponent().getRenderedComponent().input.value.length)
    // this.inputStartDatetime.getRenderedComponent().getRenderedComponent().focus()
  }

  render() {
    const date = this.props.bizDate
    // const dateColor = date.weekday() === 0 ? 'red': date.weekday() === 6 ? 'blue' : undefined
    return (
      <div style={{ margin: '10px' }}>
        <Button variant='contained' color='primary' style={{ marginLeft: '10px' }} component={Link} to={ROUTES.USER_TIMECARD(date.format('YYYYMM'))}>一覧</Button>
        <Button variant='contained' color='primary' style={{ marginLeft: '10px' }} component={Link} to={ROUTES.TIMECARD_ENTRY(`/${date.clone().add(-1, 'days').format('YYYYMMDD')}`)}>前日</Button>
        <Button variant='contained' color='primary' style={{ marginLeft: '10px' }} component={Link} to={ROUTES.TIMECARD_ENTRY(`/${date.clone().add(1, 'days').format('YYYYMMDD')}`)}>翌日</Button>
        <form>
          {/* <Field name='entryDate' component={DatePicker} autoOk={true} formatDate={(date) => date ? moment(date).format('YYYY/MM/DD(ddd)') : ''} container='inline' floatingLabelText="業務日" inputStyle={{ color: dateColor }} /> */}
          <div>
            <Field
              name="entryDate"
              component={({
                timezone,
                showErrorsInline,
                input: { onChange, value, name },
                meta: { touched, error, form },
                dispatch,
                ...other
              }) => (
                <DatePicker
                  name={name}
                  error={touched && Boolean(error)}
                  helperText={touched && error}
                  value={value}
                  onChange={onChange}
                  format="YYYY/MM/DD"
                  {...other}
                />
              )}
              fullWidth
              label='業務日'
              placeholder="2018/1/1"
              autoOk
              animateYearScrolling={false}
            />
          </div>
          <div>
            <Field name='startDatetime' component={TextField} label='開始時間' placeholder='09:00' withRef ref={(input) => this.inputStartDatetime = input} />
          </div>
          <div>
            <Field name='endDatetime' component={TextField} label='終了時間' placeholder='18:00' />
          </div>
          <div style={{ marginTop: '10px' }}>
            <Button
              variant='contained'
              color='primary'
              onClick={() => {
                this.props.actions.timecardEntryAction()
                super.handleUrlChange(ROUTES.TIMECARD_ENTRY(`/${date.clone().add(1, 'days').format('YYYYMMDD')}`))
                this.selectStartDatetime()
              }}
            >
              登録
            </Button>
          </div>
          <div>
            <Field name='note' component={TextField} label='備考' placeholder='客先作業 - 帰社' />
          </div>
          <div>
            <Field name='vacationType' component={RadioGroup}>
              <FormControlLabel value='NOTHING' control={<Radio color='primary' />} label={ENUMS.VACATION_TYPE.NOTHING.description} />
              <FormControlLabel value='PAID_DAY_OFF' control={<Radio color='primary' />} label={ENUMS.VACATION_TYPE.PAID_DAY_OFF.description} />
              <FormControlLabel value='SP_DAY_OFF' control={<Radio color='primary' />} label={ENUMS.VACATION_TYPE.SP_DAY_OFF.description} />
              <FormControlLabel value='AM_OFF' control={<Radio color='primary' />} label={ENUMS.VACATION_TYPE.AM_OFF.description} />
              <FormControlLabel value='PM_OFF' control={<Radio color='primary' />} label={ENUMS.VACATION_TYPE.PM_OFF.description} />
              <FormControlLabel value='TRANSFER_DAY_OFF' control={<Radio color='primary' />} label={ENUMS.VACATION_TYPE.TRANSFER_DAY_OFF.description} />
            </Field>
          </div>
        </form>
      </div>
    )
  }
}

function mapStateToProps(state, ownProps) {
  const paramDate = moment(ownProps.match.params.date, 'YYYYMMDD')
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
