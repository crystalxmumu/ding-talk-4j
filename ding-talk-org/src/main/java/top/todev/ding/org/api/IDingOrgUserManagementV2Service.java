package top.todev.ding.org.api;

import top.todev.ding.org.bean.request.v2.user.OapiUserListSimpleRequest;
import top.todev.ding.org.bean.request.v2.user.OapiV2UserGetRequest;
import top.todev.ding.org.bean.response.PaginationList;
import top.todev.ding.org.bean.response.v2.user.ListUserSimpleResponse;
import top.todev.ding.org.bean.response.v2.user.UserGetResponse;
import top.todev.tool.model.exception.NotExceptException;

/**
 * <p>用户管理V2服务接口</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-18 15:59
 * @since 0.0.1
 */
public interface IDingOrgUserManagementV2Service {

    /**
     * <p>获取用户详情</p>
     * @param request 查询参数
     * @return 用户详情
     * @throws NotExceptException 不期望发生的异常
     * @author 小飞猪
     * @date 2020/12/18 16:04
     * @since 0.0.1
     */
    UserGetResponse userGetDetail(OapiV2UserGetRequest request) throws NotExceptException;

    /**
     * <p><a href="https://ding-doc.dingtalk.com/document#/org-dev-guide/obtains-users-of-department-v2">获取部门用户。</a></p>
     * @param request 查询参数
     * @return 部门用户分页数据
     * @throws NotExceptException 不期望发生的异常
     * @author 小飞猪
     * @date 2020/12/24 11:09
     * @since 0.0.1
     */
    PaginationList<ListUserSimpleResponse> userListSimple(OapiUserListSimpleRequest request) throws NotExceptException;
}
