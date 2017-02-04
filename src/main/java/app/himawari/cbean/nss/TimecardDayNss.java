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
     * TIMECARD by my TIMECARD_ID, named 'timecard'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public TimecardNss withTimecard() {
        _query.xdoNss(() -> _query.queryTimecard());
        return new TimecardNss(_query.queryTimecard());
    }
}
