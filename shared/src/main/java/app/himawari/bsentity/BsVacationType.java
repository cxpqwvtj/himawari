package app.himawari.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import app.himawari.allcommon.EntityDefinedCommonColumn;
import app.himawari.allcommon.DBMetaInstanceHandler;
import app.himawari.exentity.*;

/**
 * The entity of VACATION_TYPE as TABLE. <br>
 * 休暇タイプ
 * <pre>
 * [primary-key]
 *     VACATION_TYPE_CODE
 *
 * [column]
 *     VACATION_TYPE_CODE, VACATION_TYPE_NAME, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 *
 * [sequence]
 *     
 *
 * [identity]
 *     
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *     
 *
 * [referrer table]
 *     DAILY_START_END
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     dailyStartEndList
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * String vacationTypeCode = entity.getVacationTypeCode();
 * String vacationTypeName = entity.getVacationTypeName();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerUser = entity.getRegisterUser();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateUser = entity.getUpdateUser();
 * Long versionNo = entity.getVersionNo();
 * entity.setVacationTypeCode(vacationTypeCode);
 * entity.setVacationTypeName(vacationTypeName);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterUser(registerUser);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateUser(updateUser);
 * entity.setVersionNo(versionNo);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsVacationType extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** VACATION_TYPE_CODE: {PK, NotNull, VARCHAR(20)} */
    protected String _vacationTypeCode;

    /** VACATION_TYPE_NAME: {NotNull, VARCHAR(200)} */
    protected String _vacationTypeName;

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
        return "VACATION_TYPE";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_vacationTypeCode == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** DAILY_START_END by VACATION_TYPE_CODE, named 'dailyStartEndList'. */
    protected List<DailyStartEnd> _dailyStartEndList;

    /**
     * [get] DAILY_START_END by VACATION_TYPE_CODE, named 'dailyStartEndList'.
     * @return The entity list of referrer property 'dailyStartEndList'. (NotNull: even if no loading, returns empty list)
     */
    public List<DailyStartEnd> getDailyStartEndList() {
        if (_dailyStartEndList == null) { _dailyStartEndList = newReferrerList(); }
        return _dailyStartEndList;
    }

    /**
     * [set] DAILY_START_END by VACATION_TYPE_CODE, named 'dailyStartEndList'.
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
        if (obj instanceof BsVacationType) {
            BsVacationType other = (BsVacationType)obj;
            if (!xSV(_vacationTypeCode, other._vacationTypeCode)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _vacationTypeCode);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_dailyStartEndList != null) { for (DailyStartEnd et : _dailyStartEndList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "dailyStartEndList")); } } }
        return sb.toString();
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_vacationTypeCode));
        sb.append(dm).append(xfND(_vacationTypeName));
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
        if (_dailyStartEndList != null && !_dailyStartEndList.isEmpty())
        { sb.append(dm).append("dailyStartEndList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public VacationType clone() {
        return (VacationType)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] VACATION_TYPE_CODE: {PK, NotNull, VARCHAR(20)} <br>
     * 休暇タイプコード
     * @return The value of the column 'VACATION_TYPE_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getVacationTypeCode() {
        checkSpecifiedProperty("vacationTypeCode");
        return _vacationTypeCode;
    }

    /**
     * [set] VACATION_TYPE_CODE: {PK, NotNull, VARCHAR(20)} <br>
     * 休暇タイプコード
     * @param vacationTypeCode The value of the column 'VACATION_TYPE_CODE'. (basically NotNull if update: for the constraint)
     */
    public void setVacationTypeCode(String vacationTypeCode) {
        registerModifiedProperty("vacationTypeCode");
        _vacationTypeCode = vacationTypeCode;
    }

    /**
     * [get] VACATION_TYPE_NAME: {NotNull, VARCHAR(200)} <br>
     * 休暇タイプ名称
     * @return The value of the column 'VACATION_TYPE_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getVacationTypeName() {
        checkSpecifiedProperty("vacationTypeName");
        return _vacationTypeName;
    }

    /**
     * [set] VACATION_TYPE_NAME: {NotNull, VARCHAR(200)} <br>
     * 休暇タイプ名称
     * @param vacationTypeName The value of the column 'VACATION_TYPE_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setVacationTypeName(String vacationTypeName) {
        registerModifiedProperty("vacationTypeName");
        _vacationTypeName = vacationTypeName;
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
