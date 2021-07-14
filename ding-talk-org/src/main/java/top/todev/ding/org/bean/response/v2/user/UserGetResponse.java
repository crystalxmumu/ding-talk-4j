package top.todev.ding.org.bean.response.v2.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import top.todev.ding.org.bean.response.v2.dept.DeptLeader;
import top.todev.ding.org.bean.response.v2.dept.DeptOrder;

import java.io.Serializable;
import java.util.List;

/**
 * <p>用户实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 09:56
 * @since 0.0.1
 */
@Data
public class UserGetResponse implements Serializable {

    private static final long serialVersionUID = -692493067427931675L;

    /**
     * 用户id
     */
    @JSONField(name = "userid")
    private String userId;
    /**
     * 员工在当前开发者企业账号范围内的唯一标识
     */
    @JSONField(name = "unionid")
    private String unionId;

    /**
     * 员工名称
     */
    private String name;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 国际电话区号
     */
    @JSONField(name = "state_code")
    private String stateCode;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 是否号码隐藏。隐藏手机号后，手机号在个人资料页隐藏，但仍可对其发DING、发起钉钉免费商务电话。
     */
    @JSONField(name = "hide_mobile")
    private Boolean hideMobile;
    /**
     * 分机号
     */
    @JSONField(name = "telephone")
    private String telephone;
    /**
     * 员工工号
     */
    @JSONField(name = "job_number")
    private String jobNumber;
    /**
     * 职位
     */
    private String title;
    /**
     * 员工邮箱
     */
    private String email;
    /**
     * 办公地点
     */
    @JSONField(name = "work_place")
    private String workPlace;
    /**
     * 备注
     */
    private String remark;
    /**
     * 所属部门id列表
     */
    @JSONField(name = "dept_id_list")
    private List<Long> deptIdList;
    /**
     * 员工在对应的部门中的排序。
     */
    @JSONField(name = "dept_order_list")
    private List<DeptOrder> deptOrderList;
    /**
     * 扩展属性，长度最大2000个字符。可以设置多种属性（手机上最多显示10个扩展属性，具体显示哪些属性，
     * 请到OA管理后台-&gt;设置-&gt;通讯录信息设置和OA管理后台-&gt;设置-&gt;手机端显示信息设置）。
     * 该字段的值支持链接类型填写，同时链接支持变量通配符自动替换，目前支持通配符有：userid，corpid。
     * 示例： 【工位地址】
     */
    private String extension;
    /**
     * 入职时间，Unix时间戳，单位ms。
     */
    @JSONField(name = "hired_date")
    private Long hiredDate;
    /**
     * 是否激活
     */
    private Boolean active;
    /**
     * 是否实名认证
     */
    @JSONField(name = "real_authed")
    private Boolean realAuthed;
    /**
     * 是否高管
     */
    private Boolean senior;
    /**
     * 是否管理员
     */
    private Boolean admin;
    /**
     * 是否老板
     */
    private Boolean boss;
    /**
     * 员工在对应的部门中是否领导。
     */
    @JSONField(name = "leader_in_dept")
    private List<DeptLeader> leaderInDept;
    /**
     * 角色列表
     */
    @JSONField(name = "role_list")
    private List<UserRole> roleList;
    /**
     * 关联信息
     */
    @JSONField(name = "union_emp_ext")
    private UnionEmpExt unionEmpExt;
    /**
     * 是否专属帐号
     */
    @JSONField(name = "exclusive_account")
    private Boolean exclusiveAccount;
    /**
     * 员工的企业邮箱
     */
    @JSONField(name = "org_email")
    private String orgEmail;
}
