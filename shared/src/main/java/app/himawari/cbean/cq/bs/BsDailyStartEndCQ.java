package app.himawari.cbean.cq.bs;

import java.util.Map;

import org.dbflute.cbean.*;
import org.dbflute.cbean.chelper.*;
import org.dbflute.cbean.coption.*;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.exception.IllegalConditionBeanOperationException;
import app.himawari.cbean.cq.ciq.*;
import app.himawari.cbean.*;
import app.himawari.cbean.cq.*;

/**
 * The base condition-query of DAILY_START_END.
 * @author DBFlute(AutoGenerator)
 */
public class BsDailyStartEndCQ extends AbstractBsDailyStartEndCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected DailyStartEndCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsDailyStartEndCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from DAILY_START_END) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public DailyStartEndCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected DailyStartEndCIQ xcreateCIQ() {
        DailyStartEndCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected DailyStartEndCIQ xnewCIQ() {
        return new DailyStartEndCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join DAILY_START_END on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public DailyStartEndCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        DailyStartEndCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _dailyStartEndId;
    public ConditionValue xdfgetDailyStartEndId()
    { if (_dailyStartEndId == null) { _dailyStartEndId = nCV(); }
      return _dailyStartEndId; }
    protected ConditionValue xgetCValueDailyStartEndId() { return xdfgetDailyStartEndId(); }

    /**
     * Add order-by as ascend. <br>
     * DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_DailyStartEndId_Asc() { regOBA("DAILY_START_END_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_DailyStartEndId_Desc() { regOBD("DAILY_START_END_ID"); return this; }

    protected ConditionValue _timecardDayId;
    public ConditionValue xdfgetTimecardDayId()
    { if (_timecardDayId == null) { _timecardDayId = nCV(); }
      return _timecardDayId; }
    protected ConditionValue xgetCValueTimecardDayId() { return xdfgetTimecardDayId(); }

    /**
     * Add order-by as ascend. <br>
     * TIMECARD_DAY_ID: {IX, NotNull, BIGINT(19), FK to TIMECARD_DAY}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_TimecardDayId_Asc() { regOBA("TIMECARD_DAY_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * TIMECARD_DAY_ID: {IX, NotNull, BIGINT(19), FK to TIMECARD_DAY}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_TimecardDayId_Desc() { regOBD("TIMECARD_DAY_ID"); return this; }

    protected ConditionValue _startDatetime;
    public ConditionValue xdfgetStartDatetime()
    { if (_startDatetime == null) { _startDatetime = nCV(); }
      return _startDatetime; }
    protected ConditionValue xgetCValueStartDatetime() { return xdfgetStartDatetime(); }

    /**
     * Add order-by as ascend. <br>
     * START_DATETIME: {DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_StartDatetime_Asc() { regOBA("START_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * START_DATETIME: {DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_StartDatetime_Desc() { regOBD("START_DATETIME"); return this; }

    protected ConditionValue _endDatetime;
    public ConditionValue xdfgetEndDatetime()
    { if (_endDatetime == null) { _endDatetime = nCV(); }
      return _endDatetime; }
    protected ConditionValue xgetCValueEndDatetime() { return xdfgetEndDatetime(); }

    /**
     * Add order-by as ascend. <br>
     * END_DATETIME: {DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_EndDatetime_Asc() { regOBA("END_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * END_DATETIME: {DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_EndDatetime_Desc() { regOBD("END_DATETIME"); return this; }

    protected ConditionValue _vacationTypeCode;
    public ConditionValue xdfgetVacationTypeCode()
    { if (_vacationTypeCode == null) { _vacationTypeCode = nCV(); }
      return _vacationTypeCode; }
    protected ConditionValue xgetCValueVacationTypeCode() { return xdfgetVacationTypeCode(); }

    /**
     * Add order-by as ascend. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_VacationTypeCode_Asc() { regOBA("VACATION_TYPE_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_VacationTypeCode_Desc() { regOBD("VACATION_TYPE_CODE"); return this; }

    protected ConditionValue _note;
    public ConditionValue xdfgetNote()
    { if (_note == null) { _note = nCV(); }
      return _note; }
    protected ConditionValue xgetCValueNote() { return xdfgetNote(); }

    /**
     * Add order-by as ascend. <br>
     * NOTE: {TEXT(65535)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_Note_Asc() { regOBA("NOTE"); return this; }

    /**
     * Add order-by as descend. <br>
     * NOTE: {TEXT(65535)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_Note_Desc() { regOBD("NOTE"); return this; }

    protected ConditionValue _registerDatetime;
    public ConditionValue xdfgetRegisterDatetime()
    { if (_registerDatetime == null) { _registerDatetime = nCV(); }
      return _registerDatetime; }
    protected ConditionValue xgetCValueRegisterDatetime() { return xdfgetRegisterDatetime(); }

    /**
     * Add order-by as ascend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

    protected ConditionValue _registerUser;
    public ConditionValue xdfgetRegisterUser()
    { if (_registerUser == null) { _registerUser = nCV(); }
      return _registerUser; }
    protected ConditionValue xgetCValueRegisterUser() { return xdfgetRegisterUser(); }

    /**
     * Add order-by as ascend. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_RegisterUser_Asc() { regOBA("REGISTER_USER"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_RegisterUser_Desc() { regOBD("REGISTER_USER"); return this; }

    protected ConditionValue _updateDatetime;
    public ConditionValue xdfgetUpdateDatetime()
    { if (_updateDatetime == null) { _updateDatetime = nCV(); }
      return _updateDatetime; }
    protected ConditionValue xgetCValueUpdateDatetime() { return xdfgetUpdateDatetime(); }

    /**
     * Add order-by as ascend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

    protected ConditionValue _updateUser;
    public ConditionValue xdfgetUpdateUser()
    { if (_updateUser == null) { _updateUser = nCV(); }
      return _updateUser; }
    protected ConditionValue xgetCValueUpdateUser() { return xdfgetUpdateUser(); }

    /**
     * Add order-by as ascend. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_UpdateUser_Asc() { regOBA("UPDATE_USER"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_UpdateUser_Desc() { regOBD("UPDATE_USER"); return this; }

    protected ConditionValue _versionNo;
    public ConditionValue xdfgetVersionNo()
    { if (_versionNo == null) { _versionNo = nCV(); }
      return _versionNo; }
    protected ConditionValue xgetCValueVersionNo() { return xdfgetVersionNo(); }

    /**
     * Add order-by as ascend. <br>
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_VersionNo_Asc() { regOBA("VERSION_NO"); return this; }

    /**
     * Add order-by as descend. <br>
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addOrderBy_VersionNo_Desc() { regOBD("VERSION_NO"); return this; }

    // ===================================================================================
    //                                                             SpecifiedDerivedOrderBy
    //                                                             =======================
    /**
     * Add order-by for specified derived column as ascend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #CC4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] asc</span>
     * cb.<span style="color: #CC4747">addSpecifiedDerivedOrderBy_Asc</span>(<span style="color: #CC4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

    /**
     * Add order-by for specified derived column as descend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #CC4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] desc</span>
     * cb.<span style="color: #CC4747">addSpecifiedDerivedOrderBy_Desc</span>(<span style="color: #CC4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsDailyStartEndCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        DailyStartEndCQ bq = (DailyStartEndCQ)bqs;
        DailyStartEndCQ uq = (DailyStartEndCQ)uqs;
        if (bq.hasConditionQueryTimecardDay()) {
            uq.queryTimecardDay().reflectRelationOnUnionQuery(bq.queryTimecardDay(), uq.queryTimecardDay());
        }
        if (bq.hasConditionQueryVacationType()) {
            uq.queryVacationType().reflectRelationOnUnionQuery(bq.queryVacationType(), uq.queryVacationType());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * TIMECARD_DAY by my TIMECARD_DAY_ID, named 'timecardDay'.
     * @return The instance of condition-query. (NotNull)
     */
    public TimecardDayCQ queryTimecardDay() {
        return xdfgetConditionQueryTimecardDay();
    }
    public TimecardDayCQ xdfgetConditionQueryTimecardDay() {
        String prop = "timecardDay";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryTimecardDay()); xsetupOuterJoinTimecardDay(); }
        return xgetQueRlMap(prop);
    }
    protected TimecardDayCQ xcreateQueryTimecardDay() {
        String nrp = xresolveNRP("DAILY_START_END", "timecardDay"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new TimecardDayCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "timecardDay", nrp);
    }
    protected void xsetupOuterJoinTimecardDay() { xregOutJo("timecardDay"); }
    public boolean hasConditionQueryTimecardDay() { return xhasQueRlMap("timecardDay"); }

    /**
     * Get the condition-query for relation table. <br>
     * VACATION_TYPE by my VACATION_TYPE_CODE, named 'vacationType'.
     * @return The instance of condition-query. (NotNull)
     */
    public VacationTypeCQ queryVacationType() {
        return xdfgetConditionQueryVacationType();
    }
    public VacationTypeCQ xdfgetConditionQueryVacationType() {
        String prop = "vacationType";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryVacationType()); xsetupOuterJoinVacationType(); }
        return xgetQueRlMap(prop);
    }
    protected VacationTypeCQ xcreateQueryVacationType() {
        String nrp = xresolveNRP("DAILY_START_END", "vacationType"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new VacationTypeCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "vacationType", nrp);
    }
    protected void xsetupOuterJoinVacationType() { xregOutJo("vacationType"); }
    public boolean hasConditionQueryVacationType() { return xhasQueRlMap("vacationType"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, DailyStartEndCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(DailyStartEndCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, DailyStartEndCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(DailyStartEndCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, DailyStartEndCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(DailyStartEndCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, DailyStartEndCQ> _myselfExistsMap;
    public Map<String, DailyStartEndCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(DailyStartEndCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, DailyStartEndCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(DailyStartEndCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return DailyStartEndCB.class.getName(); }
    protected String xCQ() { return DailyStartEndCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
