package top.todev.ding.workflow.boot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.todev.ding.common.bean.DingHostConfig;
import top.todev.ding.common.config.impl.DingDefaultConfigImpl;
import top.todev.ding.workflow.api.IDingWorkflowService;
import top.todev.ding.workflow.api.impl.DingWorkflowServiceImpl;
import top.todev.ding.workflow.boot.autoconfigure.DingTalkWorkflowConfigProperties;

/**
 * <p>
 * 钉钉企业应用工作流模块开发配置类
 * </p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/9/18 16:21
 * @since 0.0.1
 */
@Configuration
@EnableConfigurationProperties(value = {DingTalkWorkflowConfigProperties.class})
public class DingTalkWorkflowDefaultConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = DingTalkWorkflowConfigProperties.PREFIX, value = "app-key")
    public IDingWorkflowService dingOrgService(DingTalkWorkflowConfigProperties properties) {
        DingTalkWorkflowConfigProperties.HostConfig hostConfig = properties.getHost();

        DingHostConfig config = new DingHostConfig(hostConfig.getApi());
        DingDefaultConfigImpl storage = new DingDefaultConfigImpl();
        storage.setHostConfig(config);
        storage.setAppKey(properties.getAppKey());
        storage.setAppSecret(properties.getAppSecret());
        IDingWorkflowService service = new DingWorkflowServiceImpl();
        service.setDingOrgConfigStorage(storage);
        return service;
    }
}
