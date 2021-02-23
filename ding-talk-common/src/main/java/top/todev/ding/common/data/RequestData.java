package top.todev.ding.common.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>请求数据类</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 18:28
 * @since 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestData implements Serializable {
    private static final long serialVersionUID = -3886758589055011255L;

    private String url;

    private String body;
}
