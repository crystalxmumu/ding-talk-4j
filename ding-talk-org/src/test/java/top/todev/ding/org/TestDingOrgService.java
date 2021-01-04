package top.todev.ding.org;

import cn.hutool.core.date.LocalDateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.todev.ding.common.constant.data.LangEnum;
import top.todev.ding.org.api.IDingOrgService;
import top.todev.ding.org.api.impl.DingOrgServiceImpl;
import top.todev.ding.org.bean.DingOrgHostConfig;
import top.todev.ding.org.bean.request.v1.authentication.OapiUserGetUserInfoRequest;
import top.todev.ding.org.bean.request.v1.report.OapiReportListRequest;
import top.todev.ding.org.bean.request.v2.dept.OapiV2DepartmentGetRequest;
import top.todev.ding.org.bean.request.v2.dept.OapiV2DepartmentListSubRequest;
import top.todev.ding.org.bean.request.v2.user.OapiUserListSimpleRequest;
import top.todev.ding.org.bean.request.v2.user.OapiV2UserGetRequest;
import top.todev.ding.org.bean.response.PaginationDataList;
import top.todev.ding.org.bean.response.PaginationList;
import top.todev.ding.org.bean.response.v1.report.OapiReportVo;
import top.todev.ding.org.bean.response.v2.dept.DeptBaseResponse;
import top.todev.ding.org.bean.response.v2.dept.DeptGetResponse;
import top.todev.ding.org.bean.response.v2.user.ListUserSimpleResponse;
import top.todev.ding.org.bean.response.v2.user.UserGetResponse;
import top.todev.ding.org.config.impl.DingOrgDefaultConfigImpl;
import top.todev.ding.org.constant.data.DepartmentMemberSortRuleEnum;

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
        // {"errcode":0,"errmsg":"ok","result":[{"auto_add_user":true,"create_dept_group":true,"dept_id":434593665,"name":"总经办","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":50530301,"ext":"{\"faceCount\":\"1\"}","name":"监察服务中心","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":335577134,"name":"档案中心","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":408502299,"name":"经营管理委员会","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":36948845,"ext":"{\"faceCount\":\"2\"}","name":"品质服务中心","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":36950850,"name":"财务服务中心","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":37010810,"name":"人力行政服务中心","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":37029895,"ext":"{\"faceCount\":\"119\"}","name":"运营服务中心","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":36979697,"name":"市场开发服务中心","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":335743026,"name":"法务服务中心","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":335518214,"name":"信息化服务中心","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":139610222,"ext":"{\"faceCount\":\"245\"}","name":"瑞洁物业分\/子公司","parent_id":1},{"auto_add_user":false,"create_dept_group":false,"dept_id":36953754,"name":"瑞洁职业培训学校","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":37029896,"name":"瑞洁人力资源有限公司","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":37020762,"name":"瑞洁社区综合服务中心","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":37021747,"ext":"{\"faceCount\":\"6\"}","name":"瑞膳餐饮服务管理有限公司","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":36994800,"name":"瑞洁停车场管理有限公司","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":37030888,"name":"瑞洁久业网络家庭服务有限公司","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":36979710,"name":"瑞与实业有限公司","parent_id":1},{"auto_add_user":true,"create_dept_group":true,"dept_id":335222327,"name":"瑞洁生活企业发展有限公司","parent_id":1}],"request_id":"52dqubiqzuif"}
        log.info("部门列表: {}", deptBaseResponses);


        // 获取下级分公司
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
        PaginationDataList<OapiReportVo> pagination = service.getReportManagementService().listReport(request);
        log.info("日志数据：{}", pagination);
    }

    @Test
    public void testGetDepartmentMember() {
        // 信息化服务中心：335518214
        // 总经办： 434593665
        // 财务服务中心：36950850
        OapiUserListSimpleRequest request = OapiUserListSimpleRequest.builder()
                .deptId(64510115L)
                .cursor(0L).size(20L)
                .orderField(DepartmentMemberSortRuleEnum.DEPT_SORT_RULE_ENTRY_DESC)
                .containAccessLimit(true)
//                .language(LangEnum.LANGUAGE_EN_US)
                .build();
        // {"errcode":0,"errmsg":"ok","result":{"has_more":false,"list":[{"name":"陈涛","userid":"10130922341220691"},{"name":"朱利福","userid":"220968003626069879"},{"name":"杨海峰","userid":"091417051026332097"}]},"request_id":"6b9a0macp683"}
        PaginationList<ListUserSimpleResponse> pagination = service.getUserManagementV2Service().userListSimple(request);
        log.info("部门成员：{}", pagination);
    }

    @Test
    public void testGetUserDetail() {
        OapiV2UserGetRequest request = OapiV2UserGetRequest.builder()
                .userId("10130922341220691").language(LangEnum.LANGUAGE_ZH_CN).build();
        UserGetResponse user = service.getUserManagementV2Service().userGetDetail(request);
        log.info("用户信息: {}", user);
    }

    @Test
    public void testGetDepartmentDetail() {
        // 信息化服务中心：335518214
        OapiV2DepartmentGetRequest request = OapiV2DepartmentGetRequest.builder().deptId(335518214L).build();
        DeptGetResponse detail = service.getDepartmentManagementV2Service().departmentGetDetail(request);
        log.info("部门信息：{}", detail);
    }
}
