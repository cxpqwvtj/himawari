package app.himawari.cbean.nss;

import app.himawari.cbean.cq.DailyStartEndCQ;

/**
 * The nest select set-upper of DAILY_START_END.
 * @author DBFlute(AutoGenerator)
 */
public class DailyStartEndNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final DailyStartEndCQ _query;
    public DailyStartEndNss(DailyStartEndCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * TIMECARD_DAY by my TIMECARD_DAY_ID, named 'timecardDay'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public TimecardDayNss withTimecardDay() {
        _query.xdoNss(() -> _query.queryTimecardDay());
        return new TimecardDayNss(_query.queryTimecardDay());
    }
    /**
     * With nested relation columns to select clause. <br>
     * VACATION_TYPE by my VACATION_TYPE_CODE, named 'vacationType'.
     */
    public void withVacationType() {
        _query.xdoNss(() -> _query.queryVacationType());
    }
}
