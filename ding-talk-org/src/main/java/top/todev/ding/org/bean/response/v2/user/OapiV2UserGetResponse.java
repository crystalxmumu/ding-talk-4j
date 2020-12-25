package top.todev.ding.org.bean.response.v2.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.todev.ding.common.bean.response.CoreDingTalkResponse;

import java.io.Serializable;

/**
 * <p>获取用户详情相响应实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 09:54
 * @since 0.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OapiV2UserGetResponse extends CoreDingTalkResponse<UserGetResponse> {

    private static final long serialVersionUID = -5153493928078812883L;

    /** 请求ID。 */
    @JSONField(name = "request_id")
    private String requestId;
}
