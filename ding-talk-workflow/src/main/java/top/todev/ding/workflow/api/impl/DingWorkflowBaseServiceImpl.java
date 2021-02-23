package top.todev.ding.workflow.api.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import top.todev.ding.workflow.api.IDingWorkflowService;

/**
 * <p>钉钉企业开发接口基础实现类</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-18 16:07
 * @since 0.0.1
 */
@Slf4j
public abstract class DingWorkflowBaseServiceImpl {

    /** 钉钉企业开发接口 */
    @NonNull
    protected IDingWorkflowService service;

    public DingWorkflowBaseServiceImpl(@NonNull IDingWorkflowService service) {
        this.service = service;
    }
}
