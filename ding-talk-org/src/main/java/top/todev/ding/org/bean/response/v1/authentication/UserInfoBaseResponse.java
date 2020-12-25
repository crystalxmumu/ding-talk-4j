package top.todev.ding.org.bean.response.v1.authentication;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>员工基础信息实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 09:28
 * @since 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoBaseResponse implements Serializable {


    private static final long serialVersionUID = 5428346291668903230L;
    /** 员工在当前企业内的唯一标识，也称staffId。 */
    private String userId;

    /** 员工姓名。 */
    private String name;

    /** 设备ID。 */
    private String deviceId;

    /** 是否是管理员。 true：是，false：不是*/
    private Boolean isSys;

    /**
     * 级别。
     * 1：主管理员
     * 2：子管理员
     * 100：老板
     * 0：其他（如普通员工）
     */
    private String sysLevel;
}
