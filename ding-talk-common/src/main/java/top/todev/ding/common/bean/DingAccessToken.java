package top.todev.ding.common.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>钉钉访问凭证</p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-14 16:08
 * @since 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DingAccessToken implements Serializable {

    private static final long serialVersionUID = -4365408172020948459L;
    /** 访问凭证 */
    private String accessToken;
    /** 过期时间，单位秒 */
    private int expiresIn = -1;
}
