package app.himawari.cbean.nss;

import app.himawari.cbean.cq.DailyInOutCQ;

/**
 * The nest select set-upper of daily_in_out.
 * @author DBFlute(AutoGenerator)
 */
public class DailyInOutNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final DailyInOutCQ _query;
    public DailyInOutNss(DailyInOutCQ query) { _query = query; }
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
    /**
     * With nested relation columns to select clause. <br>
     * VACATION_TYPE by my VACATION_TYPE_CODE, named 'vacationType'.
     */
    public void withVacationType() {
        _query.xdoNss(() -> _query.queryVacationType());
    }
}
