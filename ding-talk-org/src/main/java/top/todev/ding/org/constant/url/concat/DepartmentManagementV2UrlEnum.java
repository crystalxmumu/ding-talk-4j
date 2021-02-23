package top.todev.ding.org.constant.url.concat;

import cn.hutool.http.Method;
import lombok.AllArgsConstructor;
import lombok.Getter;
import top.todev.ding.common.constant.url.IDingTalkApiUrl;

import static top.todev.ding.common.bean.DingHostConfig.API_DEFAULT_HOST_URL;

/**
 * <p>部门管理V2接口url枚举</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-18 15:56
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum DepartmentManagementV2UrlEnum  implements IDingTalkApiUrl {

    /** 获取部门列表 */
    V2_DEPARTMENT_LIST_SUB(API_DEFAULT_HOST_URL, "/topapi/v2/department/listsub", Method.POST),
    V2_DEPARTMENT_GET_DETAIL(API_DEFAULT_HOST_URL, "/topapi/v2/department/get", Method.POST)
    ;

    private final String prefix;
    /**
     * 路径URI
     */
    private final String path;
    /** 接口请求方式 */
    private final Method method;
}
