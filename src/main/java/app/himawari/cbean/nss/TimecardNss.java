package app.himawari.cbean.nss;

import app.himawari.cbean.cq.TimecardCQ;

/**
 * The nest select set-upper of timecard.
 * @author DBFlute(AutoGenerator)
 */
public class TimecardNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final TimecardCQ _query;
    public TimecardNss(TimecardCQ query) { _query = query; }
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
