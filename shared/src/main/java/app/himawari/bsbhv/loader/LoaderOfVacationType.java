package app.himawari.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import app.himawari.exbhv.*;
import app.himawari.exentity.*;
import app.himawari.cbean.*;

/**
 * The referrer loader of VACATION_TYPE as TABLE. <br>
 * <pre>
 * [primary key]
 *     VACATION_TYPE_CODE
 *
 * [column]
 *     VACATION_TYPE_CODE, VACATION_TYPE_NAME, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
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
 *     DAILY_START_END
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     dailyStartEndList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfVacationType {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<VacationType> _selectedList;
    protected BehaviorSelector _selector;
    protected VacationTypeBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfVacationType ready(List<VacationType> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected VacationTypeBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(VacationTypeBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<DailyStartEnd> _referrerDailyStartEnd;

    /**
     * Load referrer of dailyStartEndList by the set-upper of referrer. <br>
     * DAILY_START_END by VACATION_TYPE_CODE, named 'dailyStartEndList'.
     * <pre>
     * <span style="color: #0000C0">vacationTypeBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">vacationTypeList</span>, <span style="color: #553000">typeLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">typeLoader</span>.<span style="color: #CC4747">loadDailyStartEnd</span>(<span style="color: #553000">endCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">endCB</span>.setupSelect...
     *         <span style="color: #553000">endCB</span>.query().set...
     *         <span style="color: #553000">endCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">endLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    endLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (VacationType vacationType : <span style="color: #553000">vacationTypeList</span>) {
     *     ... = vacationType.<span style="color: #CC4747">getDailyStartEndList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVacationTypeCode_InScope(pkList);
     * cb.query().addOrderBy_VacationTypeCode_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfDailyStartEnd> loadDailyStartEnd(ReferrerConditionSetupper<DailyStartEndCB> refCBLambda) {
        myBhv().loadDailyStartEnd(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerDailyStartEnd = refLs);
        return hd -> hd.handle(new LoaderOfDailyStartEnd().ready(_referrerDailyStartEnd, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<VacationType> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
