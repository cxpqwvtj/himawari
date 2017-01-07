package app.himawari.cbean.cq.ciq;

import java.util.Map;
import org.dbflute.cbean.*;
import org.dbflute.cbean.ckey.*;
import org.dbflute.cbean.coption.ConditionOption;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.exception.IllegalConditionBeanOperationException;
import app.himawari.cbean.*;
import app.himawari.cbean.cq.bs.*;
import app.himawari.cbean.cq.*;

/**
 * The condition-query for in-line of vacation_type.
 * @author DBFlute(AutoGenerator)
 */
public class VacationTypeCIQ extends AbstractBsVacationTypeCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsVacationTypeCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public VacationTypeCIQ(ConditionQuery referrerQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsVacationTypeCQ myCQ) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
        _myCQ = myCQ;
        _foreignPropertyName = _myCQ.xgetForeignPropertyName(); // accept foreign property name
        _relationPath = _myCQ.xgetRelationPath(); // accept relation path
        _inline = true;
    }

    // ===================================================================================
    //                                                             Override about Register
    //                                                             =======================
    protected void reflectRelationOnUnionQuery(ConditionQuery bq, ConditionQuery uq)
    { throw new IllegalConditionBeanOperationException("InlineView cannot use Union: " + bq + " : " + uq); }

    @Override
    protected void setupConditionValueAndRegisterWhereClause(ConditionKey k, Object v, ConditionValue cv, String col)
    { regIQ(k, v, cv, col); }

    @Override
    protected void setupConditionValueAndRegisterWhereClause(ConditionKey k, Object v, ConditionValue cv, String col, ConditionOption op)
    { regIQ(k, v, cv, col, op); }

    @Override
    protected void registerWhereClause(String wc)
    { registerInlineWhereClause(wc); }

    @Override
    protected boolean isInScopeRelationSuppressLocalAliasName() {
        if (_onClause) { throw new IllegalConditionBeanOperationException("InScopeRelation on OnClause is unsupported."); }
        return true;
    }

    // ===================================================================================
    //                                                                Override about Query
    //                                                                ====================
    protected ConditionValue xgetCValueVacationTypeCode() { return _myCQ.xdfgetVacationTypeCode(); }
    public String keepVacationTypeCode_ExistsReferrer_DailyInOutList(DailyInOutCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepVacationTypeCode_NotExistsReferrer_DailyInOutList(DailyInOutCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepVacationTypeCode_SpecifyDerivedReferrer_DailyInOutList(DailyInOutCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepVacationTypeCode_QueryDerivedReferrer_DailyInOutList(DailyInOutCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepVacationTypeCode_QueryDerivedReferrer_DailyInOutListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    protected ConditionValue xgetCValueVacationTypeName() { return _myCQ.xdfgetVacationTypeName(); }
    protected ConditionValue xgetCValueRegisterDatetime() { return _myCQ.xdfgetRegisterDatetime(); }
    protected ConditionValue xgetCValueRegisterUser() { return _myCQ.xdfgetRegisterUser(); }
    protected ConditionValue xgetCValueRegisterProcess() { return _myCQ.xdfgetRegisterProcess(); }
    protected ConditionValue xgetCValueUpdateDatetime() { return _myCQ.xdfgetUpdateDatetime(); }
    protected ConditionValue xgetCValueUpdateUser() { return _myCQ.xdfgetUpdateUser(); }
    protected ConditionValue xgetCValueUpdateProcess() { return _myCQ.xdfgetUpdateProcess(); }
    protected ConditionValue xgetCValueVersionNo() { return _myCQ.xdfgetVersionNo(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String pp) { return null; }
    public String keepScalarCondition(VacationTypeCQ sq)
    { throwIICBOE("ScalarCondition"); return null; }
    public String keepSpecifyMyselfDerived(VacationTypeCQ sq)
    { throwIICBOE("(Specify)MyselfDerived"); return null;}
    public String keepQueryMyselfDerived(VacationTypeCQ sq)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepQueryMyselfDerivedParameter(Object vl)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepMyselfExists(VacationTypeCQ sq)
    { throwIICBOE("MyselfExists"); return null;}

    protected void throwIICBOE(String name)
    { throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported."); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return VacationTypeCB.class.getName(); }
    protected String xinCQ() { return VacationTypeCQ.class.getName(); }
}
