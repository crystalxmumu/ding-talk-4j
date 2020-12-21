package top.todev.ding.org.api;

import top.todev.ding.org.bean.request.v2.dept.OapiV2DepartmentListSubRequest;
import top.todev.ding.org.bean.response.v2.dept.DeptBaseResponse;
import top.todev.tool.model.exception.NotExceptException;

import java.util.List;

/**
 * <p>企业应用部门管理V2服务接口</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-18 15:59
 * @since 0.0.1
 */
public interface IDingOrgDepartmentManagementV2Service {

    /**
     * <p>获取部门列表</p>
     * @param request 查询参数
     * @return 部门列表
     * @throws NotExceptException 不期望发生的异常
     * @author 小飞猪
     * @date 2020/12/18 16:04
     * @since 0.0.1
     */
    List<DeptBaseResponse> listSub(OapiV2DepartmentListSubRequest request) throws NotExceptException;
}
