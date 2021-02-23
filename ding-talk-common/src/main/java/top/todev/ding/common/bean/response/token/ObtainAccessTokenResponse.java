package top.todev.ding.common.bean.response.token;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.todev.ding.common.bean.DingAccessToken;
import top.todev.ding.common.bean.response.BaseDingTalkResponse;
import top.todev.tool.model.bean.IResultResponse;

import static top.todev.tool.model.constant.BaseErrorCodeEnum.ERROR_CODE_0;

/**
 * <p>获取token响应实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-15 14:37
 * @since 0.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ObtainAccessTokenResponse extends BaseDingTalkResponse<DingAccessToken> {

    private static final long serialVersionUID = 6921778140296655765L;

    /** 访问凭证 */
    @JSONField(name = "access_token")
    private String accessToken;
    /** 过期时间，单位秒 */
    @JSONField(name = "expires_in")
    private int expiresIn = -1;

    @Override
    public DingAccessToken getData() {
        return new DingAccessToken(this.accessToken, this.expiresIn);
    }

    @Override
    public BaseDingTalkResponse<DingAccessToken> initSuccess(DingAccessToken token) {
        this.accessToken = token.getAccessToken();
        this.expiresIn = token.getExpiresIn();
        return this;
    }
}
