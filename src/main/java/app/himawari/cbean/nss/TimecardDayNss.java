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
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public MemberNss withMember() {
        _query.xdoNss(() -> _query.queryMember());
        return new MemberNss(_query.queryMember());
    }
    /**
     * With nested relation columns to select clause. <br>
     * DAILY_START_END by my TIMECARD_DAY_ID, named 'dailyStartEndAsCurrentValue'. <br>
     * "最新の履歴を取得します"
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public DailyStartEndNss withDailyStartEndAsCurrentValue() {
        _query.xdoNss(() -> _query.queryDailyStartEndAsCurrentValue());
        return new DailyStartEndNss(_query.queryDailyStartEndAsCurrentValue());
    }
}
