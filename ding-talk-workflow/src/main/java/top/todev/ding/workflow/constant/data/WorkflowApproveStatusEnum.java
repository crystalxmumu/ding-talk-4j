package top.todev.ding.workflow.constant.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.todev.tool.model.constant.IStaticDataEnum;

/**
 * <p>审批状态枚举</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 21:27
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum WorkflowApproveStatusEnum implements IStaticDataEnum<String> {

    /** 审批状态枚举 */
    NEW("NEW", "新创建", "NEW"),
    RUNNING("RUNNING", "审批中", "RUNNING"),
    TERMINATED("TERMINATED", "被终止", "TERMINATED"),
    COMPLETED("COMPLETED", "完成", "COMPLETED"),
    CANCELED("CANCELED", "取消", "CANCELED");

    /** 编码 */
    private final String code;
    /** 名称 */
    private final String cnName;
    /** 值 */
    private final String value;
}
