package app.himawari.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.Entity;
import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import org.dbflute.optional.OptionalEntity;
import app.himawari.allcommon.EntityDefinedCommonColumn;
import app.himawari.allcommon.DBMetaInstanceHandler;
import app.himawari.exentity.*;

/**
 * The entity of TIMECARD_DAY as TABLE. <br>
 * タイムカード年月日
 * <pre>
 * [primary-key]
 *     TIMECARD_DAY_ID
 *
 * [column]
 *     TIMECARD_DAY_ID, MEMBER_ID, BIZ_DATE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 *
 * [sequence]
 *     
 *
 * [identity]
 *     TIMECARD_DAY_ID
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *     MEMBER, DAILY_START_END(AsCurrentValue)
 *
 * [referrer table]
 *     DAILY_START_END
 *
 * [foreign property]
 *     member, dailyStartEndAsCurrentValue
 *
 * [referrer property]
 *     dailyStartEndList
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long timecardDayId = entity.getTimecardDayId();
 * Long memberId = entity.getMemberId();
 * java.time.LocalDate bizDate = entity.getBizDate();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerUser = entity.getRegisterUser();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateUser = entity.getUpdateUser();
 * Long versionNo = entity.getVersionNo();
 * entity.setTimecardDayId(timecardDayId);
 * entity.setMemberId(memberId);
 * entity.setBizDate(bizDate);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterUser(registerUser);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateUser(updateUser);
 * entity.setVersionNo(versionNo);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsTimecardDay extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** TIMECARD_DAY_ID: {PK, ID, NotNull, BIGINT(19), FK to DAILY_START_END} */
    protected Long _timecardDayId;

    /** MEMBER_ID: {UQ+, NotNull, BIGINT(19), FK to MEMBER} */
    protected Long _memberId;

    /** BIZ_DATE: {+UQ, NotNull, DATE(10)} */
    protected java.time.LocalDate _bizDate;

    /** REGISTER_DATETIME: {NotNull, DATETIME(19)} */
    protected java.time.LocalDateTime _registerDatetime;

    /** REGISTER_USER: {NotNull, VARCHAR(200)} */
    protected String _registerUser;

    /** UPDATE_DATETIME: {NotNull, DATETIME(19)} */
    protected java.time.LocalDateTime _updateDatetime;

    /** UPDATE_USER: {NotNull, VARCHAR(200)} */
    protected String _updateUser;

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
        return "TIMECARD_DAY";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_timecardDayId == null) { return false; }
        return true;
    }

    /**
     * To be unique by the unique column. <br>
     * You can update the entity by the key when entity update (NOT batch update).
     * @param memberId : UQ+, NotNull, BIGINT(19), FK to MEMBER. (NotNull)
     * @param bizDate : +UQ, NotNull, DATE(10). (NotNull)
     */
    public void uniqueBy(Long memberId, java.time.LocalDate bizDate) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("memberId");
        __uniqueDrivenProperties.addPropertyName("bizDate");
        setMemberId(memberId);setBizDate(bizDate);
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** MEMBER by my MEMBER_ID, named 'member'. */
    protected OptionalEntity<Member> _member;

    /**
     * [get] MEMBER by my MEMBER_ID, named 'member'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'member'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Member> getMember() {
        if (_member == null) { _member = OptionalEntity.relationEmpty(this, "member"); }
        return _member;
    }

    /**
     * [set] MEMBER by my MEMBER_ID, named 'member'.
     * @param member The entity of foreign property 'member'. (NullAllowed)
     */
    public void setMember(OptionalEntity<Member> member) {
        _member = member;
    }

    /** DAILY_START_END by my TIMECARD_DAY_ID, named 'dailyStartEndAsCurrentValue'. */
    protected OptionalEntity<DailyStartEnd> _dailyStartEndAsCurrentValue;

    /**
     * [get] DAILY_START_END by my TIMECARD_DAY_ID, named 'dailyStartEndAsCurrentValue'. <br>
     * "最新の履歴を取得します" <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'dailyStartEndAsCurrentValue'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<DailyStartEnd> getDailyStartEndAsCurrentValue() {
        if (_dailyStartEndAsCurrentValue == null) { _dailyStartEndAsCurrentValue = OptionalEntity.relationEmpty(this, "dailyStartEndAsCurrentValue"); }
        return _dailyStartEndAsCurrentValue;
    }

    /**
     * [set] DAILY_START_END by my TIMECARD_DAY_ID, named 'dailyStartEndAsCurrentValue'. <br>
     * "最新の履歴を取得します"
     * @param dailyStartEndAsCurrentValue The entity of foreign property 'dailyStartEndAsCurrentValue'. (NullAllowed)
     */
    public void setDailyStartEndAsCurrentValue(OptionalEntity<DailyStartEnd> dailyStartEndAsCurrentValue) {
        _dailyStartEndAsCurrentValue = dailyStartEndAsCurrentValue;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** DAILY_START_END by TIMECARD_DAY_ID, named 'dailyStartEndList'. */
    protected List<DailyStartEnd> _dailyStartEndList;

    /**
     * [get] DAILY_START_END by TIMECARD_DAY_ID, named 'dailyStartEndList'.
     * @return The entity list of referrer property 'dailyStartEndList'. (NotNull: even if no loading, returns empty list)
     */
    public List<DailyStartEnd> getDailyStartEndList() {
        if (_dailyStartEndList == null) { _dailyStartEndList = newReferrerList(); }
        return _dailyStartEndList;
    }

    /**
     * [set] DAILY_START_END by TIMECARD_DAY_ID, named 'dailyStartEndList'.
     * @param dailyStartEndList The entity list of referrer property 'dailyStartEndList'. (NullAllowed)
     */
    public void setDailyStartEndList(List<DailyStartEnd> dailyStartEndList) {
        _dailyStartEndList = dailyStartEndList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsTimecardDay) {
            BsTimecardDay other = (BsTimecardDay)obj;
            if (!xSV(_timecardDayId, other._timecardDayId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _timecardDayId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_member != null && _member.isPresent())
        { sb.append(li).append(xbRDS(_member, "member")); }
        if (_dailyStartEndAsCurrentValue != null && _dailyStartEndAsCurrentValue.isPresent())
        { sb.append(li).append(xbRDS(_dailyStartEndAsCurrentValue, "dailyStartEndAsCurrentValue")); }
        if (_dailyStartEndList != null) { for (DailyStartEnd et : _dailyStartEndList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "dailyStartEndList")); } } }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_timecardDayId));
        sb.append(dm).append(xfND(_memberId));
        sb.append(dm).append(xfND(_bizDate));
        sb.append(dm).append(xfND(_registerDatetime));
        sb.append(dm).append(xfND(_registerUser));
        sb.append(dm).append(xfND(_updateDatetime));
        sb.append(dm).append(xfND(_updateUser));
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
        if (_dailyStartEndAsCurrentValue != null && _dailyStartEndAsCurrentValue.isPresent())
        { sb.append(dm).append("dailyStartEndAsCurrentValue"); }
        if (_dailyStartEndList != null && !_dailyStartEndList.isEmpty())
        { sb.append(dm).append("dailyStartEndList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public TimecardDay clone() {
        return (TimecardDay)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] TIMECARD_DAY_ID: {PK, ID, NotNull, BIGINT(19), FK to DAILY_START_END} <br>
     * タイムカード年月日ID
     * @return The value of the column 'TIMECARD_DAY_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getTimecardDayId() {
        checkSpecifiedProperty("timecardDayId");
        return _timecardDayId;
    }

    /**
     * [set] TIMECARD_DAY_ID: {PK, ID, NotNull, BIGINT(19), FK to DAILY_START_END} <br>
     * タイムカード年月日ID
     * @param timecardDayId The value of the column 'TIMECARD_DAY_ID'. (basically NotNull if update: for the constraint)
     */
    public void setTimecardDayId(Long timecardDayId) {
        registerModifiedProperty("timecardDayId");
        _timecardDayId = timecardDayId;
    }

    /**
     * [get] MEMBER_ID: {UQ+, NotNull, BIGINT(19), FK to MEMBER} <br>
     * メンバーID
     * @return The value of the column 'MEMBER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getMemberId() {
        checkSpecifiedProperty("memberId");
        return _memberId;
    }

    /**
     * [set] MEMBER_ID: {UQ+, NotNull, BIGINT(19), FK to MEMBER} <br>
     * メンバーID
     * @param memberId The value of the column 'MEMBER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setMemberId(Long memberId) {
        registerModifiedProperty("memberId");
        _memberId = memberId;
    }

    /**
     * [get] BIZ_DATE: {+UQ, NotNull, DATE(10)} <br>
     * 業務日
     * @return The value of the column 'BIZ_DATE'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDate getBizDate() {
        checkSpecifiedProperty("bizDate");
        return _bizDate;
    }

    /**
     * [set] BIZ_DATE: {+UQ, NotNull, DATE(10)} <br>
     * 業務日
     * @param bizDate The value of the column 'BIZ_DATE'. (basically NotNull if update: for the constraint)
     */
    public void setBizDate(java.time.LocalDate bizDate) {
        registerModifiedProperty("bizDate");
        _bizDate = bizDate;
    }

    /**
     * [get] REGISTER_DATETIME: {NotNull, DATETIME(19)} <br>
     * 登録日時
     * @return The value of the column 'REGISTER_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDateTime getRegisterDatetime() {
        checkSpecifiedProperty("registerDatetime");
        return _registerDatetime;
    }

    /**
     * [set] REGISTER_DATETIME: {NotNull, DATETIME(19)} <br>
     * 登録日時
     * @param registerDatetime The value of the column 'REGISTER_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterDatetime(java.time.LocalDateTime registerDatetime) {
        registerModifiedProperty("registerDatetime");
        _registerDatetime = registerDatetime;
    }

    /**
     * [get] REGISTER_USER: {NotNull, VARCHAR(200)} <br>
     * 登録ユーザ
     * @return The value of the column 'REGISTER_USER'. (basically NotNull if selected: for the constraint)
     */
    public String getRegisterUser() {
        checkSpecifiedProperty("registerUser");
        return _registerUser;
    }

    /**
     * [set] REGISTER_USER: {NotNull, VARCHAR(200)} <br>
     * 登録ユーザ
     * @param registerUser The value of the column 'REGISTER_USER'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterUser(String registerUser) {
        registerModifiedProperty("registerUser");
        _registerUser = registerUser;
    }

    /**
     * [get] UPDATE_DATETIME: {NotNull, DATETIME(19)} <br>
     * 更新日時
     * @return The value of the column 'UPDATE_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDateTime getUpdateDatetime() {
        checkSpecifiedProperty("updateDatetime");
        return _updateDatetime;
    }

    /**
     * [set] UPDATE_DATETIME: {NotNull, DATETIME(19)} <br>
     * 更新日時
     * @param updateDatetime The value of the column 'UPDATE_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateDatetime(java.time.LocalDateTime updateDatetime) {
        registerModifiedProperty("updateDatetime");
        _updateDatetime = updateDatetime;
    }

    /**
     * [get] UPDATE_USER: {NotNull, VARCHAR(200)} <br>
     * 更新ユーザ
     * @return The value of the column 'UPDATE_USER'. (basically NotNull if selected: for the constraint)
     */
    public String getUpdateUser() {
        checkSpecifiedProperty("updateUser");
        return _updateUser;
    }

    /**
     * [set] UPDATE_USER: {NotNull, VARCHAR(200)} <br>
     * 更新ユーザ
     * @param updateUser The value of the column 'UPDATE_USER'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateUser(String updateUser) {
        registerModifiedProperty("updateUser");
        _updateUser = updateUser;
    }

    /**
     * [get] VERSION_NO: {NotNull, BIGINT(19)} <br>
     * バージョン番号
     * @return The value of the column 'VERSION_NO'. (basically NotNull if selected: for the constraint)
     */
    public Long getVersionNo() {
        checkSpecifiedProperty("versionNo");
        return _versionNo;
    }

    /**
     * [set] VERSION_NO: {NotNull, BIGINT(19)} <br>
     * バージョン番号
     * @param versionNo The value of the column 'VERSION_NO'. (basically NotNull if update: for the constraint)
     */
    public void setVersionNo(Long versionNo) {
        registerModifiedProperty("versionNo");
        _versionNo = versionNo;
    }
}
