package top.todev.ding.org.bean.response.v2.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>用户信息列表</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 11:07
 * @since 0.0.1
 */
@Data
public class ListUserSimpleResponse implements Serializable {
    private static final long serialVersionUID = 4554365417426908285L;

    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户id
     */
    @JSONField(name = "userid")
    private String userId;
}
