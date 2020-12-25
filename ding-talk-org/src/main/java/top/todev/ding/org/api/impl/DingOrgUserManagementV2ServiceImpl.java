package top.todev.ding.org.api.impl;

import lombok.NonNull;
import top.todev.ding.org.api.IDingOrgService;
import top.todev.ding.org.api.IDingOrgUserManagementV2Service;
import top.todev.ding.org.bean.request.v2.user.OapiUserListSimpleRequest;
import top.todev.ding.org.bean.request.v2.user.OapiV2UserGetRequest;
import top.todev.ding.org.bean.response.PaginationList;
import top.todev.ding.org.bean.response.v2.user.ListUserSimpleResponse;
import top.todev.ding.org.bean.response.v2.user.OapiUserListSimpleResponse;
import top.todev.ding.org.bean.response.v2.user.OapiV2UserGetResponse;
import top.todev.ding.org.bean.response.v2.user.UserGetResponse;
import top.todev.ding.org.util.OrgHttpExUtil;
import top.todev.tool.model.exception.NotExceptException;

import static top.todev.ding.org.constant.url.concat.UserManagementV2UrlEnum.V2_USER_GET_DETAIL;
import static top.todev.ding.org.constant.url.concat.UserManagementV2UrlEnum.V2_USER_LIST_SIMPLE;

/**
 * <p>用户管理V2服务接口实现</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 10:24
 * @since 0.0.1
 */
public class DingOrgUserManagementV2ServiceImpl extends DingOrgBaseServiceImpl implements IDingOrgUserManagementV2Service {

    public DingOrgUserManagementV2ServiceImpl(@NonNull IDingOrgService service) {
        super(service);
    }

    @Override
    public UserGetResponse userGetDetail(OapiV2UserGetRequest request) throws NotExceptException {
        return OrgHttpExUtil.getAndCheck(service, V2_USER_GET_DETAIL,
                request, OapiV2UserGetResponse.class,
                false, true);
    }

    @Override
    public PaginationList<ListUserSimpleResponse> userListSimple(OapiUserListSimpleRequest request) throws NotExceptException {
        return OrgHttpExUtil.getAndCheck(service, V2_USER_LIST_SIMPLE,
                request, OapiUserListSimpleResponse.class,
                false, true);
    }
}
