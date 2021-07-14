package top.todev.ding.org.bean.request.v1.authentication;

import lombok.Builder;
import lombok.Data;
import top.todev.ding.common.annotation.ParamType;
import top.todev.ding.common.annotation.RequestParam;

import java.io.Serializable;

/**
 * <p>通过免登码获取用户信息请求实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 08:25
 * @since 0.0.1
 */
@Data
@Builder
public class OapiUserGetUserInfoRequest implements Serializable {
    private static final long serialVersionUID = 6650495537415126226L;

    /**
     * 免登授权码。 获取方式请参考：
     * 获取小程序免登授权码: https://ding-doc.dingtalk.com/document#/org-dev-guide/free-login#topic-1949368
     * 获取H5微应用免登授权码: https://ding-doc.dingtalk.com/document#/org-dev-guide/logon-free-process#topic-1949436
     */
    @RequestParam(type = ParamType.QUERY)
    private String code;
}
