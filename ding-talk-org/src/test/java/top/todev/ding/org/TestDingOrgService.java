package top.todev.ding.org;

import cn.hutool.core.date.LocalDateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.todev.ding.org.api.IDingOrgService;
import top.todev.ding.org.api.impl.DingOrgServiceImpl;
import top.todev.ding.org.bean.DingOrgHostConfig;
import top.todev.ding.org.bean.request.v1.report.OapiReportListRequest;
import top.todev.ding.org.bean.request.v2.dept.OapiV2DepartmentListSubRequest;
import top.todev.ding.org.bean.response.Pagination;
import top.todev.ding.org.bean.response.v1.report.OapiReportVo;
import top.todev.ding.org.bean.response.v2.dept.DeptBaseResponse;
import top.todev.ding.org.config.impl.DingOrgDefaultConfigImpl;

import java.time.LocalDateTime;
import java.util.List;

import static top.todev.ding.org.bean.DingOrgHostConfig.API_DEFAULT_HOST_URL;

/**
 * <p>钉钉开放平台接口测试</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-15 16:24
 * @since 0.0.1
 */
@Slf4j
public class TestDingOrgService {

    private IDingOrgService service;

    @BeforeEach
    public void init() {
        DingOrgHostConfig config = new DingOrgHostConfig(API_DEFAULT_HOST_URL);
        DingOrgDefaultConfigImpl storage = new DingOrgDefaultConfigImpl();
        storage.setHostConfig(config);
        storage.setAppKey("dingylwkwqy6z7xk7cdw");
        storage.setAppSecret("BPohcL110xpD6KiTrb9iq-GAkW-LhpNsS0RtKPL2FHym-kmFUi4kyL1zSEZyNHRs");
        service = new DingOrgServiceImpl();
        service.setDingOrgConfigStorage(storage);
    }


    @Test
    public void testGetToken() {
        String token = service.getAccessToken();

        log.info("Token: {}", token);

        List<DeptBaseResponse> deptBaseResponses = service.getDepartmentManagementV2Service().listSub(null);
        log.info("部门列表: {}", deptBaseResponses);


    }

    @Test
    public void testGetDept() {
        List<DeptBaseResponse> deptBaseResponses = service.getDepartmentManagementV2Service().listSub(null);
        log.info("部门列表: {}", deptBaseResponses);

        OapiV2DepartmentListSubRequest request = OapiV2DepartmentListSubRequest.builder().deptId(139610222).build();
        log.info("分子公司部门列表: {}", service.getDepartmentManagementV2Service().listSub(request));
    }

    @Test
    public void testListReport() {
        LocalDateTime today = LocalDateTimeUtil.beginOfDay(LocalDateTime.now());
        LocalDateTime tomorrow = today.plusDays(1L);
        OapiReportListRequest request = OapiReportListRequest.builder()
                .startTime(LocalDateTimeUtil.toEpochMilli(today))
                .endTime(LocalDateTimeUtil.toEpochMilli(tomorrow))
                .templateName("A级人群工作日志")
                .cursor(0L).size(20L).build();
        Pagination<OapiReportVo> pagination = service.getReportManagementService().listReport(request);
        log.info("日志数据：{}", pagination);
    }
}
