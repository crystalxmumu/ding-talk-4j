package top.todev.ding.org.bean.request.v2.user;

import lombok.Builder;
import lombok.Data;
import top.todev.ding.common.annotation.RequestParam;
import top.todev.ding.common.constant.data.LangEnum;

import java.io.Serializable;

/**
 * <p>获取用户详情请求实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 09:46
 * @since 0.0.1
 */
@Data
@Builder
public class OapiV2UserGetRequest implements Serializable {
    private static final long serialVersionUID = -3482331282221092675L;

    /** 语言 */
    private LangEnum language;

    /** 用户id */
    @RequestParam(key = "userid")
    private String userId;
}
