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
 * The base condition-query of daily_in_out.
 * @author DBFlute(AutoGenerator)
 */
public class BsDailyInOutCQ extends AbstractBsDailyInOutCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected DailyInOutCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsDailyInOutCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from daily_in_out) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public DailyInOutCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected DailyInOutCIQ xcreateCIQ() {
        DailyInOutCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected DailyInOutCIQ xnewCIQ() {
        return new DailyInOutCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join daily_in_out on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public DailyInOutCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        DailyInOutCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _dailyInOutId;
    public ConditionValue xdfgetDailyInOutId()
    { if (_dailyInOutId == null) { _dailyInOutId = nCV(); }
      return _dailyInOutId; }
    protected ConditionValue xgetCValueDailyInOutId() { return xdfgetDailyInOutId(); }

    /** 
     * Add order-by as ascend. <br>
     * DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_DailyInOutId_Asc() { regOBA("DAILY_IN_OUT_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_DailyInOutId_Desc() { regOBD("DAILY_IN_OUT_ID"); return this; }

    protected ConditionValue _timecardId;
    public ConditionValue xdfgetTimecardId()
    { if (_timecardId == null) { _timecardId = nCV(); }
      return _timecardId; }
    protected ConditionValue xgetCValueTimecardId() { return xdfgetTimecardId(); }

    /** 
     * Add order-by as ascend. <br>
     * TIMECARD_ID: {IX, NotNull, BIGINT(19), FK to timecard}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_TimecardId_Asc() { regOBA("TIMECARD_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * TIMECARD_ID: {IX, NotNull, BIGINT(19), FK to timecard}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_TimecardId_Desc() { regOBD("TIMECARD_ID"); return this; }

    protected ConditionValue _bizDate;
    public ConditionValue xdfgetBizDate()
    { if (_bizDate == null) { _bizDate = nCV(); }
      return _bizDate; }
    protected ConditionValue xgetCValueBizDate() { return xdfgetBizDate(); }

    /** 
     * Add order-by as ascend. <br>
     * BIZ_DATE: {NotNull, DATE(10)}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_BizDate_Asc() { regOBA("BIZ_DATE"); return this; }

    /**
     * Add order-by as descend. <br>
     * BIZ_DATE: {NotNull, DATE(10)}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_BizDate_Desc() { regOBD("BIZ_DATE"); return this; }

    protected ConditionValue _inDatetime;
    public ConditionValue xdfgetInDatetime()
    { if (_inDatetime == null) { _inDatetime = nCV(); }
      return _inDatetime; }
    protected ConditionValue xgetCValueInDatetime() { return xdfgetInDatetime(); }

    /** 
     * Add order-by as ascend. <br>
     * IN_DATETIME: {DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_InDatetime_Asc() { regOBA("IN_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * IN_DATETIME: {DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_InDatetime_Desc() { regOBD("IN_DATETIME"); return this; }

    protected ConditionValue _outDatetime;
    public ConditionValue xdfgetOutDatetime()
    { if (_outDatetime == null) { _outDatetime = nCV(); }
      return _outDatetime; }
    protected ConditionValue xgetCValueOutDatetime() { return xdfgetOutDatetime(); }

    /** 
     * Add order-by as ascend. <br>
     * OUT_DATETIME: {DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_OutDatetime_Asc() { regOBA("OUT_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * OUT_DATETIME: {DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_OutDatetime_Desc() { regOBD("OUT_DATETIME"); return this; }

    protected ConditionValue _vacationTypeCode;
    public ConditionValue xdfgetVacationTypeCode()
    { if (_vacationTypeCode == null) { _vacationTypeCode = nCV(); }
      return _vacationTypeCode; }
    protected ConditionValue xgetCValueVacationTypeCode() { return xdfgetVacationTypeCode(); }

    /** 
     * Add order-by as ascend. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(3), FK to vacation_type}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_VacationTypeCode_Asc() { regOBA("VACATION_TYPE_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * VACATION_TYPE_CODE: {IX, VARCHAR(3), FK to vacation_type}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_VacationTypeCode_Desc() { regOBD("VACATION_TYPE_CODE"); return this; }

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
    public BsDailyInOutCQ addOrderBy_Note_Asc() { regOBA("NOTE"); return this; }

    /**
     * Add order-by as descend. <br>
     * NOTE: {TEXT(65535)}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_Note_Desc() { regOBD("NOTE"); return this; }

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
    public BsDailyInOutCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

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
    public BsDailyInOutCQ addOrderBy_RegisterUser_Asc() { regOBA("REGISTER_USER"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_RegisterUser_Desc() { regOBD("REGISTER_USER"); return this; }

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
    public BsDailyInOutCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

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
    public BsDailyInOutCQ addOrderBy_UpdateUser_Asc() { regOBA("UPDATE_USER"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_UpdateUser_Desc() { regOBD("UPDATE_USER"); return this; }

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
    public BsDailyInOutCQ addOrderBy_VersionNo_Asc() { regOBA("VERSION_NO"); return this; }

    /**
     * Add order-by as descend. <br>
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsDailyInOutCQ addOrderBy_VersionNo_Desc() { regOBD("VERSION_NO"); return this; }

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
    public BsDailyInOutCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsDailyInOutCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        DailyInOutCQ bq = (DailyInOutCQ)bqs;
        DailyInOutCQ uq = (DailyInOutCQ)uqs;
        if (bq.hasConditionQueryTimecard()) {
            uq.queryTimecard().reflectRelationOnUnionQuery(bq.queryTimecard(), uq.queryTimecard());
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
     * TIMECARD by my TIMECARD_ID, named 'timecard'.
     * @return The instance of condition-query. (NotNull)
     */
    public TimecardCQ queryTimecard() {
        return xdfgetConditionQueryTimecard();
    }
    public TimecardCQ xdfgetConditionQueryTimecard() {
        String prop = "timecard";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryTimecard()); xsetupOuterJoinTimecard(); }
        return xgetQueRlMap(prop);
    }
    protected TimecardCQ xcreateQueryTimecard() {
        String nrp = xresolveNRP("daily_in_out", "timecard"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new TimecardCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "timecard", nrp);
    }
    protected void xsetupOuterJoinTimecard() { xregOutJo("timecard"); }
    public boolean hasConditionQueryTimecard() { return xhasQueRlMap("timecard"); }

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
        String nrp = xresolveNRP("daily_in_out", "vacationType"); String jan = xresolveJAN(nrp, xgetNNLvl());
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
    public Map<String, DailyInOutCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(DailyInOutCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, DailyInOutCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(DailyInOutCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, DailyInOutCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(DailyInOutCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, DailyInOutCQ> _myselfExistsMap;
    public Map<String, DailyInOutCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(DailyInOutCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, DailyInOutCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(DailyInOutCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return DailyInOutCB.class.getName(); }
    protected String xCQ() { return DailyInOutCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
