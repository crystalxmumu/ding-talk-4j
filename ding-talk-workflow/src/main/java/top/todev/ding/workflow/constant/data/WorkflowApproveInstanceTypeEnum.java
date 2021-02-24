package top.todev.ding.workflow.constant.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.todev.tool.model.constant.IStaticDataEnum;

/**
 * <p>审批实例类型枚举</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 21:27
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum WorkflowApproveInstanceTypeEnum implements IStaticDataEnum<String> {

    /** 审批结果枚举 */
    start("start", "审批实例开始", "start"),
    finish("finish", "审批正常结束（同意或拒绝）", "finish"),
    terminate("terminate", "审批终止（发起人撤销审批单）", "terminate");

    /** 编码 */
    private final String code;
    /** 名称 */
    private final String cnName;
    /** 值 */
    private final String value;
}
