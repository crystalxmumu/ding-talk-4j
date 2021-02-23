package top.todev.ding.org.api.impl;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import top.todev.ding.common.api.impl.DingServiceImpl;
import top.todev.ding.org.api.*;

/**
 * <p>钉钉开放平台企业应用接口实现</p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-14 16:53
 * @since 0.0.1
 */
@Slf4j
public class DingOrgServiceImpl extends DingServiceImpl implements IDingOrgService {

    @Getter
    private final IDingOrgIdentityAuthenticationService identityAuthenticationService;
    @Getter
    private final IDingOrgDepartmentManagementV2Service departmentManagementV2Service;
    @Getter
    private final IDingOrgUserManagementV2Service userManagementV2Service;
    @Getter
    private final IDingOrgReportManagementService reportManagementService;

    public DingOrgServiceImpl() {
        this.identityAuthenticationService = new DingOrgIdentityAuthenticationServiceImpl(this);
        this.departmentManagementV2Service = new DingOrgDepartmentManagementV2ServiceImpl(this);
        this.userManagementV2Service = new DingOrgUserManagementV2ServiceImpl(this);
        this.reportManagementService = new DingOrgReportManagementServiceImpl(this);
    }

}
