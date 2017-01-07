package app.himawari.cbean.nss;

import app.himawari.cbean.cq.MemberCQ;

/**
 * The nest select set-upper of member.
 * @author DBFlute(AutoGenerator)
 */
public class MemberNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final MemberCQ _query;
    public MemberNss(MemberCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * timecard by MEMBER_ID, named 'timecardAsOne'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public TimecardNss withTimecardAsOne() {
        _query.xdoNss(() -> _query.queryTimecardAsOne());
        return new TimecardNss(_query.queryTimecardAsOne());
    }
}
