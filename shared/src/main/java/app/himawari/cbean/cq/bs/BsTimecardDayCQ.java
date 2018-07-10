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
 * The base condition-query of TIMECARD_DAY.
 * @author DBFlute(AutoGenerator)
 */
public class BsTimecardDayCQ extends AbstractBsTimecardDayCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected TimecardDayCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsTimecardDayCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from TIMECARD_DAY) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public TimecardDayCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected TimecardDayCIQ xcreateCIQ() {
        TimecardDayCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected TimecardDayCIQ xnewCIQ() {
        return new TimecardDayCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join TIMECARD_DAY on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public TimecardDayCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        TimecardDayCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _timecardDayId;
    public ConditionValue xdfgetTimecardDayId()
    { if (_timecardDayId == null) { _timecardDayId = nCV(); }
      return _timecardDayId; }
    protected ConditionValue xgetCValueTimecardDayId() { return xdfgetTimecardDayId(); }

    public Map<String, DailyStartEndCQ> xdfgetTimecardDayId_ExistsReferrer_DailyStartEndList() { return xgetSQueMap("timecardDayId_ExistsReferrer_DailyStartEndList"); }
    public String keepTimecardDayId_ExistsReferrer_DailyStartEndList(DailyStartEndCQ sq) { return xkeepSQue("timecardDayId_ExistsReferrer_DailyStartEndList", sq); }

    public Map<String, DailyStartEndCQ> xdfgetTimecardDayId_NotExistsReferrer_DailyStartEndList() { return xgetSQueMap("timecardDayId_NotExistsReferrer_DailyStartEndList"); }
    public String keepTimecardDayId_NotExistsReferrer_DailyStartEndList(DailyStartEndCQ sq) { return xkeepSQue("timecardDayId_NotExistsReferrer_DailyStartEndList", sq); }

    public Map<String, DailyStartEndCQ> xdfgetTimecardDayId_SpecifyDerivedReferrer_DailyStartEndList() { return xgetSQueMap("timecardDayId_SpecifyDerivedReferrer_DailyStartEndList"); }
    public String keepTimecardDayId_SpecifyDerivedReferrer_DailyStartEndList(DailyStartEndCQ sq) { return xkeepSQue("timecardDayId_SpecifyDerivedReferrer_DailyStartEndList", sq); }

    public Map<String, DailyStartEndCQ> xdfgetTimecardDayId_QueryDerivedReferrer_DailyStartEndList() { return xgetSQueMap("timecardDayId_QueryDerivedReferrer_DailyStartEndList"); }
    public String keepTimecardDayId_QueryDerivedReferrer_DailyStartEndList(DailyStartEndCQ sq) { return xkeepSQue("timecardDayId_QueryDerivedReferrer_DailyStartEndList", sq); }
    public Map<String, Object> xdfgetTimecardDayId_QueryDerivedReferrer_DailyStartEndListParameter() { return xgetSQuePmMap("timecardDayId_QueryDerivedReferrer_DailyStartEndList"); }
    public String keepTimecardDayId_QueryDerivedReferrer_DailyStartEndListParameter(Object pm) { return xkeepSQuePm("timecardDayId_QueryDerivedReferrer_DailyStartEndList", pm); }

    /**
     * Add order-by as ascend. <br>
     * TIMECARD_DAY_ID: {PK, ID, NotNull, BIGINT(19), FK to DAILY_START_END}
     * @return this. (NotNull)
     */
    public BsTimecardDayCQ addOrderBy_TimecardDayId_Asc() { regOBA("TIMECARD_DAY_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * TIMECARD_DAY_ID: {PK, ID, NotNull, BIGINT(19), FK to DAILY_START_END}
     * @return this. (NotNull)
     */
    public BsTimecardDayCQ addOrderBy_TimecardDayId_Desc() { regOBD("TIMECARD_DAY_ID"); return this; }

    protected ConditionValue _memberId;
    public ConditionValue xdfgetMemberId()
    { if (_memberId == null) { _memberId = nCV(); }
      return _memberId; }
    protected ConditionValue xgetCValueMemberId() { return xdfgetMemberId(); }

    /**
     * Add order-by as ascend. <br>
     * MEMBER_ID: {UQ+, NotNull, BIGINT(19), FK to MEMBER}
     * @return this. (NotNull)
     */
    public BsTimecardDayCQ addOrderBy_MemberId_Asc() { regOBA("MEMBER_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * MEMBER_ID: {UQ+, NotNull, BIGINT(19), FK to MEMBER}
     * @return this. (NotNull)
     */
    public BsTimecardDayCQ addOrderBy_MemberId_Desc() { regOBD("MEMBER_ID"); return this; }

    protected ConditionValue _bizDate;
    public ConditionValue xdfgetBizDate()
    { if (_bizDate == null) { _bizDate = nCV(); }
      return _bizDate; }
    protected ConditionValue xgetCValueBizDate() { return xdfgetBizDate(); }

    /**
     * Add order-by as ascend. <br>
     * BIZ_DATE: {+UQ, NotNull, DATE(10)}
     * @return this. (NotNull)
     */
    public BsTimecardDayCQ addOrderBy_BizDate_Asc() { regOBA("BIZ_DATE"); return this; }

    /**
     * Add order-by as descend. <br>
     * BIZ_DATE: {+UQ, NotNull, DATE(10)}
     * @return this. (NotNull)
     */
    public BsTimecardDayCQ addOrderBy_BizDate_Desc() { regOBD("BIZ_DATE"); return this; }

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
    public BsTimecardDayCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsTimecardDayCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

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
    public BsTimecardDayCQ addOrderBy_RegisterUser_Asc() { regOBA("REGISTER_USER"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsTimecardDayCQ addOrderBy_RegisterUser_Desc() { regOBD("REGISTER_USER"); return this; }

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
    public BsTimecardDayCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsTimecardDayCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

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
    public BsTimecardDayCQ addOrderBy_UpdateUser_Asc() { regOBA("UPDATE_USER"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsTimecardDayCQ addOrderBy_UpdateUser_Desc() { regOBD("UPDATE_USER"); return this; }

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
    public BsTimecardDayCQ addOrderBy_VersionNo_Asc() { regOBA("VERSION_NO"); return this; }

    /**
     * Add order-by as descend. <br>
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsTimecardDayCQ addOrderBy_VersionNo_Desc() { regOBD("VERSION_NO"); return this; }

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
    public BsTimecardDayCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsTimecardDayCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        TimecardDayCQ bq = (TimecardDayCQ)bqs;
        TimecardDayCQ uq = (TimecardDayCQ)uqs;
        if (bq.hasConditionQueryMember()) {
            uq.queryMember().reflectRelationOnUnionQuery(bq.queryMember(), uq.queryMember());
        }
        if (bq.hasConditionQueryDailyStartEndAsCurrentValue()) {
            uq.queryDailyStartEndAsCurrentValue().reflectRelationOnUnionQuery(bq.queryDailyStartEndAsCurrentValue(), uq.queryDailyStartEndAsCurrentValue());
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
        String nrp = xresolveNRP("TIMECARD_DAY", "member"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new MemberCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "member", nrp);
    }
    protected void xsetupOuterJoinMember() { xregOutJo("member"); }
    public boolean hasConditionQueryMember() { return xhasQueRlMap("member"); }

    /**
     * Get the condition-query for relation table. <br>
     * DAILY_START_END by my TIMECARD_DAY_ID, named 'dailyStartEndAsCurrentValue'. <br>
     * "最新の履歴を取得します"
     * @return The instance of condition-query. (NotNull)
     */
    public DailyStartEndCQ queryDailyStartEndAsCurrentValue() {
        return xdfgetConditionQueryDailyStartEndAsCurrentValue();
    }
    public DailyStartEndCQ xdfgetConditionQueryDailyStartEndAsCurrentValue() {
        String prop = "dailyStartEndAsCurrentValue";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryDailyStartEndAsCurrentValue()); xsetupOuterJoinDailyStartEndAsCurrentValue(); }
        return xgetQueRlMap(prop);
    }
    protected DailyStartEndCQ xcreateQueryDailyStartEndAsCurrentValue() {
        String nrp = xresolveNRP("TIMECARD_DAY", "dailyStartEndAsCurrentValue"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new DailyStartEndCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "dailyStartEndAsCurrentValue", nrp);
    }
    protected void xsetupOuterJoinDailyStartEndAsCurrentValue() { xregOutJo("dailyStartEndAsCurrentValue"); }
    public boolean hasConditionQueryDailyStartEndAsCurrentValue() { return xhasQueRlMap("dailyStartEndAsCurrentValue"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, TimecardDayCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(TimecardDayCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, TimecardDayCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(TimecardDayCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, TimecardDayCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(TimecardDayCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, TimecardDayCQ> _myselfExistsMap;
    public Map<String, TimecardDayCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(TimecardDayCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, TimecardDayCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(TimecardDayCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return TimecardDayCB.class.getName(); }
    protected String xCQ() { return TimecardDayCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
