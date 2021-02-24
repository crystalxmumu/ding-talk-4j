package top.todev.ding.callback.bean.request;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>回调请求实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-24 10:40
 * @since 0.0.1
 */
@Data
public class CallbackRequestParamVO implements Serializable {
    private static final long serialVersionUID = 1934919178784248846L;

    /** 消息体签名 */
    private String signature;
    /** 时间戳 */
    private String timestamp;
    /** 随机字符串 */
    private String nonce;
}
