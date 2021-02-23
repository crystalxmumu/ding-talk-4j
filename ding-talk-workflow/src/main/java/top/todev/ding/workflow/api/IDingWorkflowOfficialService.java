package top.todev.ding.workflow.api;

import top.todev.ding.workflow.bean.request.ProcessInstanceCreateRequest;
import top.todev.ding.workflow.bean.request.ProcessInstanceGetRequest;
import top.todev.ding.workflow.bean.response.ProcessInstanceCreateResponse;
import top.todev.ding.workflow.bean.response.ProcessInstanceTopVO;
import top.todev.tool.model.exception.NotExceptException;

/**
 * <p>钉钉智能官方工作流接口</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 15:41
 * @since 0.0.1
 */
public interface IDingWorkflowOfficialService {

    /**
     * <p><a href="https://developers.dingtalk.com/document/app/initiate-approval">发起审批实例</a></p>
     * @param request 请求
     * @return 发起结果
     * @throws NotExceptException 不期望发生的异常
     * @author 小飞猪
     * @date 2021/2/23 16:41
     * @since 0.0.1
     */
    ProcessInstanceCreateResponse instanceCreate(ProcessInstanceCreateRequest request) throws NotExceptException;

    /**
     * <p><a href="https://developers.dingtalk.com/document/app/obtains-the-details-of-a-single-approval-instance">获取审批实例详情</a></p>
     * @param request 请求
     * @return 实例详情
     * @throws NotExceptException 不期望发生的异常
     * @author 小飞猪
     * @date 2021/2/23 21:18
     * @since 0.0.1
     */
    ProcessInstanceTopVO instanceGet(ProcessInstanceGetRequest request) throws NotExceptException;
}
