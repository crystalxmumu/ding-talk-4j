package top.todev.ding.common.constant.url;

import cn.hutool.http.Method;
import lombok.AllArgsConstructor;
import lombok.Getter;
import top.todev.ding.common.constant.url.IDingTalkApiUrl;

import static top.todev.ding.common.bean.DingHostConfig.API_DEFAULT_HOST_URL;

/**
 * <p>获取凭证接口Url枚举</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-15 09:44
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum ObtainAccessTokenUrlEnum implements IDingTalkApiUrl {

    /** 获取access_token */
    CERT_GET_TOKEN(API_DEFAULT_HOST_URL, "/gettoken", Method.GET),
    /** 获取企业授权凭证 */
    CERT_GET_CORP_TOKEN(API_DEFAULT_HOST_URL, "/service/get_corp_token", Method.GET),
    /** 获取jsapi_ticket */
    CERT_GET_JSAPI_TICKET(API_DEFAULT_HOST_URL, "/get_jsapi_ticket", Method.GET),
    /** 获取微应用后台免登的SsoToken */
    CERT_SSO_GET_TOKEN(API_DEFAULT_HOST_URL, "/sso/gettoken", Method.GET)
    ;

    private final String prefix;
    /**
     * 路径URI
     */
    private final String path;
    /** 接口请求方式 */
    private final Method method;
}
