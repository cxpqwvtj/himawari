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
 * The entity of DAILY_START_END as TABLE. <br>
 * 日次勤務時間記録
 * <pre>
 * [primary-key]
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
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long dailyStartEndId = entity.getDailyStartEndId();
 * Long timecardDayId = entity.getTimecardDayId();
 * java.time.LocalDateTime startDatetime = entity.getStartDatetime();
 * java.time.LocalDateTime endDatetime = entity.getEndDatetime();
 * String vacationTypeCode = entity.getVacationTypeCode();
 * String note = entity.getNote();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerUser = entity.getRegisterUser();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateUser = entity.getUpdateUser();
 * Long versionNo = entity.getVersionNo();
 * entity.setDailyStartEndId(dailyStartEndId);
 * entity.setTimecardDayId(timecardDayId);
 * entity.setStartDatetime(startDatetime);
 * entity.setEndDatetime(endDatetime);
 * entity.setVacationTypeCode(vacationTypeCode);
 * entity.setNote(note);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterUser(registerUser);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateUser(updateUser);
 * entity.setVersionNo(versionNo);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsDailyStartEnd extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)} */
    protected Long _dailyStartEndId;

    /** TIMECARD_DAY_ID: {IX, NotNull, BIGINT(19), FK to TIMECARD_DAY} */
    protected Long _timecardDayId;

    /** START_DATETIME: {DATETIME(19)} */
    protected java.time.LocalDateTime _startDatetime;

    /** END_DATETIME: {DATETIME(19)} */
    protected java.time.LocalDateTime _endDatetime;

    /** VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE} */
    protected String _vacationTypeCode;

    /** NOTE: {TEXT(65535)} */
    protected String _note;

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
        return "DAILY_START_END";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_dailyStartEndId == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** TIMECARD_DAY by my TIMECARD_DAY_ID, named 'timecardDay'. */
    protected OptionalEntity<TimecardDay> _timecardDay;

    /**
     * [get] TIMECARD_DAY by my TIMECARD_DAY_ID, named 'timecardDay'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'timecardDay'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<TimecardDay> getTimecardDay() {
        if (_timecardDay == null) { _timecardDay = OptionalEntity.relationEmpty(this, "timecardDay"); }
        return _timecardDay;
    }

    /**
     * [set] TIMECARD_DAY by my TIMECARD_DAY_ID, named 'timecardDay'.
     * @param timecardDay The entity of foreign property 'timecardDay'. (NullAllowed)
     */
    public void setTimecardDay(OptionalEntity<TimecardDay> timecardDay) {
        _timecardDay = timecardDay;
    }

    /** VACATION_TYPE by my VACATION_TYPE_CODE, named 'vacationType'. */
    protected OptionalEntity<VacationType> _vacationType;

    /**
     * [get] VACATION_TYPE by my VACATION_TYPE_CODE, named 'vacationType'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'vacationType'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<VacationType> getVacationType() {
        if (_vacationType == null) { _vacationType = OptionalEntity.relationEmpty(this, "vacationType"); }
        return _vacationType;
    }

    /**
     * [set] VACATION_TYPE by my VACATION_TYPE_CODE, named 'vacationType'.
     * @param vacationType The entity of foreign property 'vacationType'. (NullAllowed)
     */
    public void setVacationType(OptionalEntity<VacationType> vacationType) {
        _vacationType = vacationType;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsDailyStartEnd) {
            BsDailyStartEnd other = (BsDailyStartEnd)obj;
            if (!xSV(_dailyStartEndId, other._dailyStartEndId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _dailyStartEndId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_timecardDay != null && _timecardDay.isPresent())
        { sb.append(li).append(xbRDS(_timecardDay, "timecardDay")); }
        if (_vacationType != null && _vacationType.isPresent())
        { sb.append(li).append(xbRDS(_vacationType, "vacationType")); }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_dailyStartEndId));
        sb.append(dm).append(xfND(_timecardDayId));
        sb.append(dm).append(xfND(_startDatetime));
        sb.append(dm).append(xfND(_endDatetime));
        sb.append(dm).append(xfND(_vacationTypeCode));
        sb.append(dm).append(xfND(_note));
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
        if (_timecardDay != null && _timecardDay.isPresent())
        { sb.append(dm).append("timecardDay"); }
        if (_vacationType != null && _vacationType.isPresent())
        { sb.append(dm).append("vacationType"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public DailyStartEnd clone() {
        return (DailyStartEnd)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)} <br>
     * 日次勤務時間記録ID
     * @return The value of the column 'DAILY_START_END_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getDailyStartEndId() {
        checkSpecifiedProperty("dailyStartEndId");
        return _dailyStartEndId;
    }

    /**
     * [set] DAILY_START_END_ID: {PK, ID, NotNull, BIGINT(19)} <br>
     * 日次勤務時間記録ID
     * @param dailyStartEndId The value of the column 'DAILY_START_END_ID'. (basically NotNull if update: for the constraint)
     */
    public void setDailyStartEndId(Long dailyStartEndId) {
        registerModifiedProperty("dailyStartEndId");
        _dailyStartEndId = dailyStartEndId;
    }

    /**
     * [get] TIMECARD_DAY_ID: {IX, NotNull, BIGINT(19), FK to TIMECARD_DAY} <br>
     * タイムカード年月日ID
     * @return The value of the column 'TIMECARD_DAY_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getTimecardDayId() {
        checkSpecifiedProperty("timecardDayId");
        return _timecardDayId;
    }

    /**
     * [set] TIMECARD_DAY_ID: {IX, NotNull, BIGINT(19), FK to TIMECARD_DAY} <br>
     * タイムカード年月日ID
     * @param timecardDayId The value of the column 'TIMECARD_DAY_ID'. (basically NotNull if update: for the constraint)
     */
    public void setTimecardDayId(Long timecardDayId) {
        registerModifiedProperty("timecardDayId");
        _timecardDayId = timecardDayId;
    }

    /**
     * [get] START_DATETIME: {DATETIME(19)} <br>
     * 開始日時
     * @return The value of the column 'START_DATETIME'. (NullAllowed even if selected: for no constraint)
     */
    public java.time.LocalDateTime getStartDatetime() {
        checkSpecifiedProperty("startDatetime");
        return _startDatetime;
    }

    /**
     * [set] START_DATETIME: {DATETIME(19)} <br>
     * 開始日時
     * @param startDatetime The value of the column 'START_DATETIME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setStartDatetime(java.time.LocalDateTime startDatetime) {
        registerModifiedProperty("startDatetime");
        _startDatetime = startDatetime;
    }

    /**
     * [get] END_DATETIME: {DATETIME(19)} <br>
     * 終了日時
     * @return The value of the column 'END_DATETIME'. (NullAllowed even if selected: for no constraint)
     */
    public java.time.LocalDateTime getEndDatetime() {
        checkSpecifiedProperty("endDatetime");
        return _endDatetime;
    }

    /**
     * [set] END_DATETIME: {DATETIME(19)} <br>
     * 終了日時
     * @param endDatetime The value of the column 'END_DATETIME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setEndDatetime(java.time.LocalDateTime endDatetime) {
        registerModifiedProperty("endDatetime");
        _endDatetime = endDatetime;
    }

    /**
     * [get] VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE} <br>
     * 休暇タイプコード
     * @return The value of the column 'VACATION_TYPE_CODE'. (NullAllowed even if selected: for no constraint)
     */
    public String getVacationTypeCode() {
        checkSpecifiedProperty("vacationTypeCode");
        return _vacationTypeCode;
    }

    /**
     * [set] VACATION_TYPE_CODE: {IX, VARCHAR(20), FK to VACATION_TYPE} <br>
     * 休暇タイプコード
     * @param vacationTypeCode The value of the column 'VACATION_TYPE_CODE'. (NullAllowed: null update allowed for no constraint)
     */
    public void setVacationTypeCode(String vacationTypeCode) {
        registerModifiedProperty("vacationTypeCode");
        _vacationTypeCode = vacationTypeCode;
    }

    /**
     * [get] NOTE: {TEXT(65535)} <br>
     * 備考入力テキスト
     * @return The value of the column 'NOTE'. (NullAllowed even if selected: for no constraint)
     */
    public String getNote() {
        checkSpecifiedProperty("note");
        return _note;
    }

    /**
     * [set] NOTE: {TEXT(65535)} <br>
     * 備考入力テキスト
     * @param note The value of the column 'NOTE'. (NullAllowed: null update allowed for no constraint)
     */
    public void setNote(String note) {
        registerModifiedProperty("note");
        _note = note;
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
