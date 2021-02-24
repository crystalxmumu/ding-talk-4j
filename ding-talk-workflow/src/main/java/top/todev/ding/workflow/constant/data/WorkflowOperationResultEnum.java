package top.todev.ding.workflow.constant.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.todev.tool.model.constant.IStaticDataEnum;

/**
 * <p>审批操作结果枚举</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 21:27
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum WorkflowOperationResultEnum implements IStaticDataEnum<String> {

    /** 审批操作结果枚举 */
    AGREE("AGREE", "同意", "AGREE"),
    REFUSE("REFUSE", "拒绝", "REFUSE"),
    NONE("NONE", "无", "NONE");

    /** 编码 */
    private final String code;
    /** 名称 */
    private final String cnName;
    /** 值 */
    private final String value;
}
