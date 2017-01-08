package app.himawari.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import app.himawari.exbhv.*;
import app.himawari.exentity.*;

/**
 * The referrer loader of MEMBER as TABLE. <br>
 * <pre>
 * [primary key]
 *     MEMBER_ID
 *
 * [column]
 *     MEMBER_ID, MEMBER_NAME, MEMBER_ACCOUNT_ID, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 *
 * [sequence]
 *     
 *
 * [identity]
 *     MEMBER_ID
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *     TIMECARD(AsOne)
 *
 * [referrer table]
 *     TIMECARD
 *
 * [foreign property]
 *     timecardAsOne
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfMember {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Member> _selectedList;
    protected BehaviorSelector _selector;
    protected MemberBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfMember ready(List<Member> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected MemberBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(MemberBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfTimecard _foreignTimecardAsOneLoader;
    public LoaderOfTimecard pulloutTimecardAsOne() {
        if (_foreignTimecardAsOneLoader == null)
        { _foreignTimecardAsOneLoader = new LoaderOfTimecard().ready(myBhv().pulloutTimecardAsOne(_selectedList), _selector); }
        return _foreignTimecardAsOneLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Member> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
