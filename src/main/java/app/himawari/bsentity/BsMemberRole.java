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
 * The entity of MEMBER_ROLE as TABLE. <br>
 * メンバー権限
 * <pre>
 * [primary-key]
 *     MEMBER_ROLE_ID
 *
 * [column]
 *     MEMBER_ROLE_ID, MEMBER_ID, ROLE_TYPE_CODE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
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
 *     MEMBER, ROLE
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     member, role
 *
 * [referrer property]
 *     
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long memberRoleId = entity.getMemberRoleId();
 * Long memberId = entity.getMemberId();
 * String roleTypeCode = entity.getRoleTypeCode();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerUser = entity.getRegisterUser();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateUser = entity.getUpdateUser();
 * Long versionNo = entity.getVersionNo();
 * entity.setMemberRoleId(memberRoleId);
 * entity.setMemberId(memberId);
 * entity.setRoleTypeCode(roleTypeCode);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterUser(registerUser);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateUser(updateUser);
 * entity.setVersionNo(versionNo);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberRole extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** MEMBER_ROLE_ID: {PK, NotNull, BIGINT(19)} */
    protected Long _memberRoleId;

    /** MEMBER_ID: {UQ+, NotNull, BIGINT(19), FK to MEMBER} */
    protected Long _memberId;

    /** ROLE_TYPE_CODE: {+UQ, IX, NotNull, VARCHAR(20), FK to ROLE} */
    protected String _roleTypeCode;

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
        return "MEMBER_ROLE";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_memberRoleId == null) { return false; }
        return true;
    }

    /**
     * To be unique by the unique column. <br>
     * You can update the entity by the key when entity update (NOT batch update).
     * @param memberId : UQ+, NotNull, BIGINT(19), FK to MEMBER. (NotNull)
     * @param roleTypeCode : +UQ, IX, NotNull, VARCHAR(20), FK to ROLE. (NotNull)
     */
    public void uniqueBy(Long memberId, String roleTypeCode) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("memberId");
        __uniqueDrivenProperties.addPropertyName("roleTypeCode");
        setMemberId(memberId);setRoleTypeCode(roleTypeCode);
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

    /** ROLE by my ROLE_TYPE_CODE, named 'role'. */
    protected OptionalEntity<Role> _role;

    /**
     * [get] ROLE by my ROLE_TYPE_CODE, named 'role'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'role'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Role> getRole() {
        if (_role == null) { _role = OptionalEntity.relationEmpty(this, "role"); }
        return _role;
    }

    /**
     * [set] ROLE by my ROLE_TYPE_CODE, named 'role'.
     * @param role The entity of foreign property 'role'. (NullAllowed)
     */
    public void setRole(OptionalEntity<Role> role) {
        _role = role;
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
        if (obj instanceof BsMemberRole) {
            BsMemberRole other = (BsMemberRole)obj;
            if (!xSV(_memberRoleId, other._memberRoleId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _memberRoleId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_member != null && _member.isPresent())
        { sb.append(li).append(xbRDS(_member, "member")); }
        if (_role != null && _role.isPresent())
        { sb.append(li).append(xbRDS(_role, "role")); }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_memberRoleId));
        sb.append(dm).append(xfND(_memberId));
        sb.append(dm).append(xfND(_roleTypeCode));
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
        if (_role != null && _role.isPresent())
        { sb.append(dm).append("role"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public MemberRole clone() {
        return (MemberRole)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] MEMBER_ROLE_ID: {PK, NotNull, BIGINT(19)} <br>
     * メンバー権限ID
     * @return The value of the column 'MEMBER_ROLE_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getMemberRoleId() {
        checkSpecifiedProperty("memberRoleId");
        return _memberRoleId;
    }

    /**
     * [set] MEMBER_ROLE_ID: {PK, NotNull, BIGINT(19)} <br>
     * メンバー権限ID
     * @param memberRoleId The value of the column 'MEMBER_ROLE_ID'. (basically NotNull if update: for the constraint)
     */
    public void setMemberRoleId(Long memberRoleId) {
        registerModifiedProperty("memberRoleId");
        _memberRoleId = memberRoleId;
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
     * [get] ROLE_TYPE_CODE: {+UQ, IX, NotNull, VARCHAR(20), FK to ROLE} <br>
     * 権限コード
     * @return The value of the column 'ROLE_TYPE_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getRoleTypeCode() {
        checkSpecifiedProperty("roleTypeCode");
        return _roleTypeCode;
    }

    /**
     * [set] ROLE_TYPE_CODE: {+UQ, IX, NotNull, VARCHAR(20), FK to ROLE} <br>
     * 権限コード
     * @param roleTypeCode The value of the column 'ROLE_TYPE_CODE'. (basically NotNull if update: for the constraint)
     */
    public void setRoleTypeCode(String roleTypeCode) {
        registerModifiedProperty("roleTypeCode");
        _roleTypeCode = roleTypeCode;
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
