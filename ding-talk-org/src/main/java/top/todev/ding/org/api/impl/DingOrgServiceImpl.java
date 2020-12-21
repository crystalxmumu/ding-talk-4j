package top.todev.ding.org.api.impl;

import cn.hutool.core.map.MapUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import top.todev.ding.common.bean.DingAccessToken;
import top.todev.ding.common.bean.request.token.ObtainAccessTokenRequest;
import top.todev.ding.common.bean.response.token.ObtainAccessTokenResponse;
import top.todev.ding.common.error.DingErrorException;
import top.todev.ding.common.error.DingRuntimeException;
import top.todev.ding.org.api.IDingOrgDepartmentManagementV2Service;
import top.todev.ding.org.api.IDingOrgReportManagementService;
import top.todev.ding.org.api.IDingOrgService;
import top.todev.ding.org.config.DingOrgConfigStorage;
import top.todev.ding.org.util.DingOrgConfigStorageHolder;
import top.todev.ding.org.util.OrgHttpExUtil;
import top.todev.tool.model.exception.NotExceptException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import static top.todev.ding.org.constant.url.OrgObtainAccessTokenUrlEnum.CERT_GET_TOKEN;
import static top.todev.tool.model.constant.BaseErrorCodeEnum.ERROR_CODE_999903;

/**
 * <p>钉钉开放平台企业应用接口实现</p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-14 16:53
 * @since 0.0.1
 */
@Slf4j
public class DingOrgServiceImpl implements IDingOrgService {


    private Map<String, DingOrgConfigStorage> configStorageMap;
    @Getter
    private final IDingOrgDepartmentManagementV2Service departmentManagementV2Service;
    @Getter
    private final IDingOrgReportManagementService reportManagementService;

    public DingOrgServiceImpl() {
        this.departmentManagementV2Service = new DingOrgDepartmentManagementV2ServiceImpl(this);
        this.reportManagementService = new DingOrgReportManagementServiceImpl(this);
    }

    @Override
    public String getAccessToken() throws NotExceptException {
        return getAccessToken(false);
    }

    @Override
    public String getAccessToken(boolean forceRefresh) throws NotExceptException {
        final DingOrgConfigStorage config = this.getDingOrgConfigStorage();
        if (!config.isAccessTokenExpired() && !forceRefresh) {
            return config.getAccessToken();
        }

        Lock lock = config.getAccessTokenLock();
        boolean locked = false;
        try {
            do {
                locked = lock.tryLock(100, TimeUnit.MILLISECONDS);
                if (!forceRefresh && !config.isAccessTokenExpired()) {
                    return config.getAccessToken();
                }
            } while (!locked);
            ObtainAccessTokenRequest request = new ObtainAccessTokenRequest(config.getAppKey(), config.getAppSecret());
            DingAccessToken token = OrgHttpExUtil.getAndCheck(this, CERT_GET_TOKEN,
                    request, ObtainAccessTokenResponse.class, false, false);
            config.updateAccessToken(token);
            return token.getAccessToken();
        } catch (InterruptedException e) {
            log.warn("获取Token时锁被中断错误", e);
            throw new NotExceptException(ERROR_CODE_999903);
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
    }

    @Override
    public DingOrgConfigStorage getDingOrgConfigStorage() {
        if (this.configStorageMap.size() == 1) {
            // 只有一个应用，直接返回其配置即可
            return this.configStorageMap.values().iterator().next();
        }

        return this.configStorageMap.get(DingOrgConfigStorageHolder.get());
    }

    @Override
    public void setDingOrgConfigStorage(DingOrgConfigStorage wxConfigProvider) {
        final String defaultAppKey = wxConfigProvider.getAppKey();
        this.setMultiConfigStorages(MapUtil.of(defaultAppKey, wxConfigProvider), defaultAppKey);
    }

    @Override
    public void setMultiConfigStorages(Map<String, DingOrgConfigStorage> configStorages) {
        this.setMultiConfigStorages(configStorages, configStorages.keySet().iterator().next());
    }

    @Override
    public void setMultiConfigStorages(Map<String, DingOrgConfigStorage> configStorages, String defaultAppKey) {
        this.configStorageMap = new HashMap<>(configStorages);
        DingOrgConfigStorageHolder.set(defaultAppKey);
    }

    @Override
    public void addConfigStorage(String appKey, DingOrgConfigStorage configStorage) {
        synchronized (this) {
            if (this.configStorageMap == null) {
                this.setDingOrgConfigStorage(configStorage);
            } else {
                this.configStorageMap.put(appKey, configStorage);
            }
        }
    }

    @Override
    public void removeConfigStorage(String appKey) {
        synchronized (this) {
            if (this.configStorageMap.size() == 1) {
                this.configStorageMap.remove(appKey);
                log.warn("已删除最后一个应用配置：{}，须立即使用setDingOrgConfigStorage或setMultiConfigStorages添加配置", appKey);
                return;
            }
            if (DingOrgConfigStorageHolder.get().equals(appKey)) {
                this.configStorageMap.remove(appKey);
                final String defaultAppKey = this.configStorageMap.keySet().iterator().next();
                DingOrgConfigStorageHolder.set(defaultAppKey);
                log.warn("已删除默认应用配置，应用【{}】被设为默认配置", defaultAppKey);
                return;
            }
            this.configStorageMap.remove(appKey);
        }
    }

    @Override
    public IDingOrgService switchoverTo(String appKey) {
        if (this.configStorageMap.containsKey(appKey)) {
            DingOrgConfigStorageHolder.set(appKey);
            return this;
        }

        throw new DingRuntimeException(String.format("无法找到对应【%s】的应用配置信息，请核实！", appKey));
    }

    @Override
    public boolean switchover(String appKey) {
        if (this.configStorageMap.containsKey(appKey)) {
            DingOrgConfigStorageHolder.set(appKey);
            return true;
        }

        log.error("无法找到对应【{}】的应用配置信息，请核实！", appKey);
        return false;
    }
}
