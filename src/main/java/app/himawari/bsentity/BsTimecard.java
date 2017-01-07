package app.himawari.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.Entity;
import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import org.dbflute.optional.OptionalEntity;
import app.himawari.allcommon.DBMetaInstanceHandler;
import app.himawari.exentity.*;

/**
 * The entity of timecard as TABLE. <br>
 * ??????
 * <pre>
 * [primary-key]
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
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long timecardId = entity.getTimecardId();
 * Long memberId = entity.getMemberId();
 * String timecardYearMonth = entity.getTimecardYearMonth();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerUser = entity.getRegisterUser();
 * String registerProcess = entity.getRegisterProcess();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateUser = entity.getUpdateUser();
 * String updateProcess = entity.getUpdateProcess();
 * Long versionNo = entity.getVersionNo();
 * entity.setTimecardId(timecardId);
 * entity.setMemberId(memberId);
 * entity.setTimecardYearMonth(timecardYearMonth);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterUser(registerUser);
 * entity.setRegisterProcess(registerProcess);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateUser(updateUser);
 * entity.setUpdateProcess(updateProcess);
 * entity.setVersionNo(versionNo);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsTimecard extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** TIMECARD_ID: {PK, ID, NotNull, BIGINT(19)} */
    protected Long _timecardId;

    /** MEMBER_ID: {UQ, NotNull, BIGINT(19), FK to member} */
    protected Long _memberId;

    /** TIMECARD_YEAR_MONTH: {UQ, NotNull, VARCHAR(6)} */
    protected String _timecardYearMonth;

    /** REGISTER_DATETIME: {NotNull, DATETIME(19)} */
    protected java.time.LocalDateTime _registerDatetime;

    /** REGISTER_USER: {NotNull, VARCHAR(200)} */
    protected String _registerUser;

    /** REGISTER_PROCESS: {NotNull, VARCHAR(200)} */
    protected String _registerProcess;

    /** UPDATE_DATETIME: {NotNull, DATETIME(19)} */
    protected java.time.LocalDateTime _updateDatetime;

    /** UPDATE_USER: {NotNull, VARCHAR(200)} */
    protected String _updateUser;

    /** UPDATE_PROCESS: {NotNull, VARCHAR(200)} */
    protected String _updateProcess;

    /** VERSION_NO: {NotNull, BIGINT(19)} */
    protected Long _versionNo;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "timecard";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_timecardId == null) { return false; }
        return true;
    }

    /**
     * To be unique by the unique column. <br>
     * You can update the entity by the key when entity update (NOT batch update).
     * @param memberId : UQ, NotNull, BIGINT(19), FK to member. (NotNull)
     */
    public void uniqueByMemberId(Long memberId) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("memberId");
        setMemberId(memberId);
    }

    /**
     * To be unique by the unique column. <br>
     * You can update the entity by the key when entity update (NOT batch update).
     * @param timecardYearMonth : UQ, NotNull, VARCHAR(6). (NotNull)
     */
    public void uniqueByTimecardYearMonth(String timecardYearMonth) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("timecardYearMonth");
        setTimecardYearMonth(timecardYearMonth);
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** member by my MEMBER_ID, named 'member'. */
    protected OptionalEntity<Member> _member;

    /**
     * [get] member by my MEMBER_ID, named 'member'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'member'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Member> getMember() {
        if (_member == null) { _member = OptionalEntity.relationEmpty(this, "member"); }
        return _member;
    }

    /**
     * [set] member by my MEMBER_ID, named 'member'.
     * @param member The entity of foreign property 'member'. (NullAllowed)
     */
    public void setMember(OptionalEntity<Member> member) {
        _member = member;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** daily_in_out by TIMECARD_ID, named 'dailyInOutList'. */
    protected List<DailyInOut> _dailyInOutList;

    /**
     * [get] daily_in_out by TIMECARD_ID, named 'dailyInOutList'.
     * @return The entity list of referrer property 'dailyInOutList'. (NotNull: even if no loading, returns empty list)
     */
    public List<DailyInOut> getDailyInOutList() {
        if (_dailyInOutList == null) { _dailyInOutList = newReferrerList(); }
        return _dailyInOutList;
    }

    /**
     * [set] daily_in_out by TIMECARD_ID, named 'dailyInOutList'.
     * @param dailyInOutList The entity list of referrer property 'dailyInOutList'. (NullAllowed)
     */
    public void setDailyInOutList(List<DailyInOut> dailyInOutList) {
        _dailyInOutList = dailyInOutList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsTimecard) {
            BsTimecard other = (BsTimecard)obj;
            if (!xSV(_timecardId, other._timecardId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _timecardId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_member != null && _member.isPresent())
        { sb.append(li).append(xbRDS(_member, "member")); }
        if (_dailyInOutList != null) { for (DailyInOut et : _dailyInOutList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "dailyInOutList")); } } }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_timecardId));
        sb.append(dm).append(xfND(_memberId));
        sb.append(dm).append(xfND(_timecardYearMonth));
        sb.append(dm).append(xfND(_registerDatetime));
        sb.append(dm).append(xfND(_registerUser));
        sb.append(dm).append(xfND(_registerProcess));
        sb.append(dm).append(xfND(_updateDatetime));
        sb.append(dm).append(xfND(_updateUser));
        sb.append(dm).append(xfND(_updateProcess));
        sb.append(dm).append(xfND(_versionNo));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_member != null && _member.isPresent())
        { sb.append(dm).append("member"); }
        if (_dailyInOutList != null && !_dailyInOutList.isEmpty())
        { sb.append(dm).append("dailyInOutList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Timecard clone() {
        return (Timecard)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] TIMECARD_ID: {PK, ID, NotNull, BIGINT(19)} <br>
     * TIMECARD_ID
     * @return The value of the column 'TIMECARD_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getTimecardId() {
        checkSpecifiedProperty("timecardId");
        return _timecardId;
    }

    /**
     * [set] TIMECARD_ID: {PK, ID, NotNull, BIGINT(19)} <br>
     * TIMECARD_ID
     * @param timecardId The value of the column 'TIMECARD_ID'. (basically NotNull if update: for the constraint)
     */
    public void setTimecardId(Long timecardId) {
        registerModifiedProperty("timecardId");
        _timecardId = timecardId;
    }

    /**
     * [get] MEMBER_ID: {UQ, NotNull, BIGINT(19), FK to member} <br>
     * ????ID
     * @return The value of the column 'MEMBER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getMemberId() {
        checkSpecifiedProperty("memberId");
        return _memberId;
    }

    /**
     * [set] MEMBER_ID: {UQ, NotNull, BIGINT(19), FK to member} <br>
     * ????ID
     * @param memberId The value of the column 'MEMBER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setMemberId(Long memberId) {
        registerModifiedProperty("memberId");
        _memberId = memberId;
    }

    /**
     * [get] TIMECARD_YEAR_MONTH: {UQ, NotNull, VARCHAR(6)} <br>
     * ?? : YYYYMM
     * @return The value of the column 'TIMECARD_YEAR_MONTH'. (basically NotNull if selected: for the constraint)
     */
    public String getTimecardYearMonth() {
        checkSpecifiedProperty("timecardYearMonth");
        return _timecardYearMonth;
    }

    /**
     * [set] TIMECARD_YEAR_MONTH: {UQ, NotNull, VARCHAR(6)} <br>
     * ?? : YYYYMM
     * @param timecardYearMonth The value of the column 'TIMECARD_YEAR_MONTH'. (basically NotNull if update: for the constraint)
     */
    public void setTimecardYearMonth(String timecardYearMonth) {
        registerModifiedProperty("timecardYearMonth");
        _timecardYearMonth = timecardYearMonth;
    }

    /**
     * [get] REGISTER_DATETIME: {NotNull, DATETIME(19)} <br>
     * ????
     * @return The value of the column 'REGISTER_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDateTime getRegisterDatetime() {
        checkSpecifiedProperty("registerDatetime");
        return _registerDatetime;
    }

    /**
     * [set] REGISTER_DATETIME: {NotNull, DATETIME(19)} <br>
     * ????
     * @param registerDatetime The value of the column 'REGISTER_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterDatetime(java.time.LocalDateTime registerDatetime) {
        registerModifiedProperty("registerDatetime");
        _registerDatetime = registerDatetime;
    }

    /**
     * [get] REGISTER_USER: {NotNull, VARCHAR(200)} <br>
     * ?????
     * @return The value of the column 'REGISTER_USER'. (basically NotNull if selected: for the constraint)
     */
    public String getRegisterUser() {
        checkSpecifiedProperty("registerUser");
        return _registerUser;
    }

    /**
     * [set] REGISTER_USER: {NotNull, VARCHAR(200)} <br>
     * ?????
     * @param registerUser The value of the column 'REGISTER_USER'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterUser(String registerUser) {
        registerModifiedProperty("registerUser");
        _registerUser = registerUser;
    }

    /**
     * [get] REGISTER_PROCESS: {NotNull, VARCHAR(200)} <br>
     * ??????
     * @return The value of the column 'REGISTER_PROCESS'. (basically NotNull if selected: for the constraint)
     */
    public String getRegisterProcess() {
        checkSpecifiedProperty("registerProcess");
        return _registerProcess;
    }

    /**
     * [set] REGISTER_PROCESS: {NotNull, VARCHAR(200)} <br>
     * ??????
     * @param registerProcess The value of the column 'REGISTER_PROCESS'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterProcess(String registerProcess) {
        registerModifiedProperty("registerProcess");
        _registerProcess = registerProcess;
    }

    /**
     * [get] UPDATE_DATETIME: {NotNull, DATETIME(19)} <br>
     * ????
     * @return The value of the column 'UPDATE_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDateTime getUpdateDatetime() {
        checkSpecifiedProperty("updateDatetime");
        return _updateDatetime;
    }

    /**
     * [set] UPDATE_DATETIME: {NotNull, DATETIME(19)} <br>
     * ????
     * @param updateDatetime The value of the column 'UPDATE_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateDatetime(java.time.LocalDateTime updateDatetime) {
        registerModifiedProperty("updateDatetime");
        _updateDatetime = updateDatetime;
    }

    /**
     * [get] UPDATE_USER: {NotNull, VARCHAR(200)} <br>
     * ?????
     * @return The value of the column 'UPDATE_USER'. (basically NotNull if selected: for the constraint)
     */
    public String getUpdateUser() {
        checkSpecifiedProperty("updateUser");
        return _updateUser;
    }

    /**
     * [set] UPDATE_USER: {NotNull, VARCHAR(200)} <br>
     * ?????
     * @param updateUser The value of the column 'UPDATE_USER'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateUser(String updateUser) {
        registerModifiedProperty("updateUser");
        _updateUser = updateUser;
    }

    /**
     * [get] UPDATE_PROCESS: {NotNull, VARCHAR(200)} <br>
     * ??????
     * @return The value of the column 'UPDATE_PROCESS'. (basically NotNull if selected: for the constraint)
     */
    public String getUpdateProcess() {
        checkSpecifiedProperty("updateProcess");
        return _updateProcess;
    }

    /**
     * [set] UPDATE_PROCESS: {NotNull, VARCHAR(200)} <br>
     * ??????
     * @param updateProcess The value of the column 'UPDATE_PROCESS'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateProcess(String updateProcess) {
        registerModifiedProperty("updateProcess");
        _updateProcess = updateProcess;
    }

    /**
     * [get] VERSION_NO: {NotNull, BIGINT(19)} <br>
     * ???????
     * @return The value of the column 'VERSION_NO'. (basically NotNull if selected: for the constraint)
     */
    public Long getVersionNo() {
        checkSpecifiedProperty("versionNo");
        return _versionNo;
    }

    /**
     * [set] VERSION_NO: {NotNull, BIGINT(19)} <br>
     * ???????
     * @param versionNo The value of the column 'VERSION_NO'. (basically NotNull if update: for the constraint)
     */
    public void setVersionNo(Long versionNo) {
        registerModifiedProperty("versionNo");
        _versionNo = versionNo;
    }
}
