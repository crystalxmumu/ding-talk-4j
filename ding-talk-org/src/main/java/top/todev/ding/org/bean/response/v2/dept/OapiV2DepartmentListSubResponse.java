package top.todev.ding.org.bean.response.v2.dept;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.todev.ding.common.bean.response.BaseDingTalkResponse;
import top.todev.ding.common.bean.response.CoreDingTalkResponse;

import java.util.List;

/**
 * <p>获取部门列表响应实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-15 18:36
 * @since 0.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OapiV2DepartmentListSubResponse extends CoreDingTalkResponse<List<DeptBaseResponse>> {
    private static final long serialVersionUID = -80374356675611799L;

    /** 请求ID。 */
    @JSONField(name = "request_id")
    private String requestId;
}
