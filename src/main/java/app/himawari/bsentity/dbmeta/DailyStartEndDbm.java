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
 * The DB meta of DAILY_START_END. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class DailyStartEndDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final DailyStartEndDbm _instance = new DailyStartEndDbm();
    private DailyStartEndDbm() {}
    public static DailyStartEndDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((DailyStartEnd)et).getDailyStartEndId(), (et, vl) -> ((DailyStartEnd)et).setDailyStartEndId(ctl(vl)), "dailyStartEndId");
        setupEpg(_epgMap, et -> ((DailyStartEnd)et).getTimecardId(), (et, vl) -> ((DailyStartEnd)et).setTimecardId(ctl(vl)), "timecardId");
        setupEpg(_epgMap, et -> ((DailyStartEnd)et).getBizDate(), (et, vl) -> ((DailyStartEnd)et).setBizDate(ctld(vl)), "bizDate");
        setupEpg(_epgMap, et -> ((DailyStartEnd)et).getStartDatetime(), (et, vl) -> ((DailyStartEnd)et).setStartDatetime(ctldt(vl)), "startDatetime");
        setupEpg(_epgMap, et -> ((DailyStartEnd)et).getEndDatetime(), (et, vl) -> ((DailyStartEnd)et).setEndDatetime(ctldt(vl)), "endDatetime");
        setupEpg(_epgMap, et -> ((DailyStartEnd)et).getScaleFittedStartTime(), (et, vl) -> ((DailyStartEnd)et).setScaleFittedStartTime(ctldt(vl)), "scaleFittedStartTime");
        setupEpg(_epgMap, et -> ((DailyStartEnd)et).getScaleFittedEndTime(), (et, vl) -> ((DailyStartEnd)et).setScaleFittedEndTime(ctldt(vl)), "scaleFittedEndTime");
        setupEpg(_epgMap, et -> ((DailyStartEnd)et).getVacationTypeCode(), (et, vl) -> ((DailyStartEnd)et).setVacationTypeCode((String)vl), "vacationTypeCode");
        setupEpg(_epgMap, et -> ((DailyStartEnd)et).getNote(), (et, vl) -> ((DailyStartEnd)et).setNote((String)vl), "note");
        setupEpg(_epgMap, et -> ((DailyStartEnd)et).getRegisterDatetime(), (et, vl) -> ((DailyStartEnd)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((DailyStartEnd)et).getRegisterUser(), (et, vl) -> ((DailyStartEnd)et).setRegisterUser((String)vl), "registerUser");
        setupEpg(_epgMap, et -> ((DailyStartEnd)et).getUpdateDatetime(), (et, vl) -> ((DailyStartEnd)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((DailyStartEnd)et).getUpdateUser(), (et, vl) -> ((DailyStartEnd)et).setUpdateUser((String)vl), "updateUser");
        setupEpg(_epgMap, et -> ((DailyStartEnd)et).getVersionNo(), (et, vl) -> ((DailyStartEnd)et).setVersionNo(ctl(vl)), "versionNo");
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
        setupEfpg(_efpgMap, et -> ((DailyStartEnd)et).getTimecard(), (et, vl) -> ((DailyStartEnd)et).setTimecard((OptionalEntity<Timecard>)vl), "timecard");
        setupEfpg(_efpgMap, et -> ((DailyStartEnd)et).getVacationType(), (et, vl) -> ((DailyStartEnd)et).setVacationType((OptionalEntity<VacationType>)vl), "vacationType");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "DAILY_START_END";
    protected final String _tableDispName = "DAILY_START_END";
    protected final String _tablePropertyName = "dailyStartEnd";
    protected final TableSqlName _tableSqlName = new TableSqlName("DAILY_START_END", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnDailyStartEndId = cci("DAILY_START_END_ID", "DAILY_START_END_ID", null, null, Long.class, "dailyStartEndId", null, true, true, true, "BIGINT", 19, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnTimecardId = cci("TIMECARD_ID", "TIMECARD_ID", null, null, Long.class, "timecardId", null, false, false, true, "BIGINT", 19, 0, null, false, null, null, "timecard", null, null, false);
    protected final ColumnInfo _columnBizDate = cci("BIZ_DATE", "BIZ_DATE", null, null, java.time.LocalDate.class, "bizDate", null, false, false, true, "DATE", 10, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnStartDatetime = cci("START_DATETIME", "START_DATETIME", null, null, java.time.LocalDateTime.class, "startDatetime", null, false, false, false, "DATETIME", 19, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnEndDatetime = cci("END_DATETIME", "END_DATETIME", null, null, java.time.LocalDateTime.class, "endDatetime", null, false, false, false, "DATETIME", 19, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnScaleFittedStartTime = cci("SCALE_FITTED_START_TIME", "SCALE_FITTED_START_TIME", null, null, java.time.LocalDateTime.class, "scaleFittedStartTime", null, false, false, false, "DATETIME", 19, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnScaleFittedEndTime = cci("SCALE_FITTED_END_TIME", "SCALE_FITTED_END_TIME", null, null, java.time.LocalDateTime.class, "scaleFittedEndTime", null, false, false, false, "DATETIME", 19, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnVacationTypeCode = cci("VACATION_TYPE_CODE", "VACATION_TYPE_CODE", null, null, String.class, "vacationTypeCode", null, false, false, false, "VARCHAR", 3, 0, null, false, null, null, "vacationType", null, null, false);
    protected final ColumnInfo _columnNote = cci("NOTE", "NOTE", null, null, String.class, "note", null, false, false, false, "TEXT", 65535, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, java.time.LocalDateTime.class, "registerDatetime", null, false, false, true, "DATETIME", 19, 0, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterUser = cci("REGISTER_USER", "REGISTER_USER", null, null, String.class, "registerUser", null, false, false, true, "VARCHAR", 200, 0, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, java.time.LocalDateTime.class, "updateDatetime", null, false, false, true, "DATETIME", 19, 0, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateUser = cci("UPDATE_USER", "UPDATE_USER", null, null, String.class, "updateUser", null, false, false, true, "VARCHAR", 200, 0, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnVersionNo = cci("VERSION_NO", "VERSION_NO", null, null, Long.class, "versionNo", null, false, false, true, "BIGINT", 19, 0, null, false, OptimisticLockType.VERSION_NO, null, null, null, null, false);

    /**
     * DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDailyStartEndId() { return _columnDailyStartEndId; }
    /**
     * TIMECARD_ID: {IX, NotNull, BIGINT(19), FK to TIMECARD}
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
     * END_DATETIME: {DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnEndDatetime() { return _columnEndDatetime; }
    /**
     * SCALE_FITTED_START_TIME: {DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnScaleFittedStartTime() { return _columnScaleFittedStartTime; }
    /**
     * SCALE_FITTED_END_TIME: {DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnScaleFittedEndTime() { return _columnScaleFittedEndTime; }
    /**
     * VACATION_TYPE_CODE: {IX, VARCHAR(3), FK to VACATION_TYPE}
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
        ls.add(columnDailyStartEndId());
        ls.add(columnTimecardId());
        ls.add(columnBizDate());
        ls.add(columnStartDatetime());
        ls.add(columnEndDatetime());
        ls.add(columnScaleFittedStartTime());
        ls.add(columnScaleFittedEndTime());
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
    protected UniqueInfo cpui() { return hpcpui(columnDailyStartEndId()); }
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
        return cfi("FK_DAILY_IN_OUT_TIMECARD", "timecard", this, TimecardDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "dailyStartEndList", false);
    }
    /**
     * VACATION_TYPE by my VACATION_TYPE_CODE, named 'vacationType'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignVacationType() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVacationTypeCode(), VacationTypeDbm.getInstance().columnVacationTypeCode());
        return cfi("FK_DAILY_IN_OUT_VACATION_TYPE", "vacationType", this, VacationTypeDbm.getInstance(), mp, 1, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "dailyStartEndList", false);
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
    public String getEntityTypeName() { return "app.himawari.exentity.DailyStartEnd"; }
    public String getConditionBeanTypeName() { return "app.himawari.cbean.DailyStartEndCB"; }
    public String getBehaviorTypeName() { return "app.himawari.exbhv.DailyStartEndBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<DailyStartEnd> getEntityType() { return DailyStartEnd.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public DailyStartEnd newEntity() { return new DailyStartEnd(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((DailyStartEnd)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((DailyStartEnd)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
