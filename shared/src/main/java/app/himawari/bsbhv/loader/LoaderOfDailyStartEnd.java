package app.himawari.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import app.himawari.exbhv.*;
import app.himawari.exentity.*;

/**
 * The referrer loader of DAILY_START_END as TABLE. <br>
 * <pre>
 * [primary key]
 *     DAILY_START_END_ID
 *
 * [column]
 *     DAILY_START_END_ID, TIMECARD_DAY_ID, START_DATETIME, END_DATETIME, VACATION_TYPE_CODE, NOTE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 *
 * [sequence]
 *     
 *
 * [identity]
 *     DAILY_START_END_ID
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *     TIMECARD_DAY, VACATION_TYPE
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     timecardDay, vacationType
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfDailyStartEnd {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<DailyStartEnd> _selectedList;
    protected BehaviorSelector _selector;
    protected DailyStartEndBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfDailyStartEnd ready(List<DailyStartEnd> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected DailyStartEndBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(DailyStartEndBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfTimecardDay _foreignTimecardDayLoader;
    public LoaderOfTimecardDay pulloutTimecardDay() {
        if (_foreignTimecardDayLoader == null)
        { _foreignTimecardDayLoader = new LoaderOfTimecardDay().ready(myBhv().pulloutTimecardDay(_selectedList), _selector); }
        return _foreignTimecardDayLoader;
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
    public List<DailyStartEnd> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
