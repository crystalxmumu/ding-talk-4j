package top.todev.ding.org.api.impl;

import com.alibaba.fastjson.TypeReference;
import lombok.NonNull;
import top.todev.ding.common.bean.response.CoreDingTalkResponse;
import top.todev.ding.org.api.IDingOrgReportManagementService;
import top.todev.ding.org.api.IDingOrgService;
import top.todev.ding.org.bean.request.v1.report.OapiReportListRequest;
import top.todev.ding.org.bean.response.PaginationDataList;
import top.todev.ding.org.bean.response.v1.report.OapiReportVo;
import top.todev.ding.org.util.OrgHttpExUtil;
import top.todev.tool.model.exception.NotExceptException;

import static top.todev.ding.org.constant.url.OrgReportManagementUrlEnum.REPORT_LIST;

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
    public PaginationDataList<OapiReportVo> listReport(OapiReportListRequest request) throws NotExceptException {
        return OrgHttpExUtil.getAndCheck(service, REPORT_LIST,
                request, () -> new TypeReference<CoreDingTalkResponse<PaginationDataList<OapiReportVo>>>(){},
                false, true);
    }
}
