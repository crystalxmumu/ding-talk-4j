package top.todev.ding.callback.bean.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>回调响应实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-24 10:46
 * @since 0.0.1
 */
@Data
@Accessors(chain = true)
public class CallbackResponseBodyVO implements Serializable {
    private static final long serialVersionUID = -6474679463265574890L;

    /** 消息体签名 */
    @JSONField(name = "msg_signature")
    private String msgSignature;
    /** 时间戳 */
    @JSONField(name = "timeStamp")
    private String timestamp;
    /** 随机字符串 */
    private String nonce;
    /** 加密的推送事件信息 */
    private String encrypt;
}
