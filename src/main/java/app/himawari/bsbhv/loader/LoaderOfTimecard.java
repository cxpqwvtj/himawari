package app.himawari.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import app.himawari.exbhv.*;
import app.himawari.exentity.*;
import app.himawari.cbean.*;

/**
 * The referrer loader of timecard as TABLE. <br>
 * <pre>
 * [primary key]
 *     TIMECARD_ID
 *
 * [column]
 *     TIMECARD_ID, MEMBER_ID, TIMECARD_YEAR_MONTH, REGISTER_DATETIME, REGISTER_USER, REGISTER_PROCESS, UPDATE_DATETIME, UPDATE_USER, UPDATE_PROCESS, VERSION_NO
 *
 * [sequence]
 *     
 *
 * [identity]
 *     TIMECARD_ID
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *     member
 *
 * [referrer table]
 *     daily_in_out
 *
 * [foreign property]
 *     member
 *
 * [referrer property]
 *     dailyInOutList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfTimecard {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Timecard> _selectedList;
    protected BehaviorSelector _selector;
    protected TimecardBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfTimecard ready(List<Timecard> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected TimecardBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(TimecardBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<DailyInOut> _referrerDailyInOut;

    /**
     * Load referrer of dailyInOutList by the set-upper of referrer. <br>
     * daily_in_out by TIMECARD_ID, named 'dailyInOutList'.
     * <pre>
     * <span style="color: #0000C0">timecardBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">timecardList</span>, <span style="color: #553000">timecardLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">timecardLoader</span>.<span style="color: #CC4747">loadDailyInOut</span>(<span style="color: #553000">outCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">outCB</span>.setupSelect...
     *         <span style="color: #553000">outCB</span>.query().set...
     *         <span style="color: #553000">outCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">outLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    outLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Timecard timecard : <span style="color: #553000">timecardList</span>) {
     *     ... = timecard.<span style="color: #CC4747">getDailyInOutList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setTimecardId_InScope(pkList);
     * cb.query().addOrderBy_TimecardId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfDailyInOut> loadDailyInOut(ReferrerConditionSetupper<DailyInOutCB> refCBLambda) {
        myBhv().loadDailyInOut(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerDailyInOut = refLs);
        return hd -> hd.handle(new LoaderOfDailyInOut().ready(_referrerDailyInOut, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfMember _foreignMemberLoader;
    public LoaderOfMember pulloutMember() {
        if (_foreignMemberLoader == null)
        { _foreignMemberLoader = new LoaderOfMember().ready(myBhv().pulloutMember(_selectedList), _selector); }
        return _foreignMemberLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Timecard> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
