package top.todev.ding.common.config.impl;

import lombok.Data;
import top.todev.ding.common.bean.DingAccessToken;
import top.todev.ding.common.bean.DingHostConfig;
import top.todev.ding.common.config.DingConfigStorage;

import java.io.File;
import java.io.Serializable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>钉钉企业开发缺省配置存储实现</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-14 16:29
 * @since 0.0.1
 */
@Data
public class DingDefaultConfigImpl implements DingConfigStorage, Serializable {

    private static final long serialVersionUID = 5461401128010913930L;
    /** 接口配置实例 */
    private DingHostConfig hostConfig = null;
    /** 应用key */
    protected volatile String appKey;
    /** 应用密码 */
    protected volatile String appSecret;
    /** 事件订阅加密AesKey */
    protected volatile String eventAesKey;
    /** 事件订阅签名Token */
    protected volatile String eventToken;
    /** 访问凭证 */
    protected volatile String accessToken;
    /** 失效时间(毫秒) */
    protected volatile long expiresTime;

    /** 凭证锁 */
    protected volatile Lock accessTokenLock = new ReentrantLock();

    /** 临时文件目录 */
    protected volatile File tmpDirFile;

    @Override
    public Boolean isAccessTokenExpired() {
        return System.currentTimeMillis() > this.expiresTime;
    }

    @Override
    public synchronized void updateAccessToken(DingAccessToken accessToken) {
        updateAccessToken(accessToken.getAccessToken(), accessToken.getExpiresIn());
    }

    @Override
    public synchronized void updateAccessToken(String accessToken, int expiresInSeconds) {
        this.accessToken = accessToken;
        this.expiresTime = System.currentTimeMillis() + (expiresInSeconds - 200) * 1000L;
    }

    @Override
    public void expireAccessToken() {
        this.expiresTime = 0;
    }

    @Override
    public boolean autoRefreshToken() {
        return true;
    }
}
