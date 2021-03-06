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
 * The DB meta of MEMBER_ROLE. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class MemberRoleDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final MemberRoleDbm _instance = new MemberRoleDbm();
    private MemberRoleDbm() {}
    public static MemberRoleDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((MemberRole)et).getMemberRoleId(), (et, vl) -> ((MemberRole)et).setMemberRoleId(ctl(vl)), "memberRoleId");
        setupEpg(_epgMap, et -> ((MemberRole)et).getMemberId(), (et, vl) -> ((MemberRole)et).setMemberId(ctl(vl)), "memberId");
        setupEpg(_epgMap, et -> ((MemberRole)et).getRoleTypeCode(), (et, vl) -> ((MemberRole)et).setRoleTypeCode((String)vl), "roleTypeCode");
        setupEpg(_epgMap, et -> ((MemberRole)et).getRegisterDatetime(), (et, vl) -> ((MemberRole)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((MemberRole)et).getRegisterUser(), (et, vl) -> ((MemberRole)et).setRegisterUser((String)vl), "registerUser");
        setupEpg(_epgMap, et -> ((MemberRole)et).getUpdateDatetime(), (et, vl) -> ((MemberRole)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((MemberRole)et).getUpdateUser(), (et, vl) -> ((MemberRole)et).setUpdateUser((String)vl), "updateUser");
        setupEpg(_epgMap, et -> ((MemberRole)et).getVersionNo(), (et, vl) -> ((MemberRole)et).setVersionNo(ctl(vl)), "versionNo");
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
        setupEfpg(_efpgMap, et -> ((MemberRole)et).getMember(), (et, vl) -> ((MemberRole)et).setMember((OptionalEntity<Member>)vl), "member");
        setupEfpg(_efpgMap, et -> ((MemberRole)et).getRole(), (et, vl) -> ((MemberRole)et).setRole((OptionalEntity<Role>)vl), "role");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "MEMBER_ROLE";
    protected final String _tableDispName = "MEMBER_ROLE";
    protected final String _tablePropertyName = "memberRole";
    protected final TableSqlName _tableSqlName = new TableSqlName("MEMBER_ROLE", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnMemberRoleId = cci("MEMBER_ROLE_ID", "MEMBER_ROLE_ID", null, null, Long.class, "memberRoleId", null, true, true, true, "BIGINT", 19, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, null, Long.class, "memberId", null, false, false, true, "BIGINT", 19, 0, null, null, false, null, null, "member", null, null, false);
    protected final ColumnInfo _columnRoleTypeCode = cci("ROLE_TYPE_CODE", "ROLE_TYPE_CODE", null, null, String.class, "roleTypeCode", null, false, false, true, "VARCHAR", 20, 0, null, null, false, null, null, "role", null, null, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, java.time.LocalDateTime.class, "registerDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterUser = cci("REGISTER_USER", "REGISTER_USER", null, null, String.class, "registerUser", null, false, false, true, "VARCHAR", 200, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, java.time.LocalDateTime.class, "updateDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateUser = cci("UPDATE_USER", "UPDATE_USER", null, null, String.class, "updateUser", null, false, false, true, "VARCHAR", 200, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnVersionNo = cci("VERSION_NO", "VERSION_NO", null, null, Long.class, "versionNo", null, false, false, true, "BIGINT", 19, 0, null, null, false, OptimisticLockType.VERSION_NO, null, null, null, null, false);

    /**
     * MEMBER_ROLE_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemberRoleId() { return _columnMemberRoleId; }
    /**
     * MEMBER_ID: {UQ+, NotNull, BIGINT(19), FK to MEMBER}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemberId() { return _columnMemberId; }
    /**
     * ROLE_TYPE_CODE: {+UQ, IX, NotNull, VARCHAR(20), FK to ROLE}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRoleTypeCode() { return _columnRoleTypeCode; }
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
        ls.add(columnMemberRoleId());
        ls.add(columnMemberId());
        ls.add(columnRoleTypeCode());
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
    protected UniqueInfo cpui() { return hpcpui(columnMemberRoleId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // -----------------------------------------------------
    //                                        Unique Element
    //                                        --------------
    public UniqueInfo uniqueOf() {
        List<ColumnInfo> ls = newArrayListSized(4);
        ls.add(columnMemberId());
        ls.add(columnRoleTypeCode());
        return hpcui(ls);
    }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    /**
     * MEMBER by my MEMBER_ID, named 'member'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignMember() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMemberId(), MemberDbm.getInstance().columnMemberId());
        return cfi("FK_MEMBER_ROLE_MEMBER", "member", this, MemberDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "memberRoleList", false);
    }
    /**
     * ROLE by my ROLE_TYPE_CODE, named 'role'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignRole() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnRoleTypeCode(), RoleDbm.getInstance().columnRoleTypeCode());
        return cfi("FK_MEMBER_ROLE_ROLE", "role", this, RoleDbm.getInstance(), mp, 1, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "memberRoleList", false);
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
    public String getEntityTypeName() { return "app.himawari.exentity.MemberRole"; }
    public String getConditionBeanTypeName() { return "app.himawari.cbean.MemberRoleCB"; }
    public String getBehaviorTypeName() { return "app.himawari.exbhv.MemberRoleBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<MemberRole> getEntityType() { return MemberRole.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public MemberRole newEntity() { return new MemberRole(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((MemberRole)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((MemberRole)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
