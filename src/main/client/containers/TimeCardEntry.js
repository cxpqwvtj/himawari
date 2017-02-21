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

import { reduxForm, Field } from 'redux-form'
import { Checkbox, RadioButtonGroup, SelectField, TextField, Toggle, DatePicker, TimePicker } from 'redux-form-material-ui'
import TextFieldOrg from 'material-ui/TextField'

import AppBaseComponent from '../components/AppBaseComponent'

import * as actions from '../actions'
import { ROUTES } from '../constants'

class TimeCardEntry extends AppBaseComponent {
  static propTypes = {
    actions: PropTypes.object.isRequired,
    state: PropTypes.object.isRequired,
    params: PropTypes.object.isRequired
  }

  componentWillMount() {
    const bizDate = moment(this.props.params.get('date', moment().format('YYYYMMDD')), 'YYYYMMDD').startOf('day')
    this.props.actions.initializeTimecardEntry({
      entryDate: bizDate.clone().toDate(),
      startDatetime: bizDate.clone().hour(9).format('HH:mm'),
      endDatetime: bizDate.clone().hour(18).format('HH:mm')
    })
  }

  componentDidMount() {
    this.inputStartDatetime.getRenderedComponent().getRenderedComponent().focus()
  }

  render() {
    const date = moment(this.props.params.get('date', moment().format('YYYYMMDD')), 'YYYYMMDD')
    return (
      <div style={{margin: '10px'}}>
        <RaisedButton label='一覧へ戻る' onClick={() => super.handleUrlChange(ROUTES.USER_TIMECARD(date.format('YYYYMM')))} />
        <RaisedButton label='focus' onClick={() => this.inputStartDatetime.getRenderedComponent().getRenderedComponent().focus()} />
        <form>
          <div>
            <Field name='entryDate' component={DatePicker} autoOk={true} formatDate={(date) => moment(date).format('YYYY/MM/DD(ddd)')} container='inline' hintText="業務日" />
          </div>
          <div>
            <Field name='startDatetime' component={TextField} hintText='開始時間' withRef ref={(input) => this.inputStartDatetime = input} />
          </div>
          <div>
            <Field name='endDatetime' component={TextField} hintText='終了時間' />
          </div>
          <div>
            <RaisedButton label='登録' />
          </div>
        </form>
      </div>
    )
  }
}

function mapStateToProps(state, ownProps) {
  return {
    state: Immutable.fromJS(state),
    params: Immutable.fromJS(ownProps.params)
  }
}

function mapDispatchToProps(dispatch) {
  return { actions: bindActionCreators(actions, dispatch) }
}

export default connect(mapStateToProps, mapDispatchToProps)(reduxForm({
  form: 'timecardEntry'
})(TimeCardEntry))
