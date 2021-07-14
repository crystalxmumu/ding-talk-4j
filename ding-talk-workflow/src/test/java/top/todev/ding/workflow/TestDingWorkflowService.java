package top.todev.ding.workflow;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.todev.ding.common.bean.DingHostConfig;
import top.todev.ding.common.config.impl.DingDefaultConfigImpl;
import top.todev.ding.workflow.api.IDingWorkflowService;
import top.todev.ding.workflow.api.impl.DingWorkflowServiceImpl;
import top.todev.ding.workflow.bean.request.FormComponentValueVO;
import top.todev.ding.workflow.bean.request.ProcessInstanceCreateRequest;
import top.todev.ding.workflow.bean.request.ProcessInstanceGetRequest;
import top.todev.ding.workflow.bean.response.ProcessInstanceCreateResponse;
import top.todev.ding.workflow.bean.response.ProcessInstanceTopVO;

import static top.todev.ding.common.bean.DingHostConfig.API_DEFAULT_HOST_URL;

/**
 * <p>钉钉开放平台接口测试</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-15 16:24
 * @since 0.0.1
 */
@Slf4j
public class TestDingWorkflowService {

    private IDingWorkflowService service;

    @BeforeEach
    public void init() {
        DingHostConfig config = new DingHostConfig(API_DEFAULT_HOST_URL);
        DingDefaultConfigImpl storage = new DingDefaultConfigImpl();
        storage.setHostConfig(config);
        storage.setAppKey("dingylwkwqy6z7xk7cdw");
        storage.setAppSecret("BPohcL110xpD6KiTrb9iq-GAkW-LhpNsS0RtKPL2FHym-kmFUi4kyL1zSEZyNHRs");
        service = new DingWorkflowServiceImpl();
        service.setDingOrgConfigStorage(storage);
    }


    @Test
    public void testCreateInstance() {
        ProcessInstanceCreateRequest request = new ProcessInstanceCreateRequest();
        request.setProcessCode("PROC-FF6Y696SO2-2Y3M66C0R96HN0GT0N9J3-KNPOYJ4J-W2")
                .setOriginatorUserId("220968003626069879")
                .setDeptId(335518214L)
                .setApprovers("2234051239264766")
                .addFormComponentValue(new FormComponentValueVO("报修主题", "电器设备"))
                .addFormComponentValue(new FormComponentValueVO("报修地点", "管委会5楼235"))
                .addFormComponentValue(new FormComponentValueVO("具体内容", "测试数据分解为i欧弗吉尔熬过啊"))
                .addFormComponentValue(new FormComponentValueVO()
                            .setName("上传图片")
                            .setValueForMulti("http://17314901.s21i.faiusr.com/2/ABUIABACGAAg-N2d_QUoo6i8oAYwxQ44lQQ.jpg",
                                        "http://17314901.s21i.faiusr.com/2/ABUIABACGAAg-t2d_QUo4q26lgQwxQ44lQQ.jpg"));
        ProcessInstanceCreateResponse response = service.getWorkflowOfficialService().instanceCreate(request);
        log.info("创建结果: {}", response);

    }

    @Test
    public void testGetInstance() {
        ProcessInstanceGetRequest request = new ProcessInstanceGetRequest().setProcessInstanceId("1ef95529-6272-453a-bd1e-1ccc46d866b8");
        ProcessInstanceTopVO vo = service.getWorkflowOfficialService().instanceGet(request);
        log.info("实例详情: {}", vo);
    }

    @Test
    public void testStr() {
        log.info("数据：{}", JSON.toJSONString("hello"));
    }
}
