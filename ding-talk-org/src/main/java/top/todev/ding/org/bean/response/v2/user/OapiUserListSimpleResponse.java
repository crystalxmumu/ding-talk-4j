package top.todev.ding.org.bean.response.v2.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.todev.ding.common.bean.response.CoreDingTalkResponse;
import top.todev.ding.org.bean.response.PaginationDataList;
import top.todev.ding.org.bean.response.PaginationList;

/**
 * <p>获取部门用户响应实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 11:05
 * @since 0.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OapiUserListSimpleResponse extends CoreDingTalkResponse<PaginationList<ListUserSimpleResponse>> {
    private static final long serialVersionUID = -4014198619674014073L;

    /** 请求ID。 */
    @JSONField(name = "request_id")
    private String requestId;
}
