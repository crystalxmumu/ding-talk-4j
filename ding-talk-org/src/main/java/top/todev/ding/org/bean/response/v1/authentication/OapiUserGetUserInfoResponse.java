package top.todev.ding.org.bean.response.v1.authentication;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.todev.ding.common.bean.response.BaseDingTalkResponse;

/**
 * <p>通过免登码获取用户信息响应实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 08:30
 * @since 0.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OapiUserGetUserInfoResponse extends BaseDingTalkResponse<UserInfoBaseResponse> {
    private static final long serialVersionUID = -5171717307668910901L;

    /** 员工在当前企业内的唯一标识，也称staffId。 */
    @JSONField(name = "userid")
    private String userId;

    /** 员工姓名。 */
    private String name;

    /** 设备ID。 */
    private String deviceId;

    /** 是否是管理员。 true：是，false：不是*/
    @JSONField(name = "is_sys")
    private Boolean isSys;

    /**
     * 级别。
     * 1：主管理员
     * 2：子管理员
     * 100：老板
     * 0：其他（如普通员工）
     */
    @JSONField(name = "sys_level")
    private String sysLevel;

    @Override
    public BaseDingTalkResponse<UserInfoBaseResponse> initSuccess(UserInfoBaseResponse user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.deviceId = user.getDeviceId();
        this.isSys = user.getIsSys();
        this.sysLevel = user.getSysLevel();
        return this;
    }

    @Override
    public UserInfoBaseResponse getData() {
        return new UserInfoBaseResponse(userId, name, deviceId, isSys, sysLevel);
    }
}
