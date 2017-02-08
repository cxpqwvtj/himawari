package app.himawari.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import app.himawari.exbhv.*;
import app.himawari.exentity.*;
import app.himawari.cbean.*;

/**
 * The referrer loader of ROLE as TABLE. <br>
 * <pre>
 * [primary key]
 *     ROLE_TYPE_CODE
 *
 * [column]
 *     ROLE_TYPE_CODE, ROLE_NAME, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 *
 * [sequence]
 *     
 *
 * [identity]
 *     
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *     
 *
 * [referrer table]
 *     MEMBER
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     memberList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfRole {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Role> _selectedList;
    protected BehaviorSelector _selector;
    protected RoleBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfRole ready(List<Role> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected RoleBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(RoleBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<Member> _referrerMember;

    /**
     * Load referrer of memberList by the set-upper of referrer. <br>
     * MEMBER by ROLE_TYPE_CODE, named 'memberList'.
     * <pre>
     * <span style="color: #0000C0">roleBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">roleList</span>, <span style="color: #553000">roleLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">roleLoader</span>.<span style="color: #CC4747">loadMember</span>(<span style="color: #553000">memberCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">memberCB</span>.setupSelect...
     *         <span style="color: #553000">memberCB</span>.query().set...
     *         <span style="color: #553000">memberCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">memberLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    memberLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Role role : <span style="color: #553000">roleList</span>) {
     *     ... = role.<span style="color: #CC4747">getMemberList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setRoleTypeCode_InScope(pkList);
     * cb.query().addOrderBy_RoleTypeCode_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfMember> loadMember(ReferrerConditionSetupper<MemberCB> refCBLambda) {
        myBhv().loadMember(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerMember = refLs);
        return hd -> hd.handle(new LoaderOfMember().ready(_referrerMember, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Role> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
