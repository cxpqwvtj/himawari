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
 * The base condition-query of timecard.
 * @author DBFlute(AutoGenerator)
 */
public class BsTimecardCQ extends AbstractBsTimecardCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected TimecardCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsTimecardCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from timecard) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public TimecardCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected TimecardCIQ xcreateCIQ() {
        TimecardCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected TimecardCIQ xnewCIQ() {
        return new TimecardCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join timecard on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public TimecardCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        TimecardCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _timecardId;
    public ConditionValue xdfgetTimecardId()
    { if (_timecardId == null) { _timecardId = nCV(); }
      return _timecardId; }
    protected ConditionValue xgetCValueTimecardId() { return xdfgetTimecardId(); }

    public Map<String, DailyInOutCQ> xdfgetTimecardId_ExistsReferrer_DailyInOutList() { return xgetSQueMap("timecardId_ExistsReferrer_DailyInOutList"); }
    public String keepTimecardId_ExistsReferrer_DailyInOutList(DailyInOutCQ sq) { return xkeepSQue("timecardId_ExistsReferrer_DailyInOutList", sq); }

    public Map<String, DailyInOutCQ> xdfgetTimecardId_NotExistsReferrer_DailyInOutList() { return xgetSQueMap("timecardId_NotExistsReferrer_DailyInOutList"); }
    public String keepTimecardId_NotExistsReferrer_DailyInOutList(DailyInOutCQ sq) { return xkeepSQue("timecardId_NotExistsReferrer_DailyInOutList", sq); }

    public Map<String, DailyInOutCQ> xdfgetTimecardId_SpecifyDerivedReferrer_DailyInOutList() { return xgetSQueMap("timecardId_SpecifyDerivedReferrer_DailyInOutList"); }
    public String keepTimecardId_SpecifyDerivedReferrer_DailyInOutList(DailyInOutCQ sq) { return xkeepSQue("timecardId_SpecifyDerivedReferrer_DailyInOutList", sq); }

    public Map<String, DailyInOutCQ> xdfgetTimecardId_QueryDerivedReferrer_DailyInOutList() { return xgetSQueMap("timecardId_QueryDerivedReferrer_DailyInOutList"); }
    public String keepTimecardId_QueryDerivedReferrer_DailyInOutList(DailyInOutCQ sq) { return xkeepSQue("timecardId_QueryDerivedReferrer_DailyInOutList", sq); }
    public Map<String, Object> xdfgetTimecardId_QueryDerivedReferrer_DailyInOutListParameter() { return xgetSQuePmMap("timecardId_QueryDerivedReferrer_DailyInOutList"); }
    public String keepTimecardId_QueryDerivedReferrer_DailyInOutListParameter(Object pm) { return xkeepSQuePm("timecardId_QueryDerivedReferrer_DailyInOutList", pm); }

    /** 
     * Add order-by as ascend. <br>
     * TIMECARD_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsTimecardCQ addOrderBy_TimecardId_Asc() { regOBA("TIMECARD_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * TIMECARD_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsTimecardCQ addOrderBy_TimecardId_Desc() { regOBD("TIMECARD_ID"); return this; }

    protected ConditionValue _memberId;
    public ConditionValue xdfgetMemberId()
    { if (_memberId == null) { _memberId = nCV(); }
      return _memberId; }
    protected ConditionValue xgetCValueMemberId() { return xdfgetMemberId(); }

    /** 
     * Add order-by as ascend. <br>
     * MEMBER_ID: {UQ, NotNull, BIGINT(19), FK to member}
     * @return this. (NotNull)
     */
    public BsTimecardCQ addOrderBy_MemberId_Asc() { regOBA("MEMBER_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * MEMBER_ID: {UQ, NotNull, BIGINT(19), FK to member}
     * @return this. (NotNull)
     */
    public BsTimecardCQ addOrderBy_MemberId_Desc() { regOBD("MEMBER_ID"); return this; }

    protected ConditionValue _timecardYearMonth;
    public ConditionValue xdfgetTimecardYearMonth()
    { if (_timecardYearMonth == null) { _timecardYearMonth = nCV(); }
      return _timecardYearMonth; }
    protected ConditionValue xgetCValueTimecardYearMonth() { return xdfgetTimecardYearMonth(); }

    /** 
     * Add order-by as ascend. <br>
     * TIMECARD_YEAR_MONTH: {UQ, NotNull, VARCHAR(6)}
     * @return this. (NotNull)
     */
    public BsTimecardCQ addOrderBy_TimecardYearMonth_Asc() { regOBA("TIMECARD_YEAR_MONTH"); return this; }

    /**
     * Add order-by as descend. <br>
     * TIMECARD_YEAR_MONTH: {UQ, NotNull, VARCHAR(6)}
     * @return this. (NotNull)
     */
    public BsTimecardCQ addOrderBy_TimecardYearMonth_Desc() { regOBD("TIMECARD_YEAR_MONTH"); return this; }

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
    public BsTimecardCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsTimecardCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

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
    public BsTimecardCQ addOrderBy_RegisterUser_Asc() { regOBA("REGISTER_USER"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsTimecardCQ addOrderBy_RegisterUser_Desc() { regOBD("REGISTER_USER"); return this; }

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
    public BsTimecardCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsTimecardCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

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
    public BsTimecardCQ addOrderBy_UpdateUser_Asc() { regOBA("UPDATE_USER"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsTimecardCQ addOrderBy_UpdateUser_Desc() { regOBD("UPDATE_USER"); return this; }

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
    public BsTimecardCQ addOrderBy_VersionNo_Asc() { regOBA("VERSION_NO"); return this; }

    /**
     * Add order-by as descend. <br>
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsTimecardCQ addOrderBy_VersionNo_Desc() { regOBD("VERSION_NO"); return this; }

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
    public BsTimecardCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsTimecardCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        TimecardCQ bq = (TimecardCQ)bqs;
        TimecardCQ uq = (TimecardCQ)uqs;
        if (bq.hasConditionQueryMember()) {
            uq.queryMember().reflectRelationOnUnionQuery(bq.queryMember(), uq.queryMember());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * MEMBER by my MEMBER_ID, named 'member'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberCQ queryMember() {
        return xdfgetConditionQueryMember();
    }
    public MemberCQ xdfgetConditionQueryMember() {
        String prop = "member";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryMember()); xsetupOuterJoinMember(); }
        return xgetQueRlMap(prop);
    }
    protected MemberCQ xcreateQueryMember() {
        String nrp = xresolveNRP("timecard", "member"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new MemberCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "member", nrp);
    }
    protected void xsetupOuterJoinMember() { xregOutJo("member"); }
    public boolean hasConditionQueryMember() { return xhasQueRlMap("member"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, TimecardCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(TimecardCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, TimecardCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(TimecardCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, TimecardCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(TimecardCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, TimecardCQ> _myselfExistsMap;
    public Map<String, TimecardCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(TimecardCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, TimecardCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(TimecardCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return TimecardCB.class.getName(); }
    protected String xCQ() { return TimecardCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
