package top.todev.ding.workflow.bean.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.todev.ding.common.bean.response.BaseDingTalkResponse;

import static top.todev.tool.model.constant.BaseErrorCodeEnum.ERROR_CODE_0;

/**
 * <p>获取审批实例详情响应实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 20:34
 * @since 0.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProcessInstanceGetResponse extends BaseDingTalkResponse<ProcessInstanceTopVO> {

    private static final long serialVersionUID = 8533064867000748524L;

    /** 请求ID。 */
    @JSONField(name = "request_id")
    private String requestId;

    /** 响应结果 */
    @JSONField(name = "process_instance")
    protected ProcessInstanceTopVO processInstance;

    @Override
    public ProcessInstanceTopVO getData() {
        return this.processInstance;
    }

    @Override
    public BaseDingTalkResponse<ProcessInstanceTopVO> initSuccess(ProcessInstanceTopVO processInstance) {
        this.errCode = ERROR_CODE_0.getValue();
        this.processInstance = processInstance;
        return this;
    }
}
