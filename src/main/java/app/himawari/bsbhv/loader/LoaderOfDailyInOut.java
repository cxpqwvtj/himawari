package app.himawari.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import app.himawari.exbhv.*;
import app.himawari.exentity.*;

/**
 * The referrer loader of daily_in_out as TABLE. <br>
 * <pre>
 * [primary key]
 *     DAILY_IN_OUT_ID
 *
 * [column]
 *     DAILY_IN_OUT_ID, TIMECARD_ID, IN_DATETIME, OUT_DATETIME, VACATION_TYPE_CODE, NOTE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 *
 * [sequence]
 *     
 *
 * [identity]
 *     DAILY_IN_OUT_ID
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *     timecard, vacation_type
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     timecard, vacationType
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfDailyInOut {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<DailyInOut> _selectedList;
    protected BehaviorSelector _selector;
    protected DailyInOutBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfDailyInOut ready(List<DailyInOut> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected DailyInOutBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(DailyInOutBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfTimecard _foreignTimecardLoader;
    public LoaderOfTimecard pulloutTimecard() {
        if (_foreignTimecardLoader == null)
        { _foreignTimecardLoader = new LoaderOfTimecard().ready(myBhv().pulloutTimecard(_selectedList), _selector); }
        return _foreignTimecardLoader;
    }

    protected LoaderOfVacationType _foreignVacationTypeLoader;
    public LoaderOfVacationType pulloutVacationType() {
        if (_foreignVacationTypeLoader == null)
        { _foreignVacationTypeLoader = new LoaderOfVacationType().ready(myBhv().pulloutVacationType(_selectedList), _selector); }
        return _foreignVacationTypeLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<DailyInOut> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
