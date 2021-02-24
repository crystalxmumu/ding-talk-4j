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
public class CallbackRequestBodyVO implements Serializable {

    private static final long serialVersionUID = 6776373503724154922L;

    /** 加密的推送事件信息 */
    private String encrypt;
}
