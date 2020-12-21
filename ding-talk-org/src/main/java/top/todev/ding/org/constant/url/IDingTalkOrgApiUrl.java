package top.todev.ding.org.constant.url;


import cn.hutool.http.Method;
import top.todev.ding.org.bean.DingOrgHostConfig;
import top.todev.ding.org.config.DingOrgConfigStorage;

import static top.todev.ding.org.bean.DingOrgHostConfig.buildUrl;

/**
 * <p>和风天气开发者 API 路径配置类</p>
 * @author 小飞猪
 * @since 0.0.1
 * @version 0.0.1
 */
public interface IDingTalkOrgApiUrl {

    /**
     * uri路径
     * @return path
     */
    String getPath();

    /**
     * url路径前缀
     * @return prefix
     */
    String getPrefix();

    /**
     * 接口请求方式
     * @return 接口请求方式
     */
    Method getMethod();

    /**
     * 获取API接口路径
     * @param config 路径配置类
     * @return API接口路径
     */
    default String getUrl(DingOrgConfigStorage config) {
        DingOrgHostConfig hostConfig = null;
        if (config != null) {
            hostConfig = config.getHostConfig();
        }
        return buildUrl(hostConfig, this.getPrefix(), this.getPath());
    }

}
