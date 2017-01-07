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
 * The abstract condition-query of daily_in_out.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsDailyInOutCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsDailyInOutCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "daily_in_out";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param dailyInOutId The value of dailyInOutId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setDailyInOutId_Equal(Long dailyInOutId) {
        doSetDailyInOutId_Equal(dailyInOutId);
    }

    protected void doSetDailyInOutId_Equal(Long dailyInOutId) {
        regDailyInOutId(CK_EQ, dailyInOutId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param dailyInOutId The value of dailyInOutId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDailyInOutId_NotEqual(Long dailyInOutId) {
        doSetDailyInOutId_NotEqual(dailyInOutId);
    }

    protected void doSetDailyInOutId_NotEqual(Long dailyInOutId) {
        regDailyInOutId(CK_NES, dailyInOutId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param dailyInOutId The value of dailyInOutId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDailyInOutId_GreaterThan(Long dailyInOutId) {
        regDailyInOutId(CK_GT, dailyInOutId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param dailyInOutId The value of dailyInOutId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDailyInOutId_LessThan(Long dailyInOutId) {
        regDailyInOutId(CK_LT, dailyInOutId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param dailyInOutId The value of dailyInOutId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDailyInOutId_GreaterEqual(Long dailyInOutId) {
        regDailyInOutId(CK_GE, dailyInOutId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param dailyInOutId The value of dailyInOutId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDailyInOutId_LessEqual(Long dailyInOutId) {
        regDailyInOutId(CK_LE, dailyInOutId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param minNumber The min number of dailyInOutId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of dailyInOutId. (NullAllowed: if null, no to-condition)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setDailyInOutId_RangeOf(Long minNumber, Long maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setDailyInOutId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param minNumber The min number of dailyInOutId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of dailyInOutId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setDailyInOutId_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueDailyInOutId(), "DAILY_IN_OUT_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param dailyInOutIdList The collection of dailyInOutId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setDailyInOutId_InScope(Collection<Long> dailyInOutIdList) {
        doSetDailyInOutId_InScope(dailyInOutIdList);
    }

    protected void doSetDailyInOutId_InScope(Collection<Long> dailyInOutIdList) {
        regINS(CK_INS, cTL(dailyInOutIdList), xgetCValueDailyInOutId(), "DAILY_IN_OUT_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param dailyInOutIdList The collection of dailyInOutId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setDailyInOutId_NotInScope(Collection<Long> dailyInOutIdList) {
        doSetDailyInOutId_NotInScope(dailyInOutIdList);
    }

    protected void doSetDailyInOutId_NotInScope(Collection<Long> dailyInOutIdList) {
        regINS(CK_NINS, cTL(dailyInOutIdList), xgetCValueDailyInOutId(), "DAILY_IN_OUT_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)}
     */
    public void setDailyInOutId_IsNull() { regDailyInOutId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)}
     */
    public void setDailyInOutId_IsNotNull() { regDailyInOutId(CK_ISNN, DOBJ); }

    protected void regDailyInOutId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDailyInOutId(), "DAILY_IN_OUT_ID"); }
    protected abstract ConditionValue xgetCValueDailyInOutId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * TIMECARD_ID: {IX, NotNull, BIGINT(19), FK to timecard}
     * @param timecardId The value of timecardId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setTimecardId_Equal(Long timecardId) {
        doSetTimecardId_Equal(timecardId);
    }

    protected void doSetTimecardId_Equal(Long timecardId) {
        regTimecardId(CK_EQ, timecardId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * TIMECARD_ID: {IX, NotNull, BIGINT(19), FK to timecard}
     * @param timecardId The value of timecardId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setTimecardId_NotEqual(Long timecardId) {
        doSetTimecardId_NotEqual(timecardId);
    }

    protected void doSetTimecardId_NotEqual(Long timecardId) {
        regTimecardId(CK_NES, timecardId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * TIMECARD_ID: {IX, NotNull, BIGINT(19), FK to timecard}
     * @param timecardId The value of timecardId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setTimecardId_GreaterThan(Long timecardId) {
        regTimecardId(CK_GT, timecardId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * TIMECARD_ID: {IX, NotNull, BIGINT(19), FK to timecard}
     * @param timecardId The value of timecardId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setTimecardId_LessThan(Long timecardId) {
        regTimecardId(CK_LT, timecardId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * TIMECARD_ID: {IX, NotNull, BIGINT(19), FK to timecard}
     * @param timecardId The value of timecardId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setTimecardId_GreaterEqual(Long timecardId) {
        regTimecardId(CK_GE, timecardId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * TIMECARD_ID: {IX, NotNull, BIGINT(19), FK to timecard}
     * @param timecardId The value of timecardId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setTimecardId_LessEqual(Long timecardId) {
        regTimecardId(CK_LE, timecardId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * TIMECARD_ID: {IX, NotNull, BIGINT(19), FK to timecard}
     * @param minNumber The min number of timecardId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of timecardId. (NullAllowed: if null, no to-condition)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setTimecardId_RangeOf(Long minNumber, Long maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setTimecardId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * TIMECARD_ID: {IX, NotNull, BIGINT(19), FK to timecard}
     * @param minNumber The min number of timecardId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of timecardId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setTimecardId_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueTimecardId(), "TIMECARD_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * TIMECARD_ID: {IX, NotNull, BIGINT(19), FK to timecard}
     * @param timecardIdList The collection of timecardId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTimecardId_InScope(Collection<Long> timecardIdList) {
        doSetTimecardId_InScope(timecardIdList);
    }

    protected void doSetTimecardId_InScope(Collection<Long> timecardIdList) {
        regINS(CK_INS, cTL(timecardIdList), xgetCValueTimecardId(), "TIMECARD_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * TIMECARD_ID: {IX, NotNull, BIGINT(19), FK to timecard}
     * @param timecardIdList The collection of timecardId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTimecardId_NotInScope(Collection<Long> timecardIdList) {
        doSetTimecardId_NotInScope(timecardIdList);
    }

    protected void doSetTimecardId_NotInScope(Collection<Long> timecardIdList) {
        regINS(CK_NINS, cTL(timecardIdList), xgetCValueTimecardId(), "TIMECARD_ID");
    }

    protected void regTimecardId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueTimecardId(), "TIMECARD_ID"); }
    protected abstract ConditionValue xgetCValueTimecardId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * IN_DATETIME: {DATETIME(19)}
     * @param inDatetime The value of inDatetime as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setInDatetime_Equal(java.time.LocalDateTime inDatetime) {
        regInDatetime(CK_EQ,  inDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * IN_DATETIME: {DATETIME(19)}
     * @param inDatetime The value of inDatetime as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setInDatetime_GreaterThan(java.time.LocalDateTime inDatetime) {
        regInDatetime(CK_GT,  inDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * IN_DATETIME: {DATETIME(19)}
     * @param inDatetime The value of inDatetime as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setInDatetime_LessThan(java.time.LocalDateTime inDatetime) {
        regInDatetime(CK_LT,  inDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * IN_DATETIME: {DATETIME(19)}
     * @param inDatetime The value of inDatetime as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setInDatetime_GreaterEqual(java.time.LocalDateTime inDatetime) {
        regInDatetime(CK_GE,  inDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * IN_DATETIME: {DATETIME(19)}
     * @param inDatetime The value of inDatetime as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setInDatetime_LessEqual(java.time.LocalDateTime inDatetime) {
        regInDatetime(CK_LE, inDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * IN_DATETIME: {DATETIME(19)}
     * <pre>e.g. setInDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of inDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of inDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setInDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setInDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * IN_DATETIME: {DATETIME(19)}
     * <pre>e.g. setInDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of inDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of inDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setInDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "IN_DATETIME"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueInDatetime(), nm, op);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * IN_DATETIME: {DATETIME(19)}
     */
    public void setInDatetime_IsNull() { regInDatetime(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * IN_DATETIME: {DATETIME(19)}
     */
    public void setInDatetime_IsNotNull() { regInDatetime(CK_ISNN, DOBJ); }

    protected void regInDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueInDatetime(), "IN_DATETIME"); }
    protected abstract ConditionValue xgetCValueInDatetime();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * OUT_DATETIME: {DATETIME(19)}
     * @param outDatetime The value of outDatetime as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setOutDatetime_Equal(java.time.LocalDateTime outDatetime) {
        regOutDatetime(CK_EQ,  outDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * OUT_DATETIME: {DATETIME(19)}
     * @param outDatetime The value of outDatetime as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setOutDatetime_GreaterThan(java.time.LocalDateTime outDatetime) {
        regOutDatetime(CK_GT,  outDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * OUT_DATETIME: {DATETIME(19)}
     * @param outDatetime The value of outDatetime as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setOutDatetime_LessThan(java.time.LocalDateTime outDatetime) {
        regOutDatetime(CK_LT,  outDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * OUT_DATETIME: {DATETIME(19)}
     * @param outDatetime The value of outDatetime as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setOutDatetime_GreaterEqual(java.time.LocalDateTime outDatetime) {
        regOutDatetime(CK_GE,  outDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * OUT_DATETIME: {DATETIME(19)}
     * @param outDatetime The value of outDatetime as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setOutDatetime_LessEqual(java.time.LocalDateTime outDatetime) {
        regOutDatetime(CK_LE, outDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * OUT_DATETIME: {DATETIME(19)}
     * <pre>e.g. setOutDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of outDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of outDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setOutDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setOutDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * OUT_DATETIME: {DATETIME(19)}
     * <pre>e.g. setOutDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of outDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of outDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setOutDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "OUT_DATETIME"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueOutDatetime(), nm, op);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * OUT_DATETIME: {DATETIME(19)}
     */
    public void setOutDatetime_IsNull() { regOutDatetime(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * OUT_DATETIME: {DATETIME(19)}
     */
    public void setOutDatetime_IsNotNull() { regOutDatetime(CK_ISNN, DOBJ); }

    protected void regOutDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueOutDatetime(), "OUT_DATETIME"); }
    protected abstract ConditionValue xgetCValueOutDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VACATION_TYPE_CODE: {IX, NotNull, VARCHAR(3), FK to vacation_type}
     * @param vacationTypeCode The value of vacationTypeCode as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setVacationTypeCode_Equal(String vacationTypeCode) {
        doSetVacationTypeCode_Equal(fRES(vacationTypeCode));
    }

    protected void doSetVacationTypeCode_Equal(String vacationTypeCode) {
        regVacationTypeCode(CK_EQ, vacationTypeCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VACATION_TYPE_CODE: {IX, NotNull, VARCHAR(3), FK to vacation_type}
     * @param vacationTypeCode The value of vacationTypeCode as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setVacationTypeCode_NotEqual(String vacationTypeCode) {
        doSetVacationTypeCode_NotEqual(fRES(vacationTypeCode));
    }

    protected void doSetVacationTypeCode_NotEqual(String vacationTypeCode) {
        regVacationTypeCode(CK_NES, vacationTypeCode);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VACATION_TYPE_CODE: {IX, NotNull, VARCHAR(3), FK to vacation_type}
     * @param vacationTypeCode The value of vacationTypeCode as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setVacationTypeCode_GreaterThan(String vacationTypeCode) {
        regVacationTypeCode(CK_GT, fRES(vacationTypeCode));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VACATION_TYPE_CODE: {IX, NotNull, VARCHAR(3), FK to vacation_type}
     * @param vacationTypeCode The value of vacationTypeCode as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setVacationTypeCode_LessThan(String vacationTypeCode) {
        regVacationTypeCode(CK_LT, fRES(vacationTypeCode));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VACATION_TYPE_CODE: {IX, NotNull, VARCHAR(3), FK to vacation_type}
     * @param vacationTypeCode The value of vacationTypeCode as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setVacationTypeCode_GreaterEqual(String vacationTypeCode) {
        regVacationTypeCode(CK_GE, fRES(vacationTypeCode));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VACATION_TYPE_CODE: {IX, NotNull, VARCHAR(3), FK to vacation_type}
     * @param vacationTypeCode The value of vacationTypeCode as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setVacationTypeCode_LessEqual(String vacationTypeCode) {
        regVacationTypeCode(CK_LE, fRES(vacationTypeCode));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VACATION_TYPE_CODE: {IX, NotNull, VARCHAR(3), FK to vacation_type}
     * @param vacationTypeCodeList The collection of vacationTypeCode as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setVacationTypeCode_InScope(Collection<String> vacationTypeCodeList) {
        doSetVacationTypeCode_InScope(vacationTypeCodeList);
    }

    protected void doSetVacationTypeCode_InScope(Collection<String> vacationTypeCodeList) {
        regINS(CK_INS, cTL(vacationTypeCodeList), xgetCValueVacationTypeCode(), "VACATION_TYPE_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VACATION_TYPE_CODE: {IX, NotNull, VARCHAR(3), FK to vacation_type}
     * @param vacationTypeCodeList The collection of vacationTypeCode as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setVacationTypeCode_NotInScope(Collection<String> vacationTypeCodeList) {
        doSetVacationTypeCode_NotInScope(vacationTypeCodeList);
    }

    protected void doSetVacationTypeCode_NotInScope(Collection<String> vacationTypeCodeList) {
        regINS(CK_NINS, cTL(vacationTypeCodeList), xgetCValueVacationTypeCode(), "VACATION_TYPE_CODE");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VACATION_TYPE_CODE: {IX, NotNull, VARCHAR(3), FK to vacation_type} <br>
     * <pre>e.g. setVacationTypeCode_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param vacationTypeCode The value of vacationTypeCode as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setVacationTypeCode_LikeSearch(String vacationTypeCode, ConditionOptionCall<LikeSearchOption> opLambda) {
        setVacationTypeCode_LikeSearch(vacationTypeCode, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VACATION_TYPE_CODE: {IX, NotNull, VARCHAR(3), FK to vacation_type} <br>
     * <pre>e.g. setVacationTypeCode_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param vacationTypeCode The value of vacationTypeCode as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setVacationTypeCode_LikeSearch(String vacationTypeCode, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(vacationTypeCode), xgetCValueVacationTypeCode(), "VACATION_TYPE_CODE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VACATION_TYPE_CODE: {IX, NotNull, VARCHAR(3), FK to vacation_type}
     * @param vacationTypeCode The value of vacationTypeCode as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setVacationTypeCode_NotLikeSearch(String vacationTypeCode, ConditionOptionCall<LikeSearchOption> opLambda) {
        setVacationTypeCode_NotLikeSearch(vacationTypeCode, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VACATION_TYPE_CODE: {IX, NotNull, VARCHAR(3), FK to vacation_type}
     * @param vacationTypeCode The value of vacationTypeCode as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setVacationTypeCode_NotLikeSearch(String vacationTypeCode, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(vacationTypeCode), xgetCValueVacationTypeCode(), "VACATION_TYPE_CODE", likeSearchOption);
    }

    protected void regVacationTypeCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVacationTypeCode(), "VACATION_TYPE_CODE"); }
    protected abstract ConditionValue xgetCValueVacationTypeCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOTE: {TEXT(65535)}
     * @param note The value of note as equal. (NullAllowed: if null (or empty), no condition)
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
     * @param note The value of note as notEqual. (NullAllowed: if null (or empty), no condition)
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
     * @param note The value of note as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setNote_GreaterThan(String note) {
        regNote(CK_GT, fRES(note));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOTE: {TEXT(65535)}
     * @param note The value of note as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setNote_LessThan(String note) {
        regNote(CK_LT, fRES(note));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOTE: {TEXT(65535)}
     * @param note The value of note as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setNote_GreaterEqual(String note) {
        regNote(CK_GE, fRES(note));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOTE: {TEXT(65535)}
     * @param note The value of note as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setNote_LessEqual(String note) {
        regNote(CK_LE, fRES(note));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * NOTE: {TEXT(65535)}
     * @param noteList The collection of note as inScope. (NullAllowed: if null (or empty), no condition)
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
     * @param noteList The collection of note as notInScope. (NullAllowed: if null (or empty), no condition)
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
     * @param note The value of note as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setNote_LikeSearch(String note, ConditionOptionCall<LikeSearchOption> opLambda) {
        setNote_LikeSearch(note, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * NOTE: {TEXT(65535)} <br>
     * <pre>e.g. setNote_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param note The value of note as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setNote_LikeSearch(String note, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(note), xgetCValueNote(), "NOTE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * NOTE: {TEXT(65535)}
     * @param note The value of note as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setNote_NotLikeSearch(String note, ConditionOptionCall<LikeSearchOption> opLambda) {
        setNote_NotLikeSearch(note, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * NOTE: {TEXT(65535)}
     * @param note The value of note as notLikeSearch. (NullAllowed: if null (or empty), no condition)
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
     * @param registerUser The value of registerUser as equal. (NullAllowed: if null (or empty), no condition)
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
     * @param registerUser The value of registerUser as notEqual. (NullAllowed: if null (or empty), no condition)
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
     * @param registerUser The value of registerUser as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterUser_GreaterThan(String registerUser) {
        regRegisterUser(CK_GT, fRES(registerUser));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUser The value of registerUser as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterUser_LessThan(String registerUser) {
        regRegisterUser(CK_LT, fRES(registerUser));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUser The value of registerUser as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterUser_GreaterEqual(String registerUser) {
        regRegisterUser(CK_GE, fRES(registerUser));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUser The value of registerUser as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterUser_LessEqual(String registerUser) {
        regRegisterUser(CK_LE, fRES(registerUser));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUserList The collection of registerUser as inScope. (NullAllowed: if null (or empty), no condition)
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
     * @param registerUserList The collection of registerUser as notInScope. (NullAllowed: if null (or empty), no condition)
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
     * @param registerUser The value of registerUser as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRegisterUser_LikeSearch(String registerUser, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRegisterUser_LikeSearch(registerUser, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)} <br>
     * <pre>e.g. setRegisterUser_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param registerUser The value of registerUser as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setRegisterUser_LikeSearch(String registerUser, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(registerUser), xgetCValueRegisterUser(), "REGISTER_USER", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUser The value of registerUser as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRegisterUser_NotLikeSearch(String registerUser, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRegisterUser_NotLikeSearch(registerUser, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUser The value of registerUser as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setRegisterUser_NotLikeSearch(String registerUser, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(registerUser), xgetCValueRegisterUser(), "REGISTER_USER", likeSearchOption);
    }

    protected void regRegisterUser(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRegisterUser(), "REGISTER_USER"); }
    protected abstract ConditionValue xgetCValueRegisterUser();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_PROCESS: {NotNull, VARCHAR(200)}
     * @param registerProcess The value of registerProcess as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterProcess_Equal(String registerProcess) {
        doSetRegisterProcess_Equal(fRES(registerProcess));
    }

    protected void doSetRegisterProcess_Equal(String registerProcess) {
        regRegisterProcess(CK_EQ, registerProcess);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_PROCESS: {NotNull, VARCHAR(200)}
     * @param registerProcess The value of registerProcess as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterProcess_NotEqual(String registerProcess) {
        doSetRegisterProcess_NotEqual(fRES(registerProcess));
    }

    protected void doSetRegisterProcess_NotEqual(String registerProcess) {
        regRegisterProcess(CK_NES, registerProcess);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_PROCESS: {NotNull, VARCHAR(200)}
     * @param registerProcess The value of registerProcess as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterProcess_GreaterThan(String registerProcess) {
        regRegisterProcess(CK_GT, fRES(registerProcess));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_PROCESS: {NotNull, VARCHAR(200)}
     * @param registerProcess The value of registerProcess as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterProcess_LessThan(String registerProcess) {
        regRegisterProcess(CK_LT, fRES(registerProcess));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_PROCESS: {NotNull, VARCHAR(200)}
     * @param registerProcess The value of registerProcess as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterProcess_GreaterEqual(String registerProcess) {
        regRegisterProcess(CK_GE, fRES(registerProcess));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_PROCESS: {NotNull, VARCHAR(200)}
     * @param registerProcess The value of registerProcess as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterProcess_LessEqual(String registerProcess) {
        regRegisterProcess(CK_LE, fRES(registerProcess));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * REGISTER_PROCESS: {NotNull, VARCHAR(200)}
     * @param registerProcessList The collection of registerProcess as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterProcess_InScope(Collection<String> registerProcessList) {
        doSetRegisterProcess_InScope(registerProcessList);
    }

    protected void doSetRegisterProcess_InScope(Collection<String> registerProcessList) {
        regINS(CK_INS, cTL(registerProcessList), xgetCValueRegisterProcess(), "REGISTER_PROCESS");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * REGISTER_PROCESS: {NotNull, VARCHAR(200)}
     * @param registerProcessList The collection of registerProcess as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterProcess_NotInScope(Collection<String> registerProcessList) {
        doSetRegisterProcess_NotInScope(registerProcessList);
    }

    protected void doSetRegisterProcess_NotInScope(Collection<String> registerProcessList) {
        regINS(CK_NINS, cTL(registerProcessList), xgetCValueRegisterProcess(), "REGISTER_PROCESS");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_PROCESS: {NotNull, VARCHAR(200)} <br>
     * <pre>e.g. setRegisterProcess_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param registerProcess The value of registerProcess as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRegisterProcess_LikeSearch(String registerProcess, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRegisterProcess_LikeSearch(registerProcess, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_PROCESS: {NotNull, VARCHAR(200)} <br>
     * <pre>e.g. setRegisterProcess_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param registerProcess The value of registerProcess as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setRegisterProcess_LikeSearch(String registerProcess, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(registerProcess), xgetCValueRegisterProcess(), "REGISTER_PROCESS", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_PROCESS: {NotNull, VARCHAR(200)}
     * @param registerProcess The value of registerProcess as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRegisterProcess_NotLikeSearch(String registerProcess, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRegisterProcess_NotLikeSearch(registerProcess, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_PROCESS: {NotNull, VARCHAR(200)}
     * @param registerProcess The value of registerProcess as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setRegisterProcess_NotLikeSearch(String registerProcess, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(registerProcess), xgetCValueRegisterProcess(), "REGISTER_PROCESS", likeSearchOption);
    }

    protected void regRegisterProcess(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRegisterProcess(), "REGISTER_PROCESS"); }
    protected abstract ConditionValue xgetCValueRegisterProcess();

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
     * @param updateUser The value of updateUser as equal. (NullAllowed: if null (or empty), no condition)
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
     * @param updateUser The value of updateUser as notEqual. (NullAllowed: if null (or empty), no condition)
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
     * @param updateUser The value of updateUser as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateUser_GreaterThan(String updateUser) {
        regUpdateUser(CK_GT, fRES(updateUser));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUser The value of updateUser as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateUser_LessThan(String updateUser) {
        regUpdateUser(CK_LT, fRES(updateUser));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUser The value of updateUser as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateUser_GreaterEqual(String updateUser) {
        regUpdateUser(CK_GE, fRES(updateUser));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUser The value of updateUser as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateUser_LessEqual(String updateUser) {
        regUpdateUser(CK_LE, fRES(updateUser));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUserList The collection of updateUser as inScope. (NullAllowed: if null (or empty), no condition)
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
     * @param updateUserList The collection of updateUser as notInScope. (NullAllowed: if null (or empty), no condition)
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
     * @param updateUser The value of updateUser as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUpdateUser_LikeSearch(String updateUser, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUpdateUser_LikeSearch(updateUser, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)} <br>
     * <pre>e.g. setUpdateUser_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param updateUser The value of updateUser as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setUpdateUser_LikeSearch(String updateUser, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(updateUser), xgetCValueUpdateUser(), "UPDATE_USER", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUser The value of updateUser as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUpdateUser_NotLikeSearch(String updateUser, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUpdateUser_NotLikeSearch(updateUser, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUser The value of updateUser as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setUpdateUser_NotLikeSearch(String updateUser, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(updateUser), xgetCValueUpdateUser(), "UPDATE_USER", likeSearchOption);
    }

    protected void regUpdateUser(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueUpdateUser(), "UPDATE_USER"); }
    protected abstract ConditionValue xgetCValueUpdateUser();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_PROCESS: {NotNull, VARCHAR(200)}
     * @param updateProcess The value of updateProcess as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateProcess_Equal(String updateProcess) {
        doSetUpdateProcess_Equal(fRES(updateProcess));
    }

    protected void doSetUpdateProcess_Equal(String updateProcess) {
        regUpdateProcess(CK_EQ, updateProcess);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_PROCESS: {NotNull, VARCHAR(200)}
     * @param updateProcess The value of updateProcess as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateProcess_NotEqual(String updateProcess) {
        doSetUpdateProcess_NotEqual(fRES(updateProcess));
    }

    protected void doSetUpdateProcess_NotEqual(String updateProcess) {
        regUpdateProcess(CK_NES, updateProcess);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_PROCESS: {NotNull, VARCHAR(200)}
     * @param updateProcess The value of updateProcess as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateProcess_GreaterThan(String updateProcess) {
        regUpdateProcess(CK_GT, fRES(updateProcess));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_PROCESS: {NotNull, VARCHAR(200)}
     * @param updateProcess The value of updateProcess as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateProcess_LessThan(String updateProcess) {
        regUpdateProcess(CK_LT, fRES(updateProcess));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_PROCESS: {NotNull, VARCHAR(200)}
     * @param updateProcess The value of updateProcess as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateProcess_GreaterEqual(String updateProcess) {
        regUpdateProcess(CK_GE, fRES(updateProcess));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_PROCESS: {NotNull, VARCHAR(200)}
     * @param updateProcess The value of updateProcess as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateProcess_LessEqual(String updateProcess) {
        regUpdateProcess(CK_LE, fRES(updateProcess));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * UPDATE_PROCESS: {NotNull, VARCHAR(200)}
     * @param updateProcessList The collection of updateProcess as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateProcess_InScope(Collection<String> updateProcessList) {
        doSetUpdateProcess_InScope(updateProcessList);
    }

    protected void doSetUpdateProcess_InScope(Collection<String> updateProcessList) {
        regINS(CK_INS, cTL(updateProcessList), xgetCValueUpdateProcess(), "UPDATE_PROCESS");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * UPDATE_PROCESS: {NotNull, VARCHAR(200)}
     * @param updateProcessList The collection of updateProcess as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateProcess_NotInScope(Collection<String> updateProcessList) {
        doSetUpdateProcess_NotInScope(updateProcessList);
    }

    protected void doSetUpdateProcess_NotInScope(Collection<String> updateProcessList) {
        regINS(CK_NINS, cTL(updateProcessList), xgetCValueUpdateProcess(), "UPDATE_PROCESS");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_PROCESS: {NotNull, VARCHAR(200)} <br>
     * <pre>e.g. setUpdateProcess_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param updateProcess The value of updateProcess as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUpdateProcess_LikeSearch(String updateProcess, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUpdateProcess_LikeSearch(updateProcess, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_PROCESS: {NotNull, VARCHAR(200)} <br>
     * <pre>e.g. setUpdateProcess_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param updateProcess The value of updateProcess as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setUpdateProcess_LikeSearch(String updateProcess, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(updateProcess), xgetCValueUpdateProcess(), "UPDATE_PROCESS", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_PROCESS: {NotNull, VARCHAR(200)}
     * @param updateProcess The value of updateProcess as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUpdateProcess_NotLikeSearch(String updateProcess, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUpdateProcess_NotLikeSearch(updateProcess, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_PROCESS: {NotNull, VARCHAR(200)}
     * @param updateProcess The value of updateProcess as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setUpdateProcess_NotLikeSearch(String updateProcess, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(updateProcess), xgetCValueUpdateProcess(), "UPDATE_PROCESS", likeSearchOption);
    }

    protected void regUpdateProcess(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueUpdateProcess(), "UPDATE_PROCESS"); }
    protected abstract ConditionValue xgetCValueUpdateProcess();

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
     * @param minNumber The min number of versionNo. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of versionNo. (NullAllowed: if null, no to-condition)
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
     * @param minNumber The min number of versionNo. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of versionNo. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setVersionNo_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueVersionNo(), "VERSION_NO", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNoList The collection of versionNo as inScope. (NullAllowed: if null (or empty), no condition)
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
     * @param versionNoList The collection of versionNo as notInScope. (NullAllowed: if null (or empty), no condition)
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
    public HpSLCFunction<DailyInOutCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, DailyInOutCB.class);
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
    public HpSLCFunction<DailyInOutCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, DailyInOutCB.class);
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
    public HpSLCFunction<DailyInOutCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, DailyInOutCB.class);
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
    public HpSLCFunction<DailyInOutCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, DailyInOutCB.class);
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
    public HpSLCFunction<DailyInOutCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, DailyInOutCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;DailyInOutCB&gt;() {
     *     public void query(DailyInOutCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<DailyInOutCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, DailyInOutCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        DailyInOutCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(DailyInOutCQ sq);

    protected DailyInOutCB xcreateScalarConditionCB() {
        DailyInOutCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected DailyInOutCB xcreateScalarConditionPartitionByCB() {
        DailyInOutCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<DailyInOutCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        DailyInOutCB cb = new DailyInOutCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "DAILY_IN_OUT_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(DailyInOutCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<DailyInOutCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(DailyInOutCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        DailyInOutCB cb = new DailyInOutCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "DAILY_IN_OUT_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(DailyInOutCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<DailyInOutCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        DailyInOutCB cb = new DailyInOutCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(DailyInOutCQ sq);

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
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
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
    protected DailyInOutCB newMyCB() {
        return new DailyInOutCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return DailyInOutCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
