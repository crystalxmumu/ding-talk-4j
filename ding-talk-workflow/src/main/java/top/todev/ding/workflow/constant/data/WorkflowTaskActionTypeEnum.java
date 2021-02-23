package top.todev.ding.workflow.constant.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.todev.tool.model.constant.IStaticDataEnum;

/**
 * <p>工作流审批类型</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 14:08
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum WorkflowTaskActionTypeEnum implements IStaticDataEnum<String> {

    /** 会签 */
    AND("AND", "会签", "AND"),
    /** 或签 */
    OR("OR", "或签", "OR"),
    /** 单人 */
    NONE("NONE", "单人", "NONE");

    ;
    /** 编码 */
    private final String code;
    /** 名称 */
    private final String cnName;
    /** 值 */
    private final String value;
}
