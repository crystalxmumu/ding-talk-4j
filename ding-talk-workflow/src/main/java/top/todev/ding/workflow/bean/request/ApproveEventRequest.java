package top.todev.ding.workflow.bean.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import top.todev.ding.common.constant.data.DingTalkEventTypeEnum;
import top.todev.ding.workflow.constant.data.WorkflowApproveInstanceTypeEnum;
import top.todev.ding.workflow.constant.data.WorkflowApproveResultEnum;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>审批事件请求实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-24 09:54
 * @since 0.0.1
 */
@Data
public class ApproveEventRequest implements Serializable {

    private static final long serialVersionUID = -3306088282724526042L;

    /** 事件类型。 */
    @JSONField(name = "EventType")
    private DingTalkEventTypeEnum eventType;
    /** 审批实例id。 */
    private String processInstanceId;
    /** 审批实例对应的企业。 */
    private String corpId;
    /** 实例创建时间。 */
    private LocalDateTime createTime;
    /** 审批结束时间。 */
    private LocalDateTime finishTime;
    /** 实例标题。 */
    private String title;
    /** 类型，type为start表示审批实例开始；finish：审批正常结束（同意或拒绝）；terminate：审批终止（发起人撤销审批单）； */
    private WorkflowApproveInstanceTypeEnum type;
    /** 发起审批实例的员工。 */
    private String staffId;
    /** 审批实例url，可在钉钉内跳转到审批页面。 */
    private String url;
    /** 正常结束时result为agree，拒绝时result为refuse，审批终止时没这个值。 */
    private WorkflowApproveResultEnum result;
    /** 审批模板的唯一码。 */
    private String processCode;
}
