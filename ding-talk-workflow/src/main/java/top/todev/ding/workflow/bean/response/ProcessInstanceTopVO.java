package top.todev.ding.workflow.bean.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;
import top.todev.ding.workflow.bean.request.FormComponentValueVO;
import top.todev.ding.workflow.constant.data.WorkflowApproveResultEnum;
import top.todev.ding.workflow.constant.data.WorkflowApproveStatusEnum;
import top.todev.ding.workflow.constant.data.WorkflowBizActionEnum;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>审批实例详情实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 20:35
 * @since 0.0.1
 */
@Data
@Accessors(chain = true)
public class ProcessInstanceTopVO implements Serializable {

    private static final long serialVersionUID = 3361923106118318505L;

    /** 审批实例标题。示例：xx提交的请假申请。 */
    private String title;
    /** 开始时间。示例：2020-09-05 16:48:30。 */
    @JSONField(name = "create_time")
    private LocalDateTime createTime;
    /** 结束时间。示例：2020-09-05 16:48:30。 */
    @JSONField(name = "finish_time")
    private LocalDateTime finishTime;
    /** 发起人的userid。示例：manager1。 */
    @JSONField(name = "originator_userid")
    private String originatorUserid;
    /** 发起人的部门。-1表示根部门。示例：-1。 */
    @JSONField(name = "originator_dept_id")
    private String originatorDeptId;
    /** 审批状态：NEW：新创建；RUNNING：审批中；TERMINATED：被终止；COMPLETED：完成；CANCELED：取消；示例：NEW。 */
    private WorkflowApproveStatusEnum status;
    /** 审批人userid。示例：manager1。 */
    @JSONField(name = "approver_userids")
    private List<String> approverUserids;
    /** 抄送人userid。示例：["manager1"]。 */
    @JSONField(name = "cc_userids")
    private List<String> ccUserids;
    /** 审批结果：agree：同意；refuse：拒绝；示例：agree。 */
    @JSONField(name = "result")
    private WorkflowApproveResultEnum result;
    /** 审批实例业务编号。示例：2017111111。 */
    @JSONField(name = "business_id")
    private String businessId;
    /** 操作记录列表。示例：。 */
    @JSONField(name = "operation_records")
    private List<OperationRecordsVO> operationRecords;
    /** 任务列表。示例：。 */
    private List<TaskTopVO> tasks;

    /** 发起部门。示例：测试。 */
    @JSONField(name = "originator_dept_name")
    private String originatorDeptName;
    /** 审批实例业务动作：MODIFY：表示该审批实例是基于原来的实例修改而来；REVOKE：表示该审批实例是由原来的实例撤销后重新发起的；NONE表示正常发起示例：MODIFY。 */
    @JSONField(name = "biz_action")
    private WorkflowBizActionEnum bizAction;
    /** 审批附属实例列表，当已经通过的审批实例被修改或撤销，会生成一个新的实例，作为原有审批实例的附属。如果想知道当前已经通过的审批实例的状态，可以依次遍历它的附属列表，查询里面每个实例的biz_action。示例：["instance1","instance2"]。 */
    @JSONField(name = "attached_process_instance_ids")
    private List<String> attachedProcessInstanceIds;
    /** 表单详情列表。示例：。 */
    @JSONField(name = "form_component_values")
    private List<FormComponentValueVO> formComponentValues;
    /** 主流程实例标识。示例：instance。 */
    @JSONField(name = "main_process_instance_id")
    private String mainProcessInstanceId;


}
