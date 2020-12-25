package top.todev.ding.org.api;

import top.todev.ding.org.bean.request.v1.authentication.OapiUserGetUserInfoRequest;
import top.todev.ding.org.bean.response.v1.authentication.UserInfoBaseResponse;

/**
 * <p>身份认证接口</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 08:24
 * @since 0.0.1
 */
public interface IDingOrgIdentityAuthenticationService {

    /**
     * <p>通过免登码获取用户信息。
     * 在第三方企业应用免登和企业内部应用免登场景中，开发者需要使用本接口通过access_token和免登 接口中获取的code来获取用户userid。
     * </p>
     * @param request 请求参数
     * @return 用户信息
     * @author 小飞猪
     * @date 2020/12/24 9:32
     * @since 0.0.1
     */
    UserInfoBaseResponse getUserInfo(OapiUserGetUserInfoRequest request);
}
