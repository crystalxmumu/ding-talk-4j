package top.todev.ding.workflow.bean.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;
import top.todev.ding.workflow.constant.data.WorkflowTaskResultEnum;
import top.todev.ding.workflow.constant.data.WorkflowTaskStatusEnum;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>任务实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 21:05
 * @since 0.0.1
 */
@Data
@Accessors(chain = true)
public class TaskTopVO implements Serializable {
    private static final long serialVersionUID = 8528353836054163327L;

    /** 任务处理人。示例：manager1。 */
    private String userid;
    /** 任务状态：NEW：未启动；RUNNING：处理中；PAUSED：暂停；CANCELED：取消；COMPLETED：完成；TERMINATED：终止。示例：NEW。 */
    @JSONField(name = "task_status")
    private WorkflowTaskStatusEnum taskStatus;
    /** 结果：AGREE：同意；REFUSE：拒绝；REDIRECTED：转交；示例：REDIRECTED。 */
    @JSONField(name = "task_result")
    private WorkflowTaskResultEnum taskResult;
    /** 开始时间。示例：1497249913000。 */
    @JSONField(name = "create_time")
    private LocalDateTime createTime;
    /** 结束时间。示例：1497249913000。 */
    @JSONField(name = "finish_time")
    private LocalDateTime finishTime;
    /** 任务节点ID。示例：1497249。 */
    private String taskid;
    /** 任务URL。示例：https://www.xxxx.com。 */
    private String url;
}
