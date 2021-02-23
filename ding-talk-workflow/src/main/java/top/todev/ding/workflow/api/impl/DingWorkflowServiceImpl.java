package top.todev.ding.workflow.api.impl;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import top.todev.ding.common.api.impl.DingServiceImpl;
import top.todev.ding.workflow.api.IDingWorkflowOfficialService;
import top.todev.ding.workflow.api.IDingWorkflowService;

/**
 * <p>钉钉开放平台企业应用接口实现</p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-14 16:53
 * @since 0.0.1
 */
@Slf4j
public class DingWorkflowServiceImpl extends DingServiceImpl implements IDingWorkflowService {

    @Getter
    private final IDingWorkflowOfficialService workflowOfficialService;

    public DingWorkflowServiceImpl() {
        this.workflowOfficialService = new DingWorkflowOfficialServiceImpl(this);
    }

}
