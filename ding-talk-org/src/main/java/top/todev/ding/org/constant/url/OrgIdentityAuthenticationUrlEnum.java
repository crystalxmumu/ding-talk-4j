package top.todev.ding.org.constant.url;

import cn.hutool.http.Method;
import lombok.AllArgsConstructor;
import lombok.Getter;
import top.todev.ding.common.constant.url.IDingTalkApiUrl;

import static top.todev.ding.common.bean.DingHostConfig.API_DEFAULT_HOST_URL;

/**
 * <p>身份认证枚举</p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 09:34
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum OrgIdentityAuthenticationUrlEnum implements IDingTalkApiUrl {

    /** 通过免登码获取用户信息 */
    USER_GET_USER_INFO(API_DEFAULT_HOST_URL, "/user/getuserinfo", Method.GET);

    private final String prefix;
    /**
     * 路径URI
     */
    private final String path;
    /** 接口请求方式 */
    private final Method method;
}
