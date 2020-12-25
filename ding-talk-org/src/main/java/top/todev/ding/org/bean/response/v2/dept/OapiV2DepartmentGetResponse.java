package top.todev.ding.org.bean.response.v2.dept;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.todev.ding.common.bean.response.CoreDingTalkResponse;

/**
 * <p>获取部门详情相应实体</p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 10:33
 * @since 0.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OapiV2DepartmentGetResponse extends CoreDingTalkResponse<DeptGetResponse> {
    private static final long serialVersionUID = -8478393290546301587L;

    /** 请求ID。 */
    @JSONField(name = "request_id")
    private String requestId;
}
