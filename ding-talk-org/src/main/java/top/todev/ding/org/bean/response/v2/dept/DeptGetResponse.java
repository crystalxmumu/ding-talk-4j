package top.todev.ding.org.bean.response.v2.dept;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>部门详情</p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 10:35
 * @since 0.0.1
 */
@Data
public class DeptGetResponse implements Serializable {
    private static final long serialVersionUID = 5911483950060994761L;

    /**
     * 部门ID
     */
    @JSONField(name = "dept_id")
    private Long deptId;
    /**
     * 部门名称
     */
    @JSONField(name = "name")
    private String name;
    /**
     * 父部门id，根部门为1
     */
    @JSONField(name = "parent_id")
    private Long parentId;
    /**
     * 部门标识字段，开发者可用该字段来唯一标识一个部门，并与钉钉外部通讯录里的部门做映射
     */
    @JSONField(name = "source_identifier")
    private String sourceIdentifier;
    /**
     * 是否同步创建一个关联此部门的企业群, true表示是, false表示不是
     */
    @JSONField(name = "create_dept_group")
    private Boolean createDeptGroup;
    /**
     * 当群已经创建后，是否有新人加入部门会自动加入该群
     */
    @JSONField(name = "auto_add_user")
    private Boolean autoAddUser;
    /**
     * 部门是否来自关联组织
     */
    @JSONField(name = "from_union_org")
    private Boolean fromUnionOrg;
    /**
     * 教育行业部门类型，包括campus,period,grade,class.
     */
    @JSONField(name = "tags")
    private String tags;
    /**
     * 在父部门中的次序值
     */
    @JSONField(name = "order")
    private Long order;
    /**
     * 部门群ID
     */
    @JSONField(name = "dept_group_chat_id")
    private String deptGroupChatId;
    /**
     * 部门群是否包含子部门
     */
    @JSONField(name = "group_contain_sub_dept")
    private Boolean groupContainSubDept;
    /**
     * 企业群群主ID
     */
    @JSONField(name = "org_dept_owner")
    private String orgDeptOwner;
    /**
     * 部门的主管列表
     */
    @JSONField(name = "dept_manager_userid_list")
    private List<String> deptManagerUseridList;
    /**
     * 是否本部门的员工仅可见员工自己, 为true时，本部门员工默认只能看到员工自己
     */
    @JSONField(name = "outer_dept")
    private Boolean outerDept;
    /**
     * 本部门的员工仅可见员工自己为true时，可以配置额外可见部门
     */
    @JSONField(name = "outer_permit_depts")
    private List<Long> outerPermitDepts;
    /**
     * 本部门的员工仅可见员工自己为true时，可以配置额外可见人员
     */
    @JSONField(name = "outer_permit_users")
    private List<String> outerPermitUsers;
    /**
     * 是否隐藏部门, true表示隐藏, false表示显示
     */
    @JSONField(name = "hide_dept")
    private Boolean hideDept;
    /**
     * 可以查看指定隐藏部门的其他人员列表，如果部门隐藏，则此值生效，取值为其他的人员userid组成的数组
     */
    @JSONField(name = "user_permits")
    private List<String> userPermits;
    /**
     * 可以查看指定隐藏部门的其他人员列表，如果部门隐藏，则此值生效，取值为其他的人员userid组成的数组
     */
    @JSONField(name = "dept_permits")
    private List<Long> deptPermits;
    /**
     * 扩展字段
     */
    @JSONField(name = "extention")
    private String extention;
}
