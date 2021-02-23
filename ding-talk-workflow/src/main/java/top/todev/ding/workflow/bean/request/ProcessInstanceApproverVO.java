package top.todev.ding.workflow.bean.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import top.todev.ding.workflow.constant.data.WorkflowTaskActionTypeEnum;

import java.io.Serializable;
import java.util.List;

/**
 * <p>审批示例审批人实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 11:13
 * @since 0.0.1
 */
@Data
public class ProcessInstanceApproverVO implements Serializable {
    private static final long serialVersionUID = 1966000456285420741L;

    /** 审批类型：会签AND；或签：OR；单人：NONE。示例：AND */
    @JSONField(name = "task_action_type")
    private WorkflowTaskActionTypeEnum taskActionType;
    /** 审批人userid列表：会签/或签列表长度必须大于1；非会签/或签列表长度只能为1[]。示例：user1,user2 */
    @JSONField(name = "user_ids")
    private List<String> userIds;
}
