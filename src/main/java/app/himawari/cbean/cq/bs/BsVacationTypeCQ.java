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
 * The base condition-query of vacation_type.
 * @author DBFlute(AutoGenerator)
 */
public class BsVacationTypeCQ extends AbstractBsVacationTypeCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected VacationTypeCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsVacationTypeCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from vacation_type) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public VacationTypeCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected VacationTypeCIQ xcreateCIQ() {
        VacationTypeCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected VacationTypeCIQ xnewCIQ() {
        return new VacationTypeCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join vacation_type on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public VacationTypeCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        VacationTypeCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _vacationTypeCode;
    public ConditionValue xdfgetVacationTypeCode()
    { if (_vacationTypeCode == null) { _vacationTypeCode = nCV(); }
      return _vacationTypeCode; }
    protected ConditionValue xgetCValueVacationTypeCode() { return xdfgetVacationTypeCode(); }

    public Map<String, DailyInOutCQ> xdfgetVacationTypeCode_ExistsReferrer_DailyInOutList() { return xgetSQueMap("vacationTypeCode_ExistsReferrer_DailyInOutList"); }
    public String keepVacationTypeCode_ExistsReferrer_DailyInOutList(DailyInOutCQ sq) { return xkeepSQue("vacationTypeCode_ExistsReferrer_DailyInOutList", sq); }

    public Map<String, DailyInOutCQ> xdfgetVacationTypeCode_NotExistsReferrer_DailyInOutList() { return xgetSQueMap("vacationTypeCode_NotExistsReferrer_DailyInOutList"); }
    public String keepVacationTypeCode_NotExistsReferrer_DailyInOutList(DailyInOutCQ sq) { return xkeepSQue("vacationTypeCode_NotExistsReferrer_DailyInOutList", sq); }

    public Map<String, DailyInOutCQ> xdfgetVacationTypeCode_SpecifyDerivedReferrer_DailyInOutList() { return xgetSQueMap("vacationTypeCode_SpecifyDerivedReferrer_DailyInOutList"); }
    public String keepVacationTypeCode_SpecifyDerivedReferrer_DailyInOutList(DailyInOutCQ sq) { return xkeepSQue("vacationTypeCode_SpecifyDerivedReferrer_DailyInOutList", sq); }

    public Map<String, DailyInOutCQ> xdfgetVacationTypeCode_QueryDerivedReferrer_DailyInOutList() { return xgetSQueMap("vacationTypeCode_QueryDerivedReferrer_DailyInOutList"); }
    public String keepVacationTypeCode_QueryDerivedReferrer_DailyInOutList(DailyInOutCQ sq) { return xkeepSQue("vacationTypeCode_QueryDerivedReferrer_DailyInOutList", sq); }
    public Map<String, Object> xdfgetVacationTypeCode_QueryDerivedReferrer_DailyInOutListParameter() { return xgetSQuePmMap("vacationTypeCode_QueryDerivedReferrer_DailyInOutList"); }
    public String keepVacationTypeCode_QueryDerivedReferrer_DailyInOutListParameter(Object pm) { return xkeepSQuePm("vacationTypeCode_QueryDerivedReferrer_DailyInOutList", pm); }

    /** 
     * Add order-by as ascend. <br>
     * VACATION_TYPE_CODE: {PK, NotNull, VARCHAR(3)}
     * @return this. (NotNull)
     */
    public BsVacationTypeCQ addOrderBy_VacationTypeCode_Asc() { regOBA("VACATION_TYPE_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * VACATION_TYPE_CODE: {PK, NotNull, VARCHAR(3)}
     * @return this. (NotNull)
     */
    public BsVacationTypeCQ addOrderBy_VacationTypeCode_Desc() { regOBD("VACATION_TYPE_CODE"); return this; }

    protected ConditionValue _vacationTypeName;
    public ConditionValue xdfgetVacationTypeName()
    { if (_vacationTypeName == null) { _vacationTypeName = nCV(); }
      return _vacationTypeName; }
    protected ConditionValue xgetCValueVacationTypeName() { return xdfgetVacationTypeName(); }

    /** 
     * Add order-by as ascend. <br>
     * VACATION_TYPE_NAME: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsVacationTypeCQ addOrderBy_VacationTypeName_Asc() { regOBA("VACATION_TYPE_NAME"); return this; }

    /**
     * Add order-by as descend. <br>
     * VACATION_TYPE_NAME: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsVacationTypeCQ addOrderBy_VacationTypeName_Desc() { regOBD("VACATION_TYPE_NAME"); return this; }

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
    public BsVacationTypeCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsVacationTypeCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

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
    public BsVacationTypeCQ addOrderBy_RegisterUser_Asc() { regOBA("REGISTER_USER"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsVacationTypeCQ addOrderBy_RegisterUser_Desc() { regOBD("REGISTER_USER"); return this; }

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
    public BsVacationTypeCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsVacationTypeCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

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
    public BsVacationTypeCQ addOrderBy_UpdateUser_Asc() { regOBA("UPDATE_USER"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsVacationTypeCQ addOrderBy_UpdateUser_Desc() { regOBD("UPDATE_USER"); return this; }

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
    public BsVacationTypeCQ addOrderBy_VersionNo_Asc() { regOBA("VERSION_NO"); return this; }

    /**
     * Add order-by as descend. <br>
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsVacationTypeCQ addOrderBy_VersionNo_Desc() { regOBD("VERSION_NO"); return this; }

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
    public BsVacationTypeCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsVacationTypeCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, VacationTypeCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(VacationTypeCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, VacationTypeCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(VacationTypeCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, VacationTypeCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(VacationTypeCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, VacationTypeCQ> _myselfExistsMap;
    public Map<String, VacationTypeCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(VacationTypeCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, VacationTypeCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(VacationTypeCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return VacationTypeCB.class.getName(); }
    protected String xCQ() { return VacationTypeCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
