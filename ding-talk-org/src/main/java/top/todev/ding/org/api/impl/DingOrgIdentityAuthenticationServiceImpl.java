package top.todev.ding.org.api.impl;

import lombok.NonNull;
import top.todev.ding.common.util.HttpExUtil;
import top.todev.ding.org.api.IDingOrgIdentityAuthenticationService;
import top.todev.ding.org.api.IDingOrgService;
import top.todev.ding.org.bean.request.v1.authentication.OapiUserGetUserInfoRequest;
import top.todev.ding.org.bean.response.v1.authentication.OapiUserGetUserInfoResponse;
import top.todev.ding.org.bean.response.v1.authentication.UserInfoBaseResponse;

import static top.todev.ding.org.constant.url.OrgIdentityAuthenticationUrlEnum.USER_GET_USER_INFO;

/**
 * <p>身份认证接口实现类</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 09:37
 * @since 0.0.1
 */
public class DingOrgIdentityAuthenticationServiceImpl extends DingOrgBaseServiceImpl implements IDingOrgIdentityAuthenticationService {

    public DingOrgIdentityAuthenticationServiceImpl(@NonNull IDingOrgService service) {
        super(service);
    }

    @Override
    public UserInfoBaseResponse getUserInfo(OapiUserGetUserInfoRequest request) {
        return HttpExUtil.getAndCheck(service, USER_GET_USER_INFO,
                request, OapiUserGetUserInfoResponse.class,
                false, true);
    }
}
