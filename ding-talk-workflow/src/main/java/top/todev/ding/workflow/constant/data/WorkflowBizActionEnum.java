package top.todev.ding.workflow.constant.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.todev.tool.model.constant.IStaticDataEnum;

/**
 * <p>审批实例业务动作枚举</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 21:27
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum WorkflowBizActionEnum implements IStaticDataEnum<String> {

    /** 审批实例业务动作枚举 */
    MODIFY("MODIFY", "表示该审批实例是基于原来的实例修改而来", "MODIFY"),
    REVOKE("REVOKE", "表示该审批实例是由原来的实例撤销后重新发起的", "REVOKE"),
    NONE("NONE", "表示正常发起", "NONE");

    /** 编码 */
    private final String code;
    /** 名称 */
    private final String cnName;
    /** 值 */
    private final String value;
}
