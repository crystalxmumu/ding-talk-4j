package top.todev.ding.common.bean.request.token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.todev.ding.common.annotation.ParamType;
import top.todev.ding.common.annotation.RequestParam;

import java.io.Serializable;

/**
 * <p>获取Token请求实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-15 14:20
 * @since 0.0.1
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObtainAccessTokenRequest implements Serializable {
    private static final long serialVersionUID = -6303599374362010538L;

    /** 应用的唯一标识key */
    @RequestParam(type = ParamType.QUERY, key = "appkey")
    private String appKey;
    /** 应用的密钥 */
    @RequestParam(type = ParamType.QUERY, key = "appsecret")
    private String appSecret;
}
