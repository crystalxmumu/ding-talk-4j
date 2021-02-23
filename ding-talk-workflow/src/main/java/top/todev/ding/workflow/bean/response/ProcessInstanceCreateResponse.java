package top.todev.ding.workflow.bean.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.todev.ding.common.bean.response.BaseDingTalkResponse;
import top.todev.tool.model.bean.IResultResponse;

import java.io.Serializable;

/**
 * <p>发起审批实例响应实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 11:25
 * @since 0.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProcessInstanceCreateResponse extends BaseDingTalkResponse<ProcessInstanceCreateResponse> implements Serializable {
    private static final long serialVersionUID = -6412330250554566868L;

    /** 请求ID。rj8u1oqx0hi6*/
    @JSONField(name = "request_id")
    private String requestId;
    /** 审批实例ID。7fc61e3e-7282-xxxx*/
    @JSONField(name = "process_instance_id")
    private String processInstanceId;

    @Override
    public ProcessInstanceCreateResponse getData() {
        return this;
    }

    @Override
    public IResultResponse<ProcessInstanceCreateResponse> initSuccess(ProcessInstanceCreateResponse response) {
        this.requestId = response.requestId;
        this.processInstanceId = response.processInstanceId;
        return this;
    }
}
