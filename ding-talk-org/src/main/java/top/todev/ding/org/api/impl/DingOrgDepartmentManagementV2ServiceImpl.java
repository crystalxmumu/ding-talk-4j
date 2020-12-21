package top.todev.ding.org.api.impl;

import lombok.NonNull;
import top.todev.ding.org.api.IDingOrgDepartmentManagementV2Service;
import top.todev.ding.org.api.IDingOrgService;
import top.todev.ding.org.bean.request.v2.dept.OapiV2DepartmentListSubRequest;
import top.todev.ding.org.bean.response.v2.dept.DeptBaseResponse;
import top.todev.ding.org.bean.response.v2.dept.OapiV2DepartmentListSubResponse;
import top.todev.ding.org.util.OrgHttpExUtil;
import top.todev.tool.model.exception.NotExceptException;

import java.util.List;

import static top.todev.ding.org.constant.url.concat.DepartmentManagementV2UrlEnum.V2_DEPARTMENT_LIST_SUB;

/**
 * <p>企业应用部门管理V2服务接口实现类</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-18 16:05
 * @since 0.0.1
 */
public class DingOrgDepartmentManagementV2ServiceImpl extends DingOrgBaseServiceImpl implements IDingOrgDepartmentManagementV2Service {

    public DingOrgDepartmentManagementV2ServiceImpl(@NonNull IDingOrgService service) {
        super(service);
    }

    @Override
    public List<DeptBaseResponse> listSub(OapiV2DepartmentListSubRequest request) throws NotExceptException {
        return OrgHttpExUtil.getAndCheck(service, V2_DEPARTMENT_LIST_SUB,
                request, OapiV2DepartmentListSubResponse.class, false, true);
    }
}
