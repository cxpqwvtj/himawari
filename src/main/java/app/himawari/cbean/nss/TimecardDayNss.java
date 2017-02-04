package app.himawari.cbean.nss;

import app.himawari.cbean.cq.TimecardDayCQ;

/**
 * The nest select set-upper of TIMECARD_DAY.
 * @author DBFlute(AutoGenerator)
 */
public class TimecardDayNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final TimecardDayCQ _query;
    public TimecardDayNss(TimecardDayCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * MEMBER by my MEMBER_ID, named 'member'.
     */
    public void withMember() {
        _query.xdoNss(() -> _query.queryMember());
    }
}
