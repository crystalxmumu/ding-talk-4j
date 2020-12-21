package top.todev.ding.org.bean.response.v2.dept;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>获取部门列表信息</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-15 18:38
 * @since 0.0.1
 */
@Data
public class DeptBaseResponse implements Serializable {

    private static final long serialVersionUID = -5792452489838196958L;

    /** 部门ID。*/
    @JSONField(name = "dept_id")
    private Integer deptId;
    /** 部门名称。*/
    private String name;
    /** 父部门ID。*/
    @JSONField(name = "parent_id")
    private Integer parentId;
    /** 是否同步创建一个关联此部门的企业群：true：创建;false：不创建*/
    @JSONField(name = "create_dept_group")
    private Boolean createDeptGroup;
    /** 部门群已经创建后，有新人加入部门是否会自动加入该群：true：会自动入群;false：不会*/
    @JSONField(name = "auto_add_user")
    private Boolean autoAddUser;
    /** 扩展字段。说明：只有在创建部门时指定了extension才会返回。*/
    private String ext;

}
