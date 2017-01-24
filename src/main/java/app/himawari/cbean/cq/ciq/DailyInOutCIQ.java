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
 * The condition-query for in-line of daily_in_out.
 * @author DBFlute(AutoGenerator)
 */
public class DailyInOutCIQ extends AbstractBsDailyInOutCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsDailyInOutCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public DailyInOutCIQ(ConditionQuery referrerQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsDailyInOutCQ myCQ) {
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
    protected ConditionValue xgetCValueDailyInOutId() { return _myCQ.xdfgetDailyInOutId(); }
    protected ConditionValue xgetCValueTimecardId() { return _myCQ.xdfgetTimecardId(); }
    protected ConditionValue xgetCValueBizDate() { return _myCQ.xdfgetBizDate(); }
    protected ConditionValue xgetCValueStartDatetime() { return _myCQ.xdfgetStartDatetime(); }
    protected ConditionValue xgetCValueFinishDatetime() { return _myCQ.xdfgetFinishDatetime(); }
    protected ConditionValue xgetCValueAmendedStartTime() { return _myCQ.xdfgetAmendedStartTime(); }
    protected ConditionValue xgetCValueAmendedFinishTime() { return _myCQ.xdfgetAmendedFinishTime(); }
    protected ConditionValue xgetCValueVacationTypeCode() { return _myCQ.xdfgetVacationTypeCode(); }
    protected ConditionValue xgetCValueNote() { return _myCQ.xdfgetNote(); }
    protected ConditionValue xgetCValueRegisterDatetime() { return _myCQ.xdfgetRegisterDatetime(); }
    protected ConditionValue xgetCValueRegisterUser() { return _myCQ.xdfgetRegisterUser(); }
    protected ConditionValue xgetCValueUpdateDatetime() { return _myCQ.xdfgetUpdateDatetime(); }
    protected ConditionValue xgetCValueUpdateUser() { return _myCQ.xdfgetUpdateUser(); }
    protected ConditionValue xgetCValueVersionNo() { return _myCQ.xdfgetVersionNo(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String pp) { return null; }
    public String keepScalarCondition(DailyInOutCQ sq)
    { throwIICBOE("ScalarCondition"); return null; }
    public String keepSpecifyMyselfDerived(DailyInOutCQ sq)
    { throwIICBOE("(Specify)MyselfDerived"); return null;}
    public String keepQueryMyselfDerived(DailyInOutCQ sq)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepQueryMyselfDerivedParameter(Object vl)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepMyselfExists(DailyInOutCQ sq)
    { throwIICBOE("MyselfExists"); return null;}

    protected void throwIICBOE(String name)
    { throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported."); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return DailyInOutCB.class.getName(); }
    protected String xinCQ() { return DailyInOutCQ.class.getName(); }
}
