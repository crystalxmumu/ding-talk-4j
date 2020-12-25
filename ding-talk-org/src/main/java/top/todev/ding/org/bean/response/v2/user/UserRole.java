package top.todev.ding.org.bean.response.v2.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>角色列表</p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 10:04
 * @since 0.0.1
 */
@Data
public class UserRole implements Serializable {
    private static final long serialVersionUID = -2907986435710818735L;

    /**
     * 角色组名称
     */
    @JSONField(name = "group_name")
    private String groupName;
    /**
     * 角色id
     */
    @JSONField(name = "id")
    private Long id;
    /**
     * 角色名称
     */
    @JSONField(name = "name")
    private String name;
}
