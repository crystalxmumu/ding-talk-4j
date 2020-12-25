package top.todev.ding.org.bean.request.v2.user;

import lombok.Builder;
import lombok.Data;
import top.todev.ding.common.annotation.RequestParam;
import top.todev.ding.common.constant.data.LangEnum;
import top.todev.ding.org.constant.data.DepartmentMemberSortRuleEnum;

import java.io.Serializable;

/**
 * <p>获取部门用户请求实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 10:52
 * @since 0.0.1
 */
@Data
@Builder
public class OapiUserListSimpleRequest implements Serializable {
    private static final long serialVersionUID = 6759912559938920348L;

    /**
     * 部门id
     */
    @RequestParam(key = "dept_id")
    private Long deptId;

    /**
     * 游标
     */
    private Long cursor;

    /**
     * 分页长度
     */
    private Long size;

    /**
     * 排序字段，默认custom。或者以下取值entry_asc、entry_desc、modify_asc、modify_desc、custom
     */
    @RequestParam(key = "order_field")
    private DepartmentMemberSortRuleEnum orderField;

    /**
     * 是否返回访问受限的员工
     */
    @RequestParam(key = "contain_access_limit")
    private Boolean containAccessLimit;

    /**
     * 语言
     */
    private LangEnum language;


}
