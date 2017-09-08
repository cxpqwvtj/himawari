package app.himawari.cbean.nss;

import app.himawari.cbean.cq.MemberRoleCQ;

/**
 * The nest select set-upper of MEMBER_ROLE.
 * @author DBFlute(AutoGenerator)
 */
public class MemberRoleNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final MemberRoleCQ _query;
    public MemberRoleNss(MemberRoleCQ query) { _query = query; }
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
    /**
     * With nested relation columns to select clause. <br>
     * ROLE by my ROLE_TYPE_CODE, named 'role'.
     */
    public void withRole() {
        _query.xdoNss(() -> _query.queryRole());
    }
}
