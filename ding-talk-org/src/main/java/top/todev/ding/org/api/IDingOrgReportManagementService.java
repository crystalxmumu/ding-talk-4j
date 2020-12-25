package top.todev.ding.org.api;

import top.todev.ding.org.bean.request.v1.report.OapiReportListRequest;
import top.todev.ding.org.bean.response.PaginationDataList;
import top.todev.ding.org.bean.response.v1.report.OapiReportVo;
import top.todev.tool.model.exception.NotExceptException;

/**
 * <p>日志管理服务接口</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-18 15:59
 * @since 0.0.1
 */
public interface IDingOrgReportManagementService {

    /**
     * <p>获取用户发出的日志列表</p>
     * @param request 查询参数
     * @return 日志列表
     * @throws NotExceptException 不期望发生的异常
     * @author 小飞猪
     * @date 2020/12/21 16:04
     * @since 0.0.1
     */
    PaginationDataList<OapiReportVo> listReport(OapiReportListRequest request) throws NotExceptException;
}
