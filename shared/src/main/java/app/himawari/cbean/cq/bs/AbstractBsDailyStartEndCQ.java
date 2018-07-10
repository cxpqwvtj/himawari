package app.himawari.cbean.cq.bs;

import java.util.*;

import org.dbflute.cbean.*;
import org.dbflute.cbean.chelper.*;
import org.dbflute.cbean.ckey.*;
import org.dbflute.cbean.coption.*;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.ordering.*;
import org.dbflute.cbean.scoping.*;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.dbmeta.DBMetaProvider;
import app.himawari.allcommon.*;
import app.himawari.cbean.*;
import app.himawari.cbean.cq.*;

/**
 * The abstract condition-query of DAILY_START_END.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsDailyStartEndCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsDailyStartEndCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    @Override
    protected DBMetaProvider xgetDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    public String asTableDbName() {
        return "DAILY_START_END";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param dailyStartEndId The value of dailyStartEndId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setDailyStartEndId_Equal(Long dailyStartEndId) {
        doSetDailyStartEndId_Equal(dailyStartEndId);
    }

    protected void doSetDailyStartEndId_Equal(Long dailyStartEndId) {
        regDailyStartEndId(CK_EQ, dailyStartEndId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param dailyStartEndId The value of dailyStartEndId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDailyStartEndId_NotEqual(Long dailyStartEndId) {
        doSetDailyStartEndId_NotEqual(dailyStartEndId);
    }

    protected void doSetDailyStartEndId_NotEqual(Long dailyStartEndId) {
        regDailyStartEndId(CK_NES, dailyStartEndId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param dailyStartEndId The value of dailyStartEndId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDailyStartEndId_GreaterThan(Long dailyStartEndId) {
        regDailyStartEndId(CK_GT, dailyStartEndId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param dailyStartEndId The value of dailyStartEndId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDailyStartEndId_LessThan(Long dailyStartEndId) {
        regDailyStartEndId(CK_LT, dailyStartEndId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param dailyStartEndId The value of dailyStartEndId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDailyStartEndId_GreaterEqual(Long dailyStartEndId) {
        regDailyStartEndId(CK_GE, dailyStartEndId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param dailyStartEndId The value of dailyStartEndId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDailyStartEndId_LessEqual(Long dailyStartEndId) {
        regDailyStartEndId(CK_LE, dailyStartEndId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param minNumber The min number of dailyStartEndId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of dailyStartEndId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setDailyStartEndId_RangeOf(Long minNumber, Long maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setDailyStartEndId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param minNumber The min number of dailyStartEndId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of dailyStartEndId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setDailyStartEndId_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueDailyStartEndId(), "DAILY_START_END_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param dailyStartEndIdList The collection of dailyStartEndId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDailyStartEndId_InScope(Collection<Long> dailyStartEndIdList) {
        doSetDailyStartEndId_InScope(dailyStartEndIdList);
    }

    protected void doSetDailyStartEndId_InScope(Collection<Long> dailyStartEndIdList) {
        regINS(CK_INS, cTL(dailyStartEndIdList), xgetCValueDailyStartEndId(), "DAILY_START_END_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param dailyStartEndIdList The collection of dailyStartEndId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDailyStartEndId_NotInScope(Collection<Long> dailyStartEndIdList) {
        doSetDailyStartEndId_NotInScope(dailyStartEndIdList);
    }

    protected void doSetDailyStartEndId_NotInScope(Collection<Long> dailyStartEndIdList) {
        regINS(CK_NINS, cTL(dailyStartEndIdList), xgetCValueDailyStartEndId(), "DAILY_START_END_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)}
     */
    public void setDailyStartEndId_IsNull() { regDailyStartEndId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)}
     */
    public void setDailyStartEndId_IsNotNull() { regDailyStartEndId(CK_ISNN, DOBJ); }

    protected void regDailyStartEndId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDailyStartEndId(), "DAILY_START_END_ID"); }
    protected abstract ConditionValue xgetCValueDailyStartEndId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * TIMECARD_DAY_ID: {IX, NotNull, BIGINT(19), FK to TIMECARD_DAY}
     * @param timecardDayId The value of timecardDayId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setTimecardDayId_Equal(Long timecardDayId) {
        doSetTimecardDayId_Equal(timecardDayId);
    }

    protected void doSetTimecardDayId_Equal(Long timecardDayId) {
        regTimecardDayId(CK_EQ, timecardDayId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * TIMECARD_DAY_ID: {IX, NotNull, BIGINT(19), FK to TIMECARD_DAY}
     * @param timecardDayId The value of timecardDayId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setTimecardDayId_NotEqual(Long timecardDayId) {
        doSetTimecardDayId_NotEqual(timecardDayId);
    }

    protected void doSetTimecardDayId_NotEqual(Long timecardDayId) {
        regTimecardDayId(CK_NES, timecardDayId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * TIMECARD_DAY_ID: {IX, NotNull, BIGINT(19), FK to TIMECARD_DAY}
     * @param timecardDayId The value of timecardDayId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setTimecardDayId_GreaterThan(Long timecardDayId) {
        regTimecardDayId(CK_GT, timecardDayId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * TIMECARD_DAY_ID: {IX, NotNull, BIGINT(19), FK to TIMECARD_DAY}
     * @param timecardDayId The value of timecardDayId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setTimecardDayId_LessThan(Long timecardDayId) {
        regTimecardDayId(CK_LT, timecardDayId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * TIMECARD_DAY_ID: {IX, NotNull, BIGINT(19), FK to TIMECARD_DAY}
     * @param timecardDayId The value of timecardDayId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setTimecardDayId_GreaterEqual(Long timecardDayId) {
        regTimecardDayId(CK_GE, timecardDayId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * TIMECARD_DAY_ID: {IX, NotNull, BIGINT(19), FK to TIMECARD_DAY}
     * @param timecardDayId The value of timecardDayId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setTimecardDayId_LessEqual(Long timecardDayId) {
        regTimecardDayId(CK_LE, timecardDayId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * TIMECARD_DAY_ID: {IX, NotNull, BIGINT(19), FK to TIMECARD_DAY}
     * @param minNumber The min number of timecardDayId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of timecardDayId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setTimecardDayId_RangeOf(Long minNumber, Long maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setTimecardDayId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * TIMECARD_DAY_ID: {IX, NotNull, BIGINT(19), FK to TIMECARD_DAY}
     * @param minNumber The min number of timecardDayId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of timecardDayId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setTimecardDayId_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueTimecardDayId(), "TIMECARD_DAY_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * TIMECARD_DAY_ID: {IX, NotNull, BIGINT(19), FK to TIMECARD_DAY}
     * @param timecardDayIdList The collection of timecardDayId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setTimecardDayId_InScope(Collection<Long> timecardDayIdList) {
        doSetTimecardDayId_InScope(timecardDayIdList);
    }

    protected void doSetTimecardDayId_InScope(Collection<Long> timecardDayIdList) {
        regINS(CK_INS, cTL(timecardDayIdList), xgetCValueTimecardDayId(), "TIMECARD_DAY_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * TIMECARD_DAY_ID: {IX, NotNull, BIGINT(19), FK to TIMECARD_DAY}
     * @param timecardDayIdList The collection of timecardDayId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setTimecardDayId_NotInScope(Collection<Long> timecardDayIdList) {
        doSetTimecardDayId_NotInScope(timecardDayIdList);
    }

    protected void doSetTimecardDayId_NotInScope(Collection<Long> timecardDayIdList) {
        regINS(CK_NINS, cTL(timecardDayIdList), xgetCValueTimecardDayId(), "TIMECARD_DAY_ID");
    }

    protected void regTimecardDayId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueTimecardDayId(), "TIMECARD_DAY_ID"); }
    protected abstract ConditionValue xgetCValueTimecardDayId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     * @param startDatetime The value of startDatetime as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setStartDatetime_Equal(java.time.LocalDateTime startDatetime) {
        regStartDatetime(CK_EQ,  startDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     * @param startDatetime The value of startDatetime as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setStartDatetime_GreaterThan(java.time.LocalDateTime startDatetime) {
        regStartDatetime(CK_GT,  startDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     * @param startDatetime The value of startDatetime as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setStartDatetime_LessThan(java.time.LocalDateTime startDatetime) {
        regStartDatetime(CK_LT,  startDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     * @param startDatetime The value of startDatetime as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setStartDatetime_GreaterEqual(java.time.LocalDateTime startDatetime) {
        regStartDatetime(CK_GE,  startDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     * @param startDatetime The value of startDatetime as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setStartDatetime_LessEqual(java.time.LocalDateTime startDatetime) {
        regStartDatetime(CK_LE, startDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     * <pre>e.g. setStartDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of startDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of startDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setStartDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setStartDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     * <pre>e.g. setStartDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of startDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of startDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setStartDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "START_DATETIME"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueStartDatetime(), nm, op);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     */
    public void setStartDatetime_IsNull() { regStartDatetime(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     */
    public void setStartDatetime_IsNotNull() { regStartDatetime(CK_ISNN, DOBJ); }

    protected void regStartDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueStartDatetime(), "START_DATETIME"); }
    protected abstract ConditionValue xgetCValueStartDatetime();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * END_DATETIME: {DATETIME(19)}
     * @param endDatetime The value of endDatetime as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setEndDatetime_Equal(java.time.LocalDateTime endDatetime) {
        regEndDatetime(CK_EQ,  endDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * END_DATETIME: {DATETIME(19)}
     * @param endDatetime The value of endDatetime as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setEndDatetime_GreaterThan(java.time.LocalDateTime endDatetime) {
        regEndDatetime(CK_GT,  endDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * END_DATETIME: {DATETIME(19)}
     * @param endDatetime The value of endDatetime as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setEndDatetime_LessThan(java.time.LocalDateTime endDatetime) {
        regEndDatetime(CK_LT,  endDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * END_DATETIME: {DATETIME(19)}
     * @param endDatetime The value of endDatetime as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setEndDatetime_GreaterEqual(java.time.LocalDateTime endDatetime) {
        regEndDatetime(CK_GE,  endDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * END_DATETIME: {DATETIME(19)}
     * @param endDatetime The value of endDatetime as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setEndDatetime_LessEqual(java.time.LocalDateTime endDatetime) {
        regEndDatetime(CK_LE, endDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * END_DATETIME: {DATETIME(19)}
     * <pre>e.g. setEndDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of endDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of endDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setEndDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setEndDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * END_DATETIME: {DATETIME(19)}
     * <pre>e.g. setEndDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of endDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of endDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setEndDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "END_DATETIME"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueEndDatetime(), nm, op);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * END_DATETIME: {DATETIME(19)}
     */
    public void setEndDatetime_IsNull() { regEndDatetime(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * END_DATETIME: {DATETIME(19)}
     */
    public void setEndDatetime_IsNotNull() { regEndDatetime(CK_ISNN, DOBJ); }

    protected void regEndDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueEndDatetime(), "END_DATETIME"); }
    protected abstract ConditionValue xgetCValueEndDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE}
     * @param vacationTypeCode The value of vacationTypeCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVacationTypeCode_Equal(String vacationTypeCode) {
        doSetVacationTypeCode_Equal(fRES(vacationTypeCode));
    }

    protected void doSetVacationTypeCode_Equal(String vacationTypeCode) {
        regVacationTypeCode(CK_EQ, vacationTypeCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE}
     * @param vacationTypeCode The value of vacationTypeCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVacationTypeCode_NotEqual(String vacationTypeCode) {
        doSetVacationTypeCode_NotEqual(fRES(vacationTypeCode));
    }

    protected void doSetVacationTypeCode_NotEqual(String vacationTypeCode) {
        regVacationTypeCode(CK_NES, vacationTypeCode);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE}
     * @param vacationTypeCode The value of vacationTypeCode as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVacationTypeCode_GreaterThan(String vacationTypeCode) {
        regVacationTypeCode(CK_GT, fRES(vacationTypeCode));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE}
     * @param vacationTypeCode The value of vacationTypeCode as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVacationTypeCode_LessThan(String vacationTypeCode) {
        regVacationTypeCode(CK_LT, fRES(vacationTypeCode));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE}
     * @param vacationTypeCode The value of vacationTypeCode as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVacationTypeCode_GreaterEqual(String vacationTypeCode) {
        regVacationTypeCode(CK_GE, fRES(vacationTypeCode));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE}
     * @param vacationTypeCode The value of vacationTypeCode as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVacationTypeCode_LessEqual(String vacationTypeCode) {
        regVacationTypeCode(CK_LE, fRES(vacationTypeCode));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE}
     * @param vacationTypeCodeList The collection of vacationTypeCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVacationTypeCode_InScope(Collection<String> vacationTypeCodeList) {
        doSetVacationTypeCode_InScope(vacationTypeCodeList);
    }

    protected void doSetVacationTypeCode_InScope(Collection<String> vacationTypeCodeList) {
        regINS(CK_INS, cTL(vacationTypeCodeList), xgetCValueVacationTypeCode(), "VACATION_TYPE_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE}
     * @param vacationTypeCodeList The collection of vacationTypeCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVacationTypeCode_NotInScope(Collection<String> vacationTypeCodeList) {
        doSetVacationTypeCode_NotInScope(vacationTypeCodeList);
    }

    protected void doSetVacationTypeCode_NotInScope(Collection<String> vacationTypeCodeList) {
        regINS(CK_NINS, cTL(vacationTypeCodeList), xgetCValueVacationTypeCode(), "VACATION_TYPE_CODE");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE} <br>
     * <pre>e.g. setVacationTypeCode_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param vacationTypeCode The value of vacationTypeCode as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setVacationTypeCode_LikeSearch(String vacationTypeCode, ConditionOptionCall<LikeSearchOption> opLambda) {
        setVacationTypeCode_LikeSearch(vacationTypeCode, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE} <br>
     * <pre>e.g. setVacationTypeCode_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param vacationTypeCode The value of vacationTypeCode as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setVacationTypeCode_LikeSearch(String vacationTypeCode, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(vacationTypeCode), xgetCValueVacationTypeCode(), "VACATION_TYPE_CODE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE}
     * @param vacationTypeCode The value of vacationTypeCode as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setVacationTypeCode_NotLikeSearch(String vacationTypeCode, ConditionOptionCall<LikeSearchOption> opLambda) {
        setVacationTypeCode_NotLikeSearch(vacationTypeCode, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE}
     * @param vacationTypeCode The value of vacationTypeCode as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setVacationTypeCode_NotLikeSearch(String vacationTypeCode, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(vacationTypeCode), xgetCValueVacationTypeCode(), "VACATION_TYPE_CODE", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE}
     */
    public void setVacationTypeCode_IsNull() { regVacationTypeCode(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE}
     */
    public void setVacationTypeCode_IsNullOrEmpty() { regVacationTypeCode(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE}
     */
    public void setVacationTypeCode_IsNotNull() { regVacationTypeCode(CK_ISNN, DOBJ); }

    protected void regVacationTypeCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVacationTypeCode(), "VACATION_TYPE_CODE"); }
    protected abstract ConditionValue xgetCValueVacationTypeCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOTE: {TEXT(65535)}
     * @param note The value of note as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNote_Equal(String note) {
        doSetNote_Equal(fRES(note));
    }

    protected void doSetNote_Equal(String note) {
        regNote(CK_EQ, note);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOTE: {TEXT(65535)}
     * @param note The value of note as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNote_NotEqual(String note) {
        doSetNote_NotEqual(fRES(note));
    }

    protected void doSetNote_NotEqual(String note) {
        regNote(CK_NES, note);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOTE: {TEXT(65535)}
     * @param note The value of note as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNote_GreaterThan(String note) {
        regNote(CK_GT, fRES(note));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOTE: {TEXT(65535)}
     * @param note The value of note as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNote_LessThan(String note) {
        regNote(CK_LT, fRES(note));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOTE: {TEXT(65535)}
     * @param note The value of note as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNote_GreaterEqual(String note) {
        regNote(CK_GE, fRES(note));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOTE: {TEXT(65535)}
     * @param note The value of note as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNote_LessEqual(String note) {
        regNote(CK_LE, fRES(note));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * NOTE: {TEXT(65535)}
     * @param noteList The collection of note as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNote_InScope(Collection<String> noteList) {
        doSetNote_InScope(noteList);
    }

    protected void doSetNote_InScope(Collection<String> noteList) {
        regINS(CK_INS, cTL(noteList), xgetCValueNote(), "NOTE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * NOTE: {TEXT(65535)}
     * @param noteList The collection of note as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNote_NotInScope(Collection<String> noteList) {
        doSetNote_NotInScope(noteList);
    }

    protected void doSetNote_NotInScope(Collection<String> noteList) {
        regINS(CK_NINS, cTL(noteList), xgetCValueNote(), "NOTE");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * NOTE: {TEXT(65535)} <br>
     * <pre>e.g. setNote_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param note The value of note as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setNote_LikeSearch(String note, ConditionOptionCall<LikeSearchOption> opLambda) {
        setNote_LikeSearch(note, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * NOTE: {TEXT(65535)} <br>
     * <pre>e.g. setNote_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param note The value of note as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setNote_LikeSearch(String note, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(note), xgetCValueNote(), "NOTE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * NOTE: {TEXT(65535)}
     * @param note The value of note as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setNote_NotLikeSearch(String note, ConditionOptionCall<LikeSearchOption> opLambda) {
        setNote_NotLikeSearch(note, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * NOTE: {TEXT(65535)}
     * @param note The value of note as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setNote_NotLikeSearch(String note, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(note), xgetCValueNote(), "NOTE", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * NOTE: {TEXT(65535)}
     */
    public void setNote_IsNull() { regNote(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * NOTE: {TEXT(65535)}
     */
    public void setNote_IsNullOrEmpty() { regNote(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * NOTE: {TEXT(65535)}
     */
    public void setNote_IsNotNull() { regNote(CK_ISNN, DOBJ); }

    protected void regNote(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueNote(), "NOTE"); }
    protected abstract ConditionValue xgetCValueNote();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_Equal(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_EQ,  registerDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_GreaterThan(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_GT,  registerDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_LessThan(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_LT,  registerDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_GreaterEqual(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_GE,  registerDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_LessEqual(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_LE, registerDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setRegisterDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setRegisterDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setRegisterDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setRegisterDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setRegisterDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "REGISTER_DATETIME"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueRegisterDatetime(), nm, op);
    }

    protected void regRegisterDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRegisterDatetime(), "REGISTER_DATETIME"); }
    protected abstract ConditionValue xgetCValueRegisterDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUser The value of registerUser as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterUser_Equal(String registerUser) {
        doSetRegisterUser_Equal(fRES(registerUser));
    }

    protected void doSetRegisterUser_Equal(String registerUser) {
        regRegisterUser(CK_EQ, registerUser);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUser The value of registerUser as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterUser_NotEqual(String registerUser) {
        doSetRegisterUser_NotEqual(fRES(registerUser));
    }

    protected void doSetRegisterUser_NotEqual(String registerUser) {
        regRegisterUser(CK_NES, registerUser);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUser The value of registerUser as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterUser_GreaterThan(String registerUser) {
        regRegisterUser(CK_GT, fRES(registerUser));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUser The value of registerUser as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterUser_LessThan(String registerUser) {
        regRegisterUser(CK_LT, fRES(registerUser));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUser The value of registerUser as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterUser_GreaterEqual(String registerUser) {
        regRegisterUser(CK_GE, fRES(registerUser));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUser The value of registerUser as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterUser_LessEqual(String registerUser) {
        regRegisterUser(CK_LE, fRES(registerUser));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUserList The collection of registerUser as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterUser_InScope(Collection<String> registerUserList) {
        doSetRegisterUser_InScope(registerUserList);
    }

    protected void doSetRegisterUser_InScope(Collection<String> registerUserList) {
        regINS(CK_INS, cTL(registerUserList), xgetCValueRegisterUser(), "REGISTER_USER");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUserList The collection of registerUser as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterUser_NotInScope(Collection<String> registerUserList) {
        doSetRegisterUser_NotInScope(registerUserList);
    }

    protected void doSetRegisterUser_NotInScope(Collection<String> registerUserList) {
        regINS(CK_NINS, cTL(registerUserList), xgetCValueRegisterUser(), "REGISTER_USER");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)} <br>
     * <pre>e.g. setRegisterUser_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param registerUser The value of registerUser as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRegisterUser_LikeSearch(String registerUser, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRegisterUser_LikeSearch(registerUser, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)} <br>
     * <pre>e.g. setRegisterUser_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param registerUser The value of registerUser as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setRegisterUser_LikeSearch(String registerUser, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(registerUser), xgetCValueRegisterUser(), "REGISTER_USER", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUser The value of registerUser as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRegisterUser_NotLikeSearch(String registerUser, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRegisterUser_NotLikeSearch(registerUser, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUser The value of registerUser as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setRegisterUser_NotLikeSearch(String registerUser, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(registerUser), xgetCValueRegisterUser(), "REGISTER_USER", likeSearchOption);
    }

    protected void regRegisterUser(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRegisterUser(), "REGISTER_USER"); }
    protected abstract ConditionValue xgetCValueRegisterUser();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_Equal(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_EQ,  updateDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_GreaterThan(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_GT,  updateDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_LessThan(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_LT,  updateDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_GreaterEqual(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_GE,  updateDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_LessEqual(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_LE, updateDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setUpdateDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setUpdateDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setUpdateDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setUpdateDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setUpdateDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "UPDATE_DATETIME"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueUpdateDatetime(), nm, op);
    }

    protected void regUpdateDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueUpdateDatetime(), "UPDATE_DATETIME"); }
    protected abstract ConditionValue xgetCValueUpdateDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUser The value of updateUser as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateUser_Equal(String updateUser) {
        doSetUpdateUser_Equal(fRES(updateUser));
    }

    protected void doSetUpdateUser_Equal(String updateUser) {
        regUpdateUser(CK_EQ, updateUser);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUser The value of updateUser as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateUser_NotEqual(String updateUser) {
        doSetUpdateUser_NotEqual(fRES(updateUser));
    }

    protected void doSetUpdateUser_NotEqual(String updateUser) {
        regUpdateUser(CK_NES, updateUser);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUser The value of updateUser as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateUser_GreaterThan(String updateUser) {
        regUpdateUser(CK_GT, fRES(updateUser));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUser The value of updateUser as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateUser_LessThan(String updateUser) {
        regUpdateUser(CK_LT, fRES(updateUser));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUser The value of updateUser as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateUser_GreaterEqual(String updateUser) {
        regUpdateUser(CK_GE, fRES(updateUser));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUser The value of updateUser as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateUser_LessEqual(String updateUser) {
        regUpdateUser(CK_LE, fRES(updateUser));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUserList The collection of updateUser as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateUser_InScope(Collection<String> updateUserList) {
        doSetUpdateUser_InScope(updateUserList);
    }

    protected void doSetUpdateUser_InScope(Collection<String> updateUserList) {
        regINS(CK_INS, cTL(updateUserList), xgetCValueUpdateUser(), "UPDATE_USER");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUserList The collection of updateUser as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateUser_NotInScope(Collection<String> updateUserList) {
        doSetUpdateUser_NotInScope(updateUserList);
    }

    protected void doSetUpdateUser_NotInScope(Collection<String> updateUserList) {
        regINS(CK_NINS, cTL(updateUserList), xgetCValueUpdateUser(), "UPDATE_USER");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)} <br>
     * <pre>e.g. setUpdateUser_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param updateUser The value of updateUser as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUpdateUser_LikeSearch(String updateUser, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUpdateUser_LikeSearch(updateUser, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)} <br>
     * <pre>e.g. setUpdateUser_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param updateUser The value of updateUser as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setUpdateUser_LikeSearch(String updateUser, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(updateUser), xgetCValueUpdateUser(), "UPDATE_USER", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUser The value of updateUser as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUpdateUser_NotLikeSearch(String updateUser, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUpdateUser_NotLikeSearch(updateUser, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUser The value of updateUser as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setUpdateUser_NotLikeSearch(String updateUser, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(updateUser), xgetCValueUpdateUser(), "UPDATE_USER", likeSearchOption);
    }

    protected void regUpdateUser(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueUpdateUser(), "UPDATE_USER"); }
    protected abstract ConditionValue xgetCValueUpdateUser();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNo The value of versionNo as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setVersionNo_Equal(Long versionNo) {
        doSetVersionNo_Equal(versionNo);
    }

    protected void doSetVersionNo_Equal(Long versionNo) {
        regVersionNo(CK_EQ, versionNo);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNo The value of versionNo as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVersionNo_NotEqual(Long versionNo) {
        doSetVersionNo_NotEqual(versionNo);
    }

    protected void doSetVersionNo_NotEqual(Long versionNo) {
        regVersionNo(CK_NES, versionNo);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNo The value of versionNo as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVersionNo_GreaterThan(Long versionNo) {
        regVersionNo(CK_GT, versionNo);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNo The value of versionNo as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVersionNo_LessThan(Long versionNo) {
        regVersionNo(CK_LT, versionNo);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNo The value of versionNo as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVersionNo_GreaterEqual(Long versionNo) {
        regVersionNo(CK_GE, versionNo);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNo The value of versionNo as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVersionNo_LessEqual(Long versionNo) {
        regVersionNo(CK_LE, versionNo);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param minNumber The min number of versionNo. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of versionNo. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setVersionNo_RangeOf(Long minNumber, Long maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setVersionNo_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param minNumber The min number of versionNo. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of versionNo. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setVersionNo_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueVersionNo(), "VERSION_NO", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNoList The collection of versionNo as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVersionNo_InScope(Collection<Long> versionNoList) {
        doSetVersionNo_InScope(versionNoList);
    }

    protected void doSetVersionNo_InScope(Collection<Long> versionNoList) {
        regINS(CK_INS, cTL(versionNoList), xgetCValueVersionNo(), "VERSION_NO");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNoList The collection of versionNo as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVersionNo_NotInScope(Collection<Long> versionNoList) {
        doSetVersionNo_NotInScope(versionNoList);
    }

    protected void doSetVersionNo_NotInScope(Collection<Long> versionNoList) {
        regINS(CK_NINS, cTL(versionNoList), xgetCValueVersionNo(), "VERSION_NO");
    }

    protected void regVersionNo(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVersionNo(), "VERSION_NO"); }
    protected abstract ConditionValue xgetCValueVersionNo();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO = (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<DailyStartEndCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, DailyStartEndCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO &lt;&gt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<DailyStartEndCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, DailyStartEndCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br>
     * {where FOO &gt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<DailyStartEndCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, DailyStartEndCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br>
     * {where FOO &lt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<DailyStartEndCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, DailyStartEndCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br>
     * {where FOO &gt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<DailyStartEndCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, DailyStartEndCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;DailyStartEndCB&gt;() {
     *     public void query(DailyStartEndCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<DailyStartEndCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, DailyStartEndCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        DailyStartEndCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(DailyStartEndCQ sq);

    protected DailyStartEndCB xcreateScalarConditionCB() {
        DailyStartEndCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected DailyStartEndCB xcreateScalarConditionPartitionByCB() {
        DailyStartEndCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<DailyStartEndCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        DailyStartEndCB cb = new DailyStartEndCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "DAILY_START_END_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(DailyStartEndCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<DailyStartEndCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(DailyStartEndCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        DailyStartEndCB cb = new DailyStartEndCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "DAILY_START_END_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(DailyStartEndCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<DailyStartEndCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        DailyStartEndCB cb = new DailyStartEndCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(DailyStartEndCQ sq);

    // ===================================================================================
    //                                                                        Manual Order
    //                                                                        ============
    /**
     * Order along manual ordering information.
     * <pre>
     * cb.query().addOrderBy_Birthdate_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when BIRTHDATE &gt;= '2000/01/01' then 0</span>
     * <span style="color: #3F7E5E">//     else 1</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     *
     * cb.query().addOrderBy_MemberStatusCode_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Withdrawal);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Formalized);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Provisional);
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'WDL' then 0</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'FML' then 1</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'PRV' then 2</span>
     * <span style="color: #3F7E5E">//     else 3</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     * </pre>
     * <p>This function with Union is unsupported!</p>
     * <p>The order values are bound (treated as bind parameter).</p>
     * @param opLambda The callback for option of manual-order containing order values. (NotNull)
     */
    public void withManualOrder(ManualOrderOptionCall opLambda) { // is user public!
        xdoWithManualOrder(cMOO(opLambda));
    }

    // ===================================================================================
    //                                                                    Small Adjustment
    //                                                                    ================
    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected DailyStartEndCB newMyCB() {
        return new DailyStartEndCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return DailyStartEndCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
