package top.todev.ding.workflow.constant.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.todev.tool.model.constant.IStaticDataEnum;

/**
 * <p>审批操作类型枚举</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 21:27
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum WorkflowOperationTypeEnum implements IStaticDataEnum<String> {

    /** 审批操作类型枚举 */
    EXECUTE_TASK_NORMAL("EXECUTE_TASK_NORMAL", "正常执行任务", "EXECUTE_TASK_NORMAL"),
    EXECUTE_TASK_AGENT("EXECUTE_TASK_AGENT", "代理人执行任务", "EXECUTE_TASK_AGENT"),
    APPEND_TASK_BEFORE("APPEND_TASK_BEFORE", "前加签任务", "APPEND_TASK_BEFORE"),
    APPEND_TASK_AFTER("APPEND_TASK_AFTER", "后加签任务", "APPEND_TASK_AFTER"),
    REDIRECT_TASK("REDIRECT_TASK", "转交任务", "REDIRECT_TASK"),
    START_PROCESS_INSTANCE("START_PROCESS_INSTANCE", "发起流程实例", "START_PROCESS_INSTANCE"),
    TERMINATE_PROCESS_INSTANCE("TERMINATE_PROCESS_INSTANCE", "终止(撤销)流程实例", "TERMINATE_PROCESS_INSTANCE"),
    FINISH_PROCESS_INSTANCE("FINISH_PROCESS_INSTANCE", "结束流程实例", "FINISH_PROCESS_INSTANCE"),
    ADD_REMARK("ADD_REMARK", "添加评论", "ADD_REMARK"),
    redirect_process("redirect_process", "审批退回", "redirect_process");

    /** 编码 */
    private final String code;
    /** 名称 */
    private final String cnName;
    /** 值 */
    private final String value;
}
