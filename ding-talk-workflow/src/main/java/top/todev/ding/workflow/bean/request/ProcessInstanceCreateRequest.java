package top.todev.ding.workflow.bean.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;
import top.todev.ding.workflow.constant.data.WorkflowCopyPositionEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>发起审批实例请求实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 10:24
 * @since 0.0.1
  */
@Data
@Accessors(chain = true)
public class ProcessInstanceCreateRequest implements Serializable {
    private static final long serialVersionUID = 5158557501833028548L;

    /** 应用标识。可在开发者后台的应用详情页获取。注意：如果是第三方企业应用必须指定该参数。示例：41605932 */
    @JSONField(name = "agent_id")
    private Long agentId;
    /** 审批流的唯一码。process_code在审批流程编辑页面的URL中获取。示例：PROC-EF6YJL35P2xxxx */
    @JSONField(name = "process_code")
    private String processCode;
    /** 审批实例发起人的userid。示例：manager432 */
    @JSONField(name = "originator_user_id")
    private String originatorUserId;
    /** 发起人所在的部门，如果发起人属于根部门，传-1。示例：100 */
    @JSONField(name = "dept_id")
    private Long deptId;
    /** 审批人userid列表，最大列表长度20。多个审批人用逗号分隔，按传入的顺序依次审批。示例：manager01, manager02 */
    private String approvers;
    /** 审批人列表。支持会签/或签，优先级高于approvers变量。 */
    @JSONField(name = "approvers_v2")
    private List<ProcessInstanceApproverVO> approversV2;
    /** 抄送人userid列表。说明：该参数需要与approvers或approvers_v2参数一起传，抄送人才会生效。示例：user2,user3 */
    @JSONField(name = "cc_list")
    private String ccList;
    /** 在什么节点抄送给抄送人：START，FINISH，START_FINISHSTART */
    @JSONField(name = "cc_position")
    private WorkflowCopyPositionEnum ccPosition;
    /** 审批流表单参数，最大列表长度20。*/
    @JSONField(name = "form_component_values")
    private List<FormComponentValueVO> formComponentValues;

    public ProcessInstanceCreateRequest addFormComponentValue(FormComponentValueVO vo) {
        if (formComponentValues == null) {
            formComponentValues = new ArrayList<>();
        }
        formComponentValues.add(vo);
        return this;
    }
}
