package top.todev.ding.workflow.constant.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.todev.tool.model.constant.IStaticDataEnum;

/**
 * <p>任务状态枚举</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 21:27
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum WorkflowTaskStatusEnum implements IStaticDataEnum<String> {

    /** 任务状态枚举 */
    NEW("NEW", "未启动", "NEW"),
    RUNNING("RUNNING", "处理中", "RUNNING"),
    PAUSED("PAUSED", "暂停", "PAUSED"),
    CANCELED("CANCELED", "取消", "CANCELED"),
    COMPLETED("COMPLETED", "完成", "COMPLETED"),
    TERMINATED("TERMINATED", "终止", "TERMINATED");

    /** 编码 */
    private final String code;
    /** 名称 */
    private final String cnName;
    /** 值 */
    private final String value;
}
