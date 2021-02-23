package top.todev.ding.org.boot.autoconfigure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

import static top.todev.ding.common.bean.DingHostConfig.API_DEFAULT_HOST_URL;


/**
 * <p>
 * 钉钉企业应用开发全局配置实体类
 * </p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/9/18 15:18
 * @since 0.0.1
 */
@Data
@ConfigurationProperties(prefix = DingTalkOrgConfigProperties.PREFIX)
public class DingTalkOrgConfigProperties implements Serializable {

    public static final String PREFIX = "ding.talk.org";
    private static final long serialVersionUID = 347205603966727884L;

    /** 应用key */
    private String appKey;
    /** 应用密码 */
    private String appSecret;
    /** 接口路径配置类 */
    private HostConfig host = new HostConfig(API_DEFAULT_HOST_URL);

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HostConfig implements Serializable {
        private static final long serialVersionUID = -5530173316382185056L;
        /** API 路径 */
        private String api;

    }
}
