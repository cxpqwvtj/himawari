package app.himawari.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import app.himawari.allcommon.*;
import app.himawari.exentity.*;

/**
 * The DB meta of vacation_type. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class VacationTypeDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final VacationTypeDbm _instance = new VacationTypeDbm();
    private VacationTypeDbm() {}
    public static VacationTypeDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((VacationType)et).getVacationTypeCode(), (et, vl) -> ((VacationType)et).setVacationTypeCode((String)vl), "vacationTypeCode");
        setupEpg(_epgMap, et -> ((VacationType)et).getVacationTypeName(), (et, vl) -> ((VacationType)et).setVacationTypeName((String)vl), "vacationTypeName");
        setupEpg(_epgMap, et -> ((VacationType)et).getRegisterDatetime(), (et, vl) -> ((VacationType)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((VacationType)et).getRegisterUser(), (et, vl) -> ((VacationType)et).setRegisterUser((String)vl), "registerUser");
        setupEpg(_epgMap, et -> ((VacationType)et).getUpdateDatetime(), (et, vl) -> ((VacationType)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((VacationType)et).getUpdateUser(), (et, vl) -> ((VacationType)et).setUpdateUser((String)vl), "updateUser");
        setupEpg(_epgMap, et -> ((VacationType)et).getVersionNo(), (et, vl) -> ((VacationType)et).setVersionNo(ctl(vl)), "versionNo");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "vacation_type";
    protected final String _tableDispName = "vacation_type";
    protected final String _tablePropertyName = "vacationType";
    protected final TableSqlName _tableSqlName = new TableSqlName("vacation_type", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnVacationTypeCode = cci("VACATION_TYPE_CODE", "VACATION_TYPE_CODE", null, null, String.class, "vacationTypeCode", null, true, false, true, "VARCHAR", 3, 0, null, false, null, null, null, "dailyInOutList", null, false);
    protected final ColumnInfo _columnVacationTypeName = cci("VACATION_TYPE_NAME", "VACATION_TYPE_NAME", null, null, String.class, "vacationTypeName", null, false, false, true, "VARCHAR", 200, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, java.time.LocalDateTime.class, "registerDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterUser = cci("REGISTER_USER", "REGISTER_USER", null, null, String.class, "registerUser", null, false, false, true, "VARCHAR", 200, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, java.time.LocalDateTime.class, "updateDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateUser = cci("UPDATE_USER", "UPDATE_USER", null, null, String.class, "updateUser", null, false, false, true, "VARCHAR", 200, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnVersionNo = cci("VERSION_NO", "VERSION_NO", null, null, Long.class, "versionNo", null, false, false, true, "BIGINT", 19, 0, null, false, OptimisticLockType.VERSION_NO, null, null, null, null, false);

    /**
     * VACATION_TYPE_CODE: {PK, NotNull, VARCHAR(3)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVacationTypeCode() { return _columnVacationTypeCode; }
    /**
     * VACATION_TYPE_NAME: {NotNull, VARCHAR(200)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVacationTypeName() { return _columnVacationTypeName; }
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
        ls.add(columnVacationTypeCode());
        ls.add(columnVacationTypeName());
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
    protected UniqueInfo cpui() { return hpcpui(columnVacationTypeCode()); }
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

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------
    /**
     * daily_in_out by VACATION_TYPE_CODE, named 'dailyInOutList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerDailyInOutList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVacationTypeCode(), DailyInOutDbm.getInstance().columnVacationTypeCode());
        return cri("FK_DAILY_IN_OUT_VACATION_TYPE", "dailyInOutList", this, DailyInOutDbm.getInstance(), mp, false, "vacationType");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasVersionNo() { return true; }
    public ColumnInfo getVersionNoColumnInfo() { return _columnVersionNo; }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "app.himawari.exentity.VacationType"; }
    public String getConditionBeanTypeName() { return "app.himawari.cbean.VacationTypeCB"; }
    public String getBehaviorTypeName() { return "app.himawari.exbhv.VacationTypeBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<VacationType> getEntityType() { return VacationType.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public VacationType newEntity() { return new VacationType(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((VacationType)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((VacationType)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
