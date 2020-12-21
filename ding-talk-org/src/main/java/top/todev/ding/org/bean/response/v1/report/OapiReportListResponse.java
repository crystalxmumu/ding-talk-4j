package top.todev.ding.org.bean.response.v1.report;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.todev.ding.common.bean.response.CoreDingTalkResponse;
import top.todev.ding.org.bean.response.Pagination;

/**
 * <p>获取用户发出的日志列表响应</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-21 15:28
 * @since 0.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OapiReportListResponse  extends CoreDingTalkResponse<Pagination<OapiReportVo>> {

    private static final long serialVersionUID = -4819897292030171243L;

    /** 请求ID。 */
    @JSONField(name = "request_id")
    private String requestId;
}
