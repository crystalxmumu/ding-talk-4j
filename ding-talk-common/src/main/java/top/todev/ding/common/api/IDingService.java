package top.todev.ding.common.api;

import top.todev.ding.common.config.DingConfigStorage;
import top.todev.tool.model.exception.NotExceptException;

import java.util.Map;

/**
 * <p>钉钉开放平台通用接口</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-14 16:41
 * @since 0.0.1
 */
public interface IDingService {


    /**
     * 获取access_token, 不强制刷新access_token.
     * @return 访问token
     * @throws NotExceptException 钉钉接口异常
     * @see #getAccessToken(boolean) #getAccessToken(boolean)
     */
    String getAccessToken() throws NotExceptException;

    /**
     * <pre>
     * 获取access_token，本方法线程安全.
     * 且在多线程同时刷新时只刷新一次，避免每个IP调用开放平台所有接口总量，不能超过20秒3000次的调用次数上限
     * 另：本service的所有方法都会在access_token过期时调用此方法
     * 程序员在非必要情况下尽量不要主动调用此方法
     * 详情请见: https://ding-doc.dingtalk.com/document#/org-dev-guide/invocation-frequency-limit
     * </pre>
     * @param forceRefresh 是否强制刷新
     * @return 访问token
     * @throws NotExceptException 钉钉接口异常
     */
    String getAccessToken(boolean forceRefresh) throws NotExceptException;

    /**
     * DingOrgConfigStorage 对象.
     * @return 存储配置
     */
    DingConfigStorage getDingOrgConfigStorage();

    /**
     * 设置 {@link DingConfigStorage} 的实现. 兼容老版本
     * @param wxConfigProvider .
     */
    void setDingOrgConfigStorage(DingConfigStorage wxConfigProvider);

    /**
     * Map里 加入新的 {@link DingConfigStorage}，适用于动态添加新的微信公众号配置.
     *
     * @param appKey          应用ID
     * @param configStorage 新的微信配置
     */
    void addConfigStorage(String appKey, DingConfigStorage configStorage);

    /**
     * 从 Map中 移除 {@link String appKey} 所对应的 {@link DingConfigStorage}，适用于动态移除微信公众号配置.
     *
     * @param appKey 对应公众号的标识
     */
    void removeConfigStorage(String appKey);

    /**
     * 注入多个 {@link DingConfigStorage} 的实现. 并为每个 {@link DingConfigStorage} 赋予不同的 {@link String appKey} 值
     * 随机采用一个{@link String appKey}进行Http初始化操作
     *
     * @param configStorages DingOrgConfigStorage map
     */
    void setMultiConfigStorages(Map<String, DingConfigStorage> configStorages);

    /**
     * 注入多个 {@link DingConfigStorage} 的实现. 并为每个 {@link DingConfigStorage} 赋予不同的 {@link String label} 值
     *
     * @param configStorages DingOrgConfigStorage map
     * @param defaultappKey    设置一个{@link DingConfigStorage} 所对应的{@link String appKey}进行Http初始化
     */
    void setMultiConfigStorages(Map<String, DingConfigStorage> configStorages, String defaultappKey);

    /**
     * 进行相应的公众号切换.
     *
     * @param appKey 公众号标识
     * @return 切换是否成功 boolean
     */
    boolean switchover(String appKey);

    /**
     * 进行相应的公众号切换.
     *
     * @param appKey 公众号标识
     * @return 切换成功 ，则返回当前对象，方便链式调用，否则抛出异常
     */
    IDingService switchoverTo(String appKey);

}
