package top.todev.ding.workflow.api;

import top.todev.ding.common.api.IDingService;

/**
 * <p>钉钉智能工作流接口</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 15:40
 * @since 0.0.1
 */
public interface IDingWorkflowService extends IDingService {

    /**
     * <p>获取官方工作流接口</p>
     * @return 官方工作流接口
     * @author 小飞猪
     * @date 2021/2/23 15:43
     * @since 0.0.1
     */
    IDingWorkflowOfficialService getWorkflowOfficialService();
}
