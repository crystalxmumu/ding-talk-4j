package top.todev.ding.org.boot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.todev.ding.org.api.IDingOrgService;
import top.todev.ding.org.api.impl.DingOrgServiceImpl;
import top.todev.ding.org.bean.DingOrgHostConfig;
import top.todev.ding.org.boot.autoconfigure.DingTalkOrgConfigProperties;
import top.todev.ding.org.config.impl.DingOrgDefaultConfigImpl;

/**
 * <p>
 * 钉钉企业应用开发配置类
 * </p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/9/18 16:21
 * @since 0.0.1
 */
@Configuration
@EnableConfigurationProperties(value = {DingTalkOrgConfigProperties.class})
public class DingTalkOrgDefaultConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = DingTalkOrgConfigProperties.PREFIX, value = "appKey")
    public IDingOrgService dingOrgService(DingTalkOrgConfigProperties properties) {
        DingTalkOrgConfigProperties.HostConfig hostConfig = properties.getHost();

        DingOrgHostConfig config = new DingOrgHostConfig(hostConfig.getApi());
        DingOrgDefaultConfigImpl storage = new DingOrgDefaultConfigImpl();
        storage.setHostConfig(config);
        storage.setAppKey(properties.getAppKey());
        storage.setAppSecret(properties.getAppSecret());
        IDingOrgService service = new DingOrgServiceImpl();
        service.setDingOrgConfigStorage(storage);
        return service;
    }
}
