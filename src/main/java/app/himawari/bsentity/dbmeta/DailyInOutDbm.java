package app.himawari.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.optional.OptionalEntity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import app.himawari.allcommon.*;
import app.himawari.exentity.*;

/**
 * The DB meta of daily_in_out. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class DailyInOutDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final DailyInOutDbm _instance = new DailyInOutDbm();
    private DailyInOutDbm() {}
    public static DailyInOutDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public String getProjectName() { return DBCurrent.getInstance().projectName(); }
    public String getProjectPrefix() { return DBCurrent.getInstance().projectPrefix(); }
    public String getGenerationGapBasePrefix() { return DBCurrent.getInstance().generationGapBasePrefix(); }
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    { xsetupEpg(); }
    protected void xsetupEpg() {
        setupEpg(_epgMap, et -> ((DailyInOut)et).getDailyInOutId(), (et, vl) -> ((DailyInOut)et).setDailyInOutId(ctl(vl)), "dailyInOutId");
        setupEpg(_epgMap, et -> ((DailyInOut)et).getTimecardId(), (et, vl) -> ((DailyInOut)et).setTimecardId(ctl(vl)), "timecardId");
        setupEpg(_epgMap, et -> ((DailyInOut)et).getBizDate(), (et, vl) -> ((DailyInOut)et).setBizDate(ctld(vl)), "bizDate");
        setupEpg(_epgMap, et -> ((DailyInOut)et).getStartDatetime(), (et, vl) -> ((DailyInOut)et).setStartDatetime(ctldt(vl)), "startDatetime");
        setupEpg(_epgMap, et -> ((DailyInOut)et).getFinishDatetime(), (et, vl) -> ((DailyInOut)et).setFinishDatetime(ctldt(vl)), "finishDatetime");
        setupEpg(_epgMap, et -> ((DailyInOut)et).getAmendedStartTime(), (et, vl) -> ((DailyInOut)et).setAmendedStartTime(ctldt(vl)), "amendedStartTime");
        setupEpg(_epgMap, et -> ((DailyInOut)et).getAmendedFinishTime(), (et, vl) -> ((DailyInOut)et).setAmendedFinishTime(ctldt(vl)), "amendedFinishTime");
        setupEpg(_epgMap, et -> ((DailyInOut)et).getVacationTypeCode(), (et, vl) -> ((DailyInOut)et).setVacationTypeCode((String)vl), "vacationTypeCode");
        setupEpg(_epgMap, et -> ((DailyInOut)et).getNote(), (et, vl) -> ((DailyInOut)et).setNote((String)vl), "note");
        setupEpg(_epgMap, et -> ((DailyInOut)et).getRegisterDatetime(), (et, vl) -> ((DailyInOut)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((DailyInOut)et).getRegisterUser(), (et, vl) -> ((DailyInOut)et).setRegisterUser((String)vl), "registerUser");
        setupEpg(_epgMap, et -> ((DailyInOut)et).getUpdateDatetime(), (et, vl) -> ((DailyInOut)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((DailyInOut)et).getUpdateUser(), (et, vl) -> ((DailyInOut)et).setUpdateUser((String)vl), "updateUser");
        setupEpg(_epgMap, et -> ((DailyInOut)et).getVersionNo(), (et, vl) -> ((DailyInOut)et).setVersionNo(ctl(vl)), "versionNo");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    protected final Map<String, PropertyGateway> _efpgMap = newHashMap();
    { xsetupEfpg(); }
    @SuppressWarnings("unchecked")
    protected void xsetupEfpg() {
        setupEfpg(_efpgMap, et -> ((DailyInOut)et).getTimecard(), (et, vl) -> ((DailyInOut)et).setTimecard((OptionalEntity<Timecard>)vl), "timecard");
        setupEfpg(_efpgMap, et -> ((DailyInOut)et).getVacationType(), (et, vl) -> ((DailyInOut)et).setVacationType((OptionalEntity<VacationType>)vl), "vacationType");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "daily_in_out";
    protected final String _tableDispName = "DAILY_IN_OUT";
    protected final String _tablePropertyName = "dailyInOut";
    protected final TableSqlName _tableSqlName = new TableSqlName("DAILY_IN_OUT", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnDailyInOutId = cci("DAILY_IN_OUT_ID", "DAILY_IN_OUT_ID", null, null, Long.class, "dailyInOutId", null, true, true, true, "BIGINT", 19, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnTimecardId = cci("TIMECARD_ID", "TIMECARD_ID", null, null, Long.class, "timecardId", null, false, false, true, "BIGINT", 19, 0, null, false, null, null, "timecard", null, null, false);
    protected final ColumnInfo _columnBizDate = cci("BIZ_DATE", "BIZ_DATE", null, null, java.time.LocalDate.class, "bizDate", null, false, false, true, "DATE", 10, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnStartDatetime = cci("START_DATETIME", "START_DATETIME", null, null, java.time.LocalDateTime.class, "startDatetime", null, false, false, false, "DATETIME", 19, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnFinishDatetime = cci("FINISH_DATETIME", "FINISH_DATETIME", null, null, java.time.LocalDateTime.class, "finishDatetime", null, false, false, false, "DATETIME", 19, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnAmendedStartTime = cci("AMENDED_START_TIME", "AMENDED_START_TIME", null, null, java.time.LocalDateTime.class, "amendedStartTime", null, false, false, false, "DATETIME", 19, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnAmendedFinishTime = cci("AMENDED_FINISH_TIME", "AMENDED_FINISH_TIME", null, null, java.time.LocalDateTime.class, "amendedFinishTime", null, false, false, false, "DATETIME", 19, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnVacationTypeCode = cci("VACATION_TYPE_CODE", "VACATION_TYPE_CODE", null, null, String.class, "vacationTypeCode", null, false, false, false, "VARCHAR", 3, 0, null, false, null, null, "vacationType", null, null, false);
    protected final ColumnInfo _columnNote = cci("NOTE", "NOTE", null, null, String.class, "note", null, false, false, false, "TEXT", 65535, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, java.time.LocalDateTime.class, "registerDatetime", null, false, false, true, "DATETIME", 19, 0, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterUser = cci("REGISTER_USER", "REGISTER_USER", null, null, String.class, "registerUser", null, false, false, true, "VARCHAR", 200, 0, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, java.time.LocalDateTime.class, "updateDatetime", null, false, false, true, "DATETIME", 19, 0, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateUser = cci("UPDATE_USER", "UPDATE_USER", null, null, String.class, "updateUser", null, false, false, true, "VARCHAR", 200, 0, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnVersionNo = cci("VERSION_NO", "VERSION_NO", null, null, Long.class, "versionNo", null, false, false, true, "BIGINT", 19, 0, null, false, OptimisticLockType.VERSION_NO, null, null, null, null, false);

    /**
     * DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDailyInOutId() { return _columnDailyInOutId; }
    /**
     * TIMECARD_ID: {IX, NotNull, BIGINT(19), FK to timecard}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnTimecardId() { return _columnTimecardId; }
    /**
     * BIZ_DATE: {NotNull, DATE(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnBizDate() { return _columnBizDate; }
    /**
     * START_DATETIME: {DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnStartDatetime() { return _columnStartDatetime; }
    /**
     * FINISH_DATETIME: {DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnFinishDatetime() { return _columnFinishDatetime; }
    /**
     * AMENDED_START_TIME: {DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAmendedStartTime() { return _columnAmendedStartTime; }
    /**
     * AMENDED_FINISH_TIME: {DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAmendedFinishTime() { return _columnAmendedFinishTime; }
    /**
     * VACATION_TYPE_CODE: {IX, VARCHAR(3), FK to vacation_type}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVacationTypeCode() { return _columnVacationTypeCode; }
    /**
     * NOTE: {TEXT(65535)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnNote() { return _columnNote; }
    /**
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRegisterDatetime() { return _columnRegisterDatetime; }
    /**
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRegisterUser() { return _columnRegisterUser; }
    /**
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdateDatetime() { return _columnUpdateDatetime; }
    /**
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdateUser() { return _columnUpdateUser; }
    /**
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVersionNo() { return _columnVersionNo; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnDailyInOutId());
        ls.add(columnTimecardId());
        ls.add(columnBizDate());
        ls.add(columnStartDatetime());
        ls.add(columnFinishDatetime());
        ls.add(columnAmendedStartTime());
        ls.add(columnAmendedFinishTime());
        ls.add(columnVacationTypeCode());
        ls.add(columnNote());
        ls.add(columnRegisterDatetime());
        ls.add(columnRegisterUser());
        ls.add(columnUpdateDatetime());
        ls.add(columnUpdateUser());
        ls.add(columnVersionNo());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnDailyInOutId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    /**
     * TIMECARD by my TIMECARD_ID, named 'timecard'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignTimecard() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnTimecardId(), TimecardDbm.getInstance().columnTimecardId());
        return cfi("FK_DAILY_IN_OUT_TIMECARD", "timecard", this, TimecardDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "dailyInOutList", false);
    }
    /**
     * VACATION_TYPE by my VACATION_TYPE_CODE, named 'vacationType'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignVacationType() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVacationTypeCode(), VacationTypeDbm.getInstance().columnVacationTypeCode());
        return cfi("FK_DAILY_IN_OUT_VACATION_TYPE", "vacationType", this, VacationTypeDbm.getInstance(), mp, 1, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "dailyInOutList", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasIdentity() { return true; }
    public boolean hasVersionNo() { return true; }
    public ColumnInfo getVersionNoColumnInfo() { return _columnVersionNo; }
    public boolean hasCommonColumn() { return true; }
    public List<ColumnInfo> getCommonColumnInfoList()
    { return newArrayList(columnRegisterDatetime(), columnRegisterUser(), columnUpdateDatetime(), columnUpdateUser()); }
    public List<ColumnInfo> getCommonColumnInfoBeforeInsertList()
    { return newArrayList(columnRegisterDatetime(), columnRegisterUser(), columnUpdateDatetime(), columnUpdateUser()); }
    public List<ColumnInfo> getCommonColumnInfoBeforeUpdateList()
    { return newArrayList(columnUpdateDatetime(), columnUpdateUser()); }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "app.himawari.exentity.DailyInOut"; }
    public String getConditionBeanTypeName() { return "app.himawari.cbean.DailyInOutCB"; }
    public String getBehaviorTypeName() { return "app.himawari.exbhv.DailyInOutBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<DailyInOut> getEntityType() { return DailyInOut.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public DailyInOut newEntity() { return new DailyInOut(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((DailyInOut)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((DailyInOut)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
