package top.todev.ding.workflow.bean.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;
import top.todev.ding.workflow.constant.data.WorkflowOperationResultEnum;
import top.todev.ding.workflow.constant.data.WorkflowOperationTypeEnum;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>操作记录实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 21:00
 * @since 0.0.1
 */
@Data
@Accessors(chain = true)
public class OperationRecordsVO implements Serializable {
    private static final long serialVersionUID = 6860676854149944947L;

    /** 操作人userid。示例：manager1。 */
    private String userid;
    /** 操作时间。示例：2020-09-05 16:48:30。 */
    private LocalDateTime date;
    /** 操作类型：EXECUTE_TASK_NORMAL：正常执行任务；EXECUTE_TASK_AGENT：代理人执行任务；APPEND_TASK_BEFORE：前加签任务；APPEND_TASK_AFTER：后加签任务；REDIRECT_TASK：转交任务；START_PROCESS_INSTANCE：发起流程实例；TERMINATE_PROCESS_INSTANCE：终止(撤销)流程实例；FINISH_PROCESS_INSTANCE：结束流程实例；ADD_REMARK：添加评论；redirect_process：审批退回；示例：EXECUTE_TASK_NORMAL。 */
    @JSONField(name = "operation_type")
    private WorkflowOperationTypeEnum operationType;
    /** 操作结果：AGREE：同意；REFUSE：拒绝；NONE示例：AGREE。 */
    @JSONField(name = "operation_result")
    private WorkflowOperationResultEnum operationResult;
    /** 评论内容。审批操作附带评论时才返回该字段。示例：评论。 */
    private String remark;
    /** 评论附件。示例：。 */
    @JSONField(name = "attachments")
    private List<AttachmentVO> attachments;
}
