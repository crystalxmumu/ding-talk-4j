package top.todev.ding.common.bean.request;

import lombok.Data;
import top.todev.ding.common.annotation.ParamType;
import top.todev.ding.common.annotation.RequestParam;

import java.io.Serializable;

/**
 * <p>钉钉开放平台接口基础请求实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-15 18:17
 * @since 0.0.1
 */
@Data
public class BaseDingTalkRequest implements Serializable {
    private static final long serialVersionUID = -306819774673473961L;

    /** 调用企业接口凭证 */
    @RequestParam(key = "access_token", type = ParamType.QUERY)
    protected String accessToken;

}
