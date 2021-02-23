package top.todev.ding.workflow.api.impl;

import lombok.NonNull;
import top.todev.ding.common.util.HttpExUtil;
import top.todev.ding.workflow.api.IDingWorkflowOfficialService;
import top.todev.ding.workflow.api.IDingWorkflowService;
import top.todev.ding.workflow.bean.request.ProcessInstanceCreateRequest;
import top.todev.ding.workflow.bean.request.ProcessInstanceGetRequest;
import top.todev.ding.workflow.bean.response.ProcessInstanceCreateResponse;
import top.todev.ding.workflow.bean.response.ProcessInstanceGetResponse;
import top.todev.ding.workflow.bean.response.ProcessInstanceTopVO;
import top.todev.tool.model.exception.NotExceptException;

import static top.todev.ding.workflow.constant.url.OfficialWorkflowUrlEnum.PROCESS_INSTANCE_CREATE;
import static top.todev.ding.workflow.constant.url.OfficialWorkflowUrlEnum.PROCESS_INSTANCE_GET;

/**
 * <p>钉钉官方工作流实现类</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 15:43
 * @since 0.0.1
 */
public class DingWorkflowOfficialServiceImpl extends DingWorkflowBaseServiceImpl implements IDingWorkflowOfficialService {

    public DingWorkflowOfficialServiceImpl(@NonNull IDingWorkflowService service) {
        super(service);
    }

    @Override
    public ProcessInstanceCreateResponse instanceCreate(ProcessInstanceCreateRequest request) throws NotExceptException {
        return HttpExUtil.getAndCheck(service, PROCESS_INSTANCE_CREATE,
                request, ProcessInstanceCreateResponse.class,
                false, true, false);
    }

    @Override
    public ProcessInstanceTopVO instanceGet(ProcessInstanceGetRequest request) throws NotExceptException {
        return HttpExUtil.getAndCheck(service, PROCESS_INSTANCE_GET,
                request, ProcessInstanceGetResponse.class,
                false, true, false);
    }
}
