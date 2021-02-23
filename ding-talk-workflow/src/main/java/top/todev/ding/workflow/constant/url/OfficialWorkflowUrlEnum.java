package top.todev.ding.workflow.constant.url;

import cn.hutool.http.Method;
import lombok.AllArgsConstructor;
import lombok.Getter;
import top.todev.ding.common.constant.url.IDingTalkApiUrl;

import static top.todev.ding.common.bean.DingHostConfig.API_DEFAULT_HOST_URL;

/**
 * <p>官方工作流接口url枚举</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-02-18 15:56
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum OfficialWorkflowUrlEnum implements IDingTalkApiUrl {

    /** 智能工作流 */
    PROCESS_INSTANCE_CREATE(API_DEFAULT_HOST_URL, "/topapi/processinstance/create", Method.POST),
    PROCESS_INSTANCE_GET(API_DEFAULT_HOST_URL, "/topapi/processinstance/get", Method.POST)
    ;

    private final String prefix;
    /**
     * 路径URI
     */
    private final String path;
    /** 接口请求方式 */
    private final Method method;
}
