package top.todev.ding.callback.boot.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;


/**
 * <p>
 * 钉钉企业应用开发工作流全局配置实体类
 * </p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/9/18 15:18
 * @since 0.0.1
 */
@Data
@ConfigurationProperties(prefix = DingTalkCallbackConfigProperties.PREFIX)
public class DingTalkCallbackConfigProperties implements Serializable {

    public static final String PREFIX = "ding.talk.callback";
    private static final long serialVersionUID = 2461253759661581798L;

    /** 应用key */
    private String appKey;
    /** 事件订阅加密AesKey */
    protected volatile String eventAesKey;
    /** 事件订阅签名Token */
    protected volatile String eventToken;
}
