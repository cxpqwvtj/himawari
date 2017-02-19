import React, { PropTypes } from 'react'
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

import AppBaseComponent from '../components/AppBaseComponent'

import * as actions from '../actions'
import { ROUTES } from '../constants'

class TimeCardEntry extends AppBaseComponent {
  static propTypes = {
    actions: PropTypes.object.isRequired,
    state: PropTypes.object.isRequired
  }

  componentDidMount() {
    const bizDate = moment().startOf('day')
    this.props.actions.initializeTimecardEntry({
      entryDate: bizDate.clone().toDate(),
      startDatetime: bizDate.clone().hour(9).toDate(),
      endDatetime: bizDate.clone().hour(18).toDate()
    })
  }

  render() {
    return (
      <div style={{margin: '10px'}}>
        <form>
          <Field name="entryDate" component={DatePicker} format={null} container='inline' hintText="業務日"/>
          <Field name="startDatetime" component={TimePicker} format={null} hintText="開始時間"/>
          <Field name="endDatetime" component={TimePicker} format={null} hintText="終了時間"/>
        </form>
      </div>
    )
  }
}

function mapStateToProps(state, ownProps) {
  return {
    state: Immutable.fromJS(state),
    params: ownProps.params
  }
}

function mapDispatchToProps(dispatch) {
  return { actions: bindActionCreators(actions, dispatch) }
}

export default connect(mapStateToProps, mapDispatchToProps)(reduxForm({
  form: 'timecardEntry'
})(TimeCardEntry))
