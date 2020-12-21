package top.todev.ding.org.api.impl;

import com.alibaba.fastjson.TypeReference;
import lombok.NonNull;
import top.todev.ding.common.bean.response.CoreDingTalkResponse;
import top.todev.ding.org.api.IDingOrgReportManagementService;
import top.todev.ding.org.api.IDingOrgService;
import top.todev.ding.org.bean.request.v1.report.OapiReportListRequest;
import top.todev.ding.org.bean.response.Pagination;
import top.todev.ding.org.bean.response.v1.report.OapiReportVo;
import top.todev.ding.org.bean.response.v2.dept.OapiV2DepartmentListSubResponse;
import top.todev.ding.org.util.OrgHttpExUtil;
import top.todev.tool.model.exception.NotExceptException;

import java.util.List;

import static top.todev.ding.org.constant.url.OrgReportManagementUrlEnum.REPORT_LIST;
import static top.todev.ding.org.constant.url.concat.DepartmentManagementV2UrlEnum.V2_DEPARTMENT_LIST_SUB;

/**
 * <p>日志管理服务接口实现</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-21 15:54
 * @since 0.0.1
 */

public class DingOrgReportManagementServiceImpl extends DingOrgBaseServiceImpl implements IDingOrgReportManagementService {

    public DingOrgReportManagementServiceImpl(@NonNull IDingOrgService service) {
        super(service);
    }

    @Override
    public Pagination<OapiReportVo> listReport(OapiReportListRequest request) throws NotExceptException {
        return OrgHttpExUtil.getAndCheck(service, REPORT_LIST,
                request, () -> new TypeReference<CoreDingTalkResponse<Pagination<OapiReportVo>>>(){},
                false, true);
    }
}
