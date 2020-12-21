package top.todev.ding.org.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.TypeReference;
import top.todev.ding.common.bean.response.CoreDingTalkResponse;
import top.todev.ding.org.api.IDingOrgService;
import top.todev.ding.org.config.DingOrgConfigStorage;
import top.todev.ding.org.constant.url.IDingTalkOrgApiUrl;
import top.todev.tool.model.bean.IResultResponse;
import top.todev.tool.model.exception.NotExceptException;

import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

import static top.todev.ding.common.util.HttpExUtil.*;
import static top.todev.tool.model.constant.BaseErrorCodeEnum.ERROR_CODE_999901;

/**
 * <p>企业Http工具类</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-15 17:08
 * @since 0.0.1
 */
public class OrgHttpExUtil {

    public static final String TEMPLATE_TOKEN = "access_token={}";

    /**
     * 根据请求查询接口数据
     * @param service 钉钉企业开放接口
     * @param apiUrl 请求路径
     * @param request 请求参数
     * @param clazz 响应实体类
     * @param allowDataNull 是否允许响应结果为空
     * @param addToken 是否添加token
     * @param <S> 返回类型
     * @param <T> 响应实体类型
     * @return 天气数据
     * @throws NotExceptException 接口异常
     */
    public static <S, T extends IResultResponse<S>> S getAndCheck(IDingOrgService service, IDingTalkOrgApiUrl apiUrl,
                                                                  Object request, Class<T> clazz, boolean allowDataNull,
                                                                  boolean addToken) throws NotExceptException {
        String response = dealOrgUrl(service, apiUrl, request, addToken);
        T bean = convertResponse(response, clazz);
        return checkResponseResult(bean, allowDataNull);
    }

    /**
     * 根据请求查询接口数据
     * @param service 钉钉企业开放接口
     * @param apiUrl 请求路径
     * @param request 请求参数
     * @param supplier 转换类
     * @param allowDataNull 是否允许响应结果为空
     * @param addToken 是否添加token
     * @param <T> 响应实体类型
     * @return 天气数据
     * @throws NotExceptException 接口异常
     */
    public static <T> T getAndCheck(IDingOrgService service, IDingTalkOrgApiUrl apiUrl, Object request,
                                    Supplier<TypeReference<CoreDingTalkResponse<T>>> supplier, boolean allowDataNull,
                                                                  boolean addToken) throws NotExceptException {
        String response = dealOrgUrl(service, apiUrl, request, addToken);
        CoreDingTalkResponse<T> bean = convertResponse(response, supplier);
        return checkResponseResult(bean, allowDataNull);
    }

    /**
     * 使用get方式请求接口
     * @param service 钉钉企业开放接口
     * @param apiUrl  请求接口Url
     * @param request 请求对象
     * @param addToken 是否添加token
     * @return 响应结果
     * @throws NotExceptException 无法处理接口类型时抛出异常
     */
    public static String dealOrgUrl(IDingOrgService service, IDingTalkOrgApiUrl apiUrl, Object request, boolean addToken) throws NotExceptException {
        DingOrgConfigStorage config = service.getDingOrgConfigStorage();
        String url = apiUrl.getUrl(config);
        if (addToken) {
            String token = service.getAccessToken();
            if (StrUtil.isNotBlank(token)) {
                url = HttpUtil.urlWithForm(url, StrUtil.format(TEMPLATE_TOKEN, token), StandardCharsets.UTF_8, false);
            }
        }
        switch (apiUrl.getMethod()) {
            case GET:
                return getUrl(url, request);
            case POST:
                return postUrl(url, request);
            default:
                throw new NotExceptException(ERROR_CODE_999901);
        }
    }
}
