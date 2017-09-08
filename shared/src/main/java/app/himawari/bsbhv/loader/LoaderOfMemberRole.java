package app.himawari.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import app.himawari.exbhv.*;
import app.himawari.exentity.*;

/**
 * The referrer loader of MEMBER_ROLE as TABLE. <br>
 * <pre>
 * [primary key]
 *     MEMBER_ROLE_ID
 *
 * [column]
 *     MEMBER_ROLE_ID, MEMBER_ID, ROLE_TYPE_CODE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 *
 * [sequence]
 *     
 *
 * [identity]
 *     MEMBER_ROLE_ID
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *     MEMBER, ROLE
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     member, role
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfMemberRole {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<MemberRole> _selectedList;
    protected BehaviorSelector _selector;
    protected MemberRoleBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfMemberRole ready(List<MemberRole> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected MemberRoleBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(MemberRoleBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfMember _foreignMemberLoader;
    public LoaderOfMember pulloutMember() {
        if (_foreignMemberLoader == null)
        { _foreignMemberLoader = new LoaderOfMember().ready(myBhv().pulloutMember(_selectedList), _selector); }
        return _foreignMemberLoader;
    }

    protected LoaderOfRole _foreignRoleLoader;
    public LoaderOfRole pulloutRole() {
        if (_foreignRoleLoader == null)
        { _foreignRoleLoader = new LoaderOfRole().ready(myBhv().pulloutRole(_selectedList), _selector); }
        return _foreignRoleLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<MemberRole> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
