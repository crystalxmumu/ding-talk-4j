package top.todev.ding.common.config;

import top.todev.ding.common.bean.DingAccessToken;
import top.todev.ding.common.bean.DingHostConfig;

import java.io.File;
import java.util.concurrent.locks.Lock;

/**
 * <p>钉钉企业开发配置存储接口</p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-14 16:13
 * @since 0.0.1
 */
public interface DingConfigStorage {

    /**
     * Gets access token.
     *
     * @return the access token
     */
    String getAccessToken();

    /**
     * Gets access token lock.
     *
     * @return the access token lock
     */
    Lock getAccessTokenLock();

    /**
     * Is access token expired boolean.
     *
     * @return the boolean
     */
    Boolean isAccessTokenExpired();

    /**
     * 强制将access token过期掉.
     */
    void expireAccessToken();

    /**
     * 应该是线程安全的.
     *
     * @param accessToken 要更新的WxAccessToken对象
     */
    void updateAccessToken(DingAccessToken accessToken);

    /**
     * 应该是线程安全的.
     * @param accessToken      新的accessToken值
     * @param expiresInSeconds 过期时间，以秒为单位
     */
    void updateAccessToken(String accessToken, int expiresInSeconds);

    /**
     * 获取AppKey.
     * @return AppKey
     */
    String getAppKey();

    /**
     * 获取 AppSecret.
     * @return AppSecret
     */
    String getAppSecret();

    /**
     * 获取事件订阅加密AesKey
     * @return 事件订阅加密AesKey
     */
    String getEventAesKey();

    /**
     * 获取事件订阅签名Token
     * @return 事件订阅签名Token
     */
    String getEventToken();

    /**
     * Gets tmp dir file.
     * @return the tmp dir file
     */
    File getTmpDirFile();

    /**
     * 是否自动刷新token.
     *
     * @return the boolean
     */
    boolean autoRefreshToken();

    /**
     * 得到钉钉接口地址域名部分的自定义设置信息.
     * @return the host config
     */
    DingHostConfig getHostConfig();

    /**
     * 设置钉钉接口地址域名部分的自定义设置信息.
     * @param hostConfig host config
     */
    void setHostConfig(DingHostConfig hostConfig);
}
