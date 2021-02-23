package top.todev.ding.common.constant.url;


import cn.hutool.http.Method;
import top.todev.ding.common.bean.DingHostConfig;
import top.todev.ding.common.config.DingConfigStorage;

import static top.todev.ding.common.bean.DingHostConfig.buildUrl;

/**
 * <p>钉钉开放平台 API 路径配置类</p>
 * @author 小飞猪
 * @since 0.0.1
 * @version 0.0.1
 */
public interface IDingTalkApiUrl {

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
    default String getUrl(DingConfigStorage config) {
        DingHostConfig hostConfig = null;
        if (config != null) {
            hostConfig = config.getHostConfig();
        }
        return buildUrl(hostConfig, this.getPrefix(), this.getPath());
    }

}
