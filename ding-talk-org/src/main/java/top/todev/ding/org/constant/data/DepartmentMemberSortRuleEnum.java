package top.todev.ding.org.constant.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.todev.tool.model.constant.IStaticDataEnum;

/**
 * <p>部门成员排序规则枚举</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 10:55
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum DepartmentMemberSortRuleEnum implements IStaticDataEnum<String> {

    /** 代表按照进入部门的时间升序 */
    DEPT_SORT_RULE_ENTRY_ASC("DEPT_SORT_RULE_ENTRY_ASC", "进入部门的时间升序", "entry_asc"),
    /** 代表按照进入部门的时间降序 */
    DEPT_SORT_RULE_ENTRY_DESC("DEPT_SORT_RULE_ENTRY_DESC", "进入部门的时间降序", "entry_desc"),
    /** 代表按照部门信息修改时间升序 */
    DEPT_SORT_RULE_MODIFY_ASC("DEPT_SORT_RULE_MODIFY_ASC", "部门信息修改时间升序", "modify_asc"),
    /** 代表按照部门信息修改时间降序 */
    DEPT_SORT_RULE_MODIFY_DESC("DEPT_SORT_RULE_MODIFY_DESC", "部门信息修改时间降序", "modify_desc"),
    /** 代表按照用户定义(未定义时按照拼音)排序 */
    DEPT_SORT_RULE_CUSTOM("DEPT_SORT_RULE_CUSTOM", "用户定义(未定义时按照拼音)排序", "custom"),

    ;
    /** 编码 */
    private final String code;
    /** 名称 */
    private final String cnName;
    /** 值 */
    private final String value;
}
