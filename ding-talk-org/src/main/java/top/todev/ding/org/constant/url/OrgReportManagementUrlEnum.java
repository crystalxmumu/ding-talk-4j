package top.todev.ding.org.constant.url;

import cn.hutool.http.Method;
import lombok.AllArgsConstructor;
import lombok.Getter;
import top.todev.ding.common.constant.url.IDingTalkApiUrl;

import static top.todev.ding.common.bean.DingHostConfig.API_DEFAULT_HOST_URL;

/**
 * <p>日志接口Url枚举</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-21 09:44
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum OrgReportManagementUrlEnum implements IDingTalkApiUrl {

    /** 获取用户发出的日志列表 */
    REPORT_LIST(API_DEFAULT_HOST_URL, "/topapi/report/list", Method.POST)

    ;

    private final String prefix;
    /**
     * 路径URI
     */
    private final String path;
    /** 接口请求方式 */
    private final Method method;
}
