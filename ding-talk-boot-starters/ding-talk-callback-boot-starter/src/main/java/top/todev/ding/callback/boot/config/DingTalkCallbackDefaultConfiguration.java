package top.todev.ding.callback.boot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.todev.ding.callback.boot.autoconfigure.DingTalkCallbackConfigProperties;
import top.todev.ding.callback.exception.DingTalkEncryptException;
import top.todev.ding.callback.manager.IDingCallbackCryptoManager;
import top.todev.ding.callback.manager.impl.DingCallbackCryptoManagerImpl;

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
@EnableConfigurationProperties(value = {DingTalkCallbackConfigProperties.class})
public class DingTalkCallbackDefaultConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = DingTalkCallbackConfigProperties.PREFIX, value = "app-key")
    public IDingCallbackCryptoManager dingCallbackCryptoManager(DingTalkCallbackConfigProperties properties) throws DingTalkEncryptException {
        return new DingCallbackCryptoManagerImpl(properties.getEventToken(), properties.getEventAesKey(), properties.getAppKey());
    }
}
