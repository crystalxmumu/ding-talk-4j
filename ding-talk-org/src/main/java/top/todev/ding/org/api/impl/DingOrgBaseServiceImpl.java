package top.todev.ding.org.api.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import top.todev.ding.org.api.IDingOrgService;

/**
 * <p>钉钉企业开发接口基础实现类</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-18 16:07
 * @since 0.0.1
 */
@Slf4j
public abstract class DingOrgBaseServiceImpl {

    /** 钉钉企业开发接口 */
    @NonNull
    protected IDingOrgService service;

    public DingOrgBaseServiceImpl(@NonNull IDingOrgService service) {
        this.service = service;
    }
}
