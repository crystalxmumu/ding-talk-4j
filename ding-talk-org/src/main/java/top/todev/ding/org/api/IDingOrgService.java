package top.todev.ding.org.api;

import top.todev.ding.common.api.IDingService;

/**
 * <p>钉钉开发平台企业应用接口</p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-14 16:42
 * @since 0.0.1
 */
public interface IDingOrgService extends IDingService {


    /**
     * <p>获取身份认证接口</p>
     * @return 身份认证接口
     * @author 小飞猪
     * @date 2020/12/24 9:40
     * @since 0.0.1
     */
    IDingOrgIdentityAuthenticationService getIdentityAuthenticationService();

    /**
     * <p>获取部门管理V2接口/p>
     * @return 部门管理V2接口
     * @author 小飞猪
     * @date 2020/12/18 16:52
     * @since 0.0.1
     */
    IDingOrgDepartmentManagementV2Service getDepartmentManagementV2Service();

    /**
     * <p>获取用户管理V2服务接口</p>
     * @return top.todev.ding.org.api.IDingOrgUserManagementV2Service
     * @author 小飞猪
     * @date 2020/12/24 10:27
     * @since 0.0.1
     */
    IDingOrgUserManagementV2Service getUserManagementV2Service();

    /**
     * <p>获取日志管理服务接口</p>
     * @return 日志管理服务接口
     * @author 小飞猪
     * @date 2020/12/21 16:28
     * @since 0.0.1
     */
    IDingOrgReportManagementService getReportManagementService();


}
