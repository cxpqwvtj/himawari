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
 * The entity of daily_in_out as TABLE. <br>
 * ????????
 * <pre>
 * [primary-key]
 *     DAILY_IN_OUT_ID
 *
 * [column]
 *     DAILY_IN_OUT_ID, TIMECARD_ID, IN_DATETIME, OUT_DATETIME, VACATION_TYPE_CODE, NOTE, REGISTER_DATETIME, REGISTER_USER, REGISTER_PROCESS, UPDATE_DATETIME, UPDATE_USER, UPDATE_PROCESS, VERSION_NO
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
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long dailyInOutId = entity.getDailyInOutId();
 * Long timecardId = entity.getTimecardId();
 * java.time.LocalDateTime inDatetime = entity.getInDatetime();
 * java.time.LocalDateTime outDatetime = entity.getOutDatetime();
 * String vacationTypeCode = entity.getVacationTypeCode();
 * String note = entity.getNote();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerUser = entity.getRegisterUser();
 * String registerProcess = entity.getRegisterProcess();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateUser = entity.getUpdateUser();
 * String updateProcess = entity.getUpdateProcess();
 * Long versionNo = entity.getVersionNo();
 * entity.setDailyInOutId(dailyInOutId);
 * entity.setTimecardId(timecardId);
 * entity.setInDatetime(inDatetime);
 * entity.setOutDatetime(outDatetime);
 * entity.setVacationTypeCode(vacationTypeCode);
 * entity.setNote(note);
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
public abstract class BsDailyInOut extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)} */
    protected Long _dailyInOutId;

    /** TIMECARD_ID: {IX, NotNull, BIGINT(19), FK to timecard} */
    protected Long _timecardId;

    /** IN_DATETIME: {DATETIME(19)} */
    protected java.time.LocalDateTime _inDatetime;

    /** OUT_DATETIME: {DATETIME(19)} */
    protected java.time.LocalDateTime _outDatetime;

    /** VACATION_TYPE_CODE: {IX, NotNull, VARCHAR(3), FK to vacation_type} */
    protected String _vacationTypeCode;

    /** NOTE: {TEXT(65535)} */
    protected String _note;

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
        return "daily_in_out";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_dailyInOutId == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** timecard by my TIMECARD_ID, named 'timecard'. */
    protected OptionalEntity<Timecard> _timecard;

    /**
     * [get] timecard by my TIMECARD_ID, named 'timecard'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'timecard'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Timecard> getTimecard() {
        if (_timecard == null) { _timecard = OptionalEntity.relationEmpty(this, "timecard"); }
        return _timecard;
    }

    /**
     * [set] timecard by my TIMECARD_ID, named 'timecard'.
     * @param timecard The entity of foreign property 'timecard'. (NullAllowed)
     */
    public void setTimecard(OptionalEntity<Timecard> timecard) {
        _timecard = timecard;
    }

    /** vacation_type by my VACATION_TYPE_CODE, named 'vacationType'. */
    protected OptionalEntity<VacationType> _vacationType;

    /**
     * [get] vacation_type by my VACATION_TYPE_CODE, named 'vacationType'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'vacationType'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<VacationType> getVacationType() {
        if (_vacationType == null) { _vacationType = OptionalEntity.relationEmpty(this, "vacationType"); }
        return _vacationType;
    }

    /**
     * [set] vacation_type by my VACATION_TYPE_CODE, named 'vacationType'.
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
        if (obj instanceof BsDailyInOut) {
            BsDailyInOut other = (BsDailyInOut)obj;
            if (!xSV(_dailyInOutId, other._dailyInOutId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _dailyInOutId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_timecard != null && _timecard.isPresent())
        { sb.append(li).append(xbRDS(_timecard, "timecard")); }
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
        sb.append(dm).append(xfND(_dailyInOutId));
        sb.append(dm).append(xfND(_timecardId));
        sb.append(dm).append(xfND(_inDatetime));
        sb.append(dm).append(xfND(_outDatetime));
        sb.append(dm).append(xfND(_vacationTypeCode));
        sb.append(dm).append(xfND(_note));
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
        if (_timecard != null && _timecard.isPresent())
        { sb.append(dm).append("timecard"); }
        if (_vacationType != null && _vacationType.isPresent())
        { sb.append(dm).append("vacationType"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public DailyInOut clone() {
        return (DailyInOut)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)} <br>
     * ????????ID
     * @return The value of the column 'DAILY_IN_OUT_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getDailyInOutId() {
        checkSpecifiedProperty("dailyInOutId");
        return _dailyInOutId;
    }

    /**
     * [set] DAILY_IN_OUT_ID: {PK, ID, NotNull, BIGINT(19)} <br>
     * ????????ID
     * @param dailyInOutId The value of the column 'DAILY_IN_OUT_ID'. (basically NotNull if update: for the constraint)
     */
    public void setDailyInOutId(Long dailyInOutId) {
        registerModifiedProperty("dailyInOutId");
        _dailyInOutId = dailyInOutId;
    }

    /**
     * [get] TIMECARD_ID: {IX, NotNull, BIGINT(19), FK to timecard} <br>
     * ??????ID
     * @return The value of the column 'TIMECARD_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getTimecardId() {
        checkSpecifiedProperty("timecardId");
        return _timecardId;
    }

    /**
     * [set] TIMECARD_ID: {IX, NotNull, BIGINT(19), FK to timecard} <br>
     * ??????ID
     * @param timecardId The value of the column 'TIMECARD_ID'. (basically NotNull if update: for the constraint)
     */
    public void setTimecardId(Long timecardId) {
        registerModifiedProperty("timecardId");
        _timecardId = timecardId;
    }

    /**
     * [get] IN_DATETIME: {DATETIME(19)} <br>
     * ????
     * @return The value of the column 'IN_DATETIME'. (NullAllowed even if selected: for no constraint)
     */
    public java.time.LocalDateTime getInDatetime() {
        checkSpecifiedProperty("inDatetime");
        return _inDatetime;
    }

    /**
     * [set] IN_DATETIME: {DATETIME(19)} <br>
     * ????
     * @param inDatetime The value of the column 'IN_DATETIME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setInDatetime(java.time.LocalDateTime inDatetime) {
        registerModifiedProperty("inDatetime");
        _inDatetime = inDatetime;
    }

    /**
     * [get] OUT_DATETIME: {DATETIME(19)} <br>
     * ????
     * @return The value of the column 'OUT_DATETIME'. (NullAllowed even if selected: for no constraint)
     */
    public java.time.LocalDateTime getOutDatetime() {
        checkSpecifiedProperty("outDatetime");
        return _outDatetime;
    }

    /**
     * [set] OUT_DATETIME: {DATETIME(19)} <br>
     * ????
     * @param outDatetime The value of the column 'OUT_DATETIME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setOutDatetime(java.time.LocalDateTime outDatetime) {
        registerModifiedProperty("outDatetime");
        _outDatetime = outDatetime;
    }

    /**
     * [get] VACATION_TYPE_CODE: {IX, NotNull, VARCHAR(3), FK to vacation_type} <br>
     * ????????
     * @return The value of the column 'VACATION_TYPE_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getVacationTypeCode() {
        checkSpecifiedProperty("vacationTypeCode");
        return _vacationTypeCode;
    }

    /**
     * [set] VACATION_TYPE_CODE: {IX, NotNull, VARCHAR(3), FK to vacation_type} <br>
     * ????????
     * @param vacationTypeCode The value of the column 'VACATION_TYPE_CODE'. (basically NotNull if update: for the constraint)
     */
    public void setVacationTypeCode(String vacationTypeCode) {
        registerModifiedProperty("vacationTypeCode");
        _vacationTypeCode = vacationTypeCode;
    }

    /**
     * [get] NOTE: {TEXT(65535)} <br>
     * ????????
     * @return The value of the column 'NOTE'. (NullAllowed even if selected: for no constraint)
     */
    public String getNote() {
        checkSpecifiedProperty("note");
        return _note;
    }

    /**
     * [set] NOTE: {TEXT(65535)} <br>
     * ????????
     * @param note The value of the column 'NOTE'. (NullAllowed: null update allowed for no constraint)
     */
    public void setNote(String note) {
        registerModifiedProperty("note");
        _note = note;
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