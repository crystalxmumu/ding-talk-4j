package top.todev.ding.common.util;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import top.todev.ding.common.api.IDingService;
import top.todev.ding.common.bean.DingTalkRequestParam;
import top.todev.ding.common.bean.response.BaseDingTalkResponse;
import top.todev.ding.common.bean.response.CoreDingTalkResponse;
import top.todev.ding.common.config.DingConfigStorage;
import top.todev.ding.common.constant.url.IDingTalkApiUrl;
import top.todev.ding.common.data.RequestData;
import top.todev.tool.model.bean.IResultResponse;
import top.todev.tool.model.exception.NotExceptException;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Supplier;

import static top.todev.tool.model.constant.BaseErrorCodeEnum.ERROR_CODE_999901;

/**
 * <p>http请求工具类</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-15 16:57
 * @since 0.0.1
 */
@Slf4j
public class HttpExUtil {

    public static final String TEMPLATE_TOKEN = "access_token={}";

    public static final int DEFAULT_CONN_TIME_OUT = 6000;
    public static final int DEFAULT_READ_TIME_OUT = 60000;

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
     * @return 响应实体
     * @throws NotExceptException 接口异常
     */
    public static <S, T extends IResultResponse<S>> S getAndCheck(IDingService service, IDingTalkApiUrl apiUrl,
                                                                  Object request, Class<T> clazz, boolean allowDataNull,
                                                                  boolean addToken) throws NotExceptException {
        return getAndCheck(service, apiUrl, request, clazz, allowDataNull, addToken, true);
    }

    /**
     * 根据请求查询接口数据
     * @param service 钉钉企业开放接口
     * @param apiUrl 请求路径
     * @param request 请求参数
     * @param clazz 响应实体类
     * @param allowDataNull 是否允许响应结果为空
     * @param addToken 是否添加token
     * @param isSelfRequest 是否自定义请求
     * @param <S> 返回类型
     * @param <T> 响应实体类型
     * @return 响应实体
     * @throws NotExceptException 接口异常
     */
    public static <S, T extends IResultResponse<S>> S getAndCheck(IDingService service, IDingTalkApiUrl apiUrl,
                                                                  Object request, Class<T> clazz, boolean allowDataNull,
                                                                  boolean addToken, boolean isSelfRequest) throws NotExceptException {
        String response = dealDingUrl(service, apiUrl, request, addToken, isSelfRequest);
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
     * @return 响应实体
     * @throws NotExceptException 接口异常
     */
    public static <T> T getAndCheck(IDingService service, IDingTalkApiUrl apiUrl, Object request,
                                    Supplier<TypeReference<CoreDingTalkResponse<T>>> supplier, boolean allowDataNull,
                                    boolean addToken) throws NotExceptException {
        return getAndCheck(service, apiUrl, request, supplier, allowDataNull, addToken, true);
    }

    /**
     * 根据请求查询接口数据
     * @param service 钉钉企业开放接口
     * @param apiUrl 请求路径
     * @param request 请求参数
     * @param supplier 转换类
     * @param allowDataNull 是否允许响应结果为空
     * @param addToken 是否添加token
     * @param isSelfRequest 是否自定义请求
     * @param <T> 响应实体类型
     * @return 响应实体
     * @throws NotExceptException 接口异常
     */
    public static <T> T getAndCheck(IDingService service, IDingTalkApiUrl apiUrl, Object request,
                                    Supplier<TypeReference<CoreDingTalkResponse<T>>> supplier, boolean allowDataNull,
                                    boolean addToken, boolean isSelfRequest) throws NotExceptException {
        String response = dealDingUrl(service, apiUrl, request, addToken, isSelfRequest);
        CoreDingTalkResponse<T> bean = convertCoreDingResponse(response, supplier);
        return checkResponseResult(bean, allowDataNull);
    }

    /**
     * 使用get方式请求接口
     * @param service 钉钉企业开放接口
     * @param apiUrl  请求接口Url
     * @param request 请求对象
     * @param addToken 是否添加token
     * @param isSelfRequest 是否自定义请求
     * @return 响应结果
     * @throws NotExceptException 无法处理接口类型时抛出异常
     */
    public static String dealDingUrl(IDingService service, IDingTalkApiUrl apiUrl, Object request, boolean addToken, boolean isSelfRequest) throws NotExceptException {
        DingConfigStorage config = service.getDingOrgConfigStorage();
        String url = apiUrl.getUrl(config);
        if (addToken) {
            String token = service.getAccessToken();
            if (StrUtil.isNotBlank(token)) {
                url = HttpUtil.urlWithForm(url, StrUtil.format(TEMPLATE_TOKEN, token), StandardCharsets.UTF_8, false);
            }
        }
        switch (apiUrl.getMethod()) {
            case GET:
                return getUrl(url, request, isSelfRequest);
            case POST:
                return postUrl(url, request, isSelfRequest);
            default:
                throw new NotExceptException(ERROR_CODE_999901);
        }
    }

    /**
     * <p>使用get方式请求接口</p>
     * @param url 请求路径
     * @param request 请求实体
     * @param isSelfRequest 是否自定义请求
     * @return 响应结果
     * @author 小飞猪
     * @date 2020/12/15 18:21
     * @since 0.0.1
     */
    public static String getUrl(String url, Object request, boolean isSelfRequest) {
        Supplier<RequestData> supplier = isSelfRequest ? fromRequestParam(url, request) : fromRequestObject(url, request);
        return dealUrl(supplier, true);
    }

    /**
     * <p>使用post方式请求接口</p>
     * @param url 请求路径
     * @param request 请求实体
     * @param isSelfRequest 是否自定义请求
     * @return 响应结果
     * @author 小飞猪
     * @date 2020/12/15 18:21
     * @since 0.0.1
     */
    public static String postUrl(String url, Object request, boolean isSelfRequest) {
        Supplier<RequestData> supplier = isSelfRequest ? fromRequestParam(url, request) : fromRequestObject(url, request);
        return dealUrl(supplier, false);
    }

    /**
     * <p>使用get方式请求接口</p>
     * @param supplier 请求实体
     * @param isGet 是否get方式
     * @return 响应结果
     * @author 小飞猪
     * @date 2020/12/15 18:21
     * @since 0.0.1
     */
    public static String dealUrl(Supplier<RequestData> supplier, boolean isGet) {
        LocalDateTime begin = LocalDateTime.now();
        RequestData data = supplier.get();
        String urlWithQuery = data.getUrl();
        String body = data.getBody();

        HttpResponse response = null;
        if (isGet) {
            response = HttpRequest.get(urlWithQuery)
                    .setConnectionTimeout(DEFAULT_CONN_TIME_OUT)
                    .setReadTimeout(DEFAULT_READ_TIME_OUT)
                    .body(body)
                    .execute();
        } else {
            response = HttpRequest.post(urlWithQuery)
                    .setConnectionTimeout(DEFAULT_CONN_TIME_OUT)
                    .setReadTimeout(DEFAULT_READ_TIME_OUT)
                    .body(body)
                    .execute();
        }

        LocalDateTime end = LocalDateTime.now();
        Duration between = Duration.between(begin, end);
        if (!response.isOk()) {
            log.info("请求路径: {}, 时长: {}毫秒, 请求参数: {}, 响应码: {}", urlWithQuery, between.toMillis(), body, response.getStatus());
            throw new NotExceptException(ERROR_CODE_999901.getValue(), "请求失败, 请检查请求参数!");
        }
        String result = response.body();
        log.info("请求路径: {}, 时长: {}毫秒, 请求参数: {}, 响应结果: {}", urlWithQuery, between.toMillis(), body, result);
        return result;
    }

    private static Supplier<RequestData> fromRequestParam(String url, Object request) {
        return () -> {
            DingTalkRequestParam param = DingTalkRequestParam.buildRequest(request);
            String urlWithQuery = HttpUtil.urlWithForm(url, param.getQueryParams(), StandardCharsets.UTF_8, false);
            String body = MapUtil.isEmpty(param.getBodyParams()) ? null : JSON.toJSONString(param.getBodyParams());
            return new RequestData(urlWithQuery, body);
        };
    }

    private static Supplier<RequestData> fromRequestObject(String url, Object request) {
        return () -> new RequestData(url, JSON.toJSONString(request));
    }


    /**
     * <p>将响应结果转换为实体类实例</p>
     * @param response 响应结果串
     * @param clazz 实体类
     * @param <T> 实体泛型
     * @return 实体实例
     * @author 小飞猪
     * @date 2020/12/15 16:43
     * @since 0.0.1
     */
    public static <T> T convertResponse(String response, Class<T> clazz) {
        return JSON.parseObject(response, clazz);
    }

    /**
     * <p>将响应结果转换为实体类实例</p>
     * @param response 响应结果串
     * @param supplier 转换类
     * @param <T> 实体泛型
     * @return 实体实例
     * @author 小飞猪
     * @date 2021/02/24 16:43
     * @since 0.0.2
     */
    public static <T> T convertResponse(String response, Supplier<TypeReference<T>> supplier) {
        return JSON.parseObject(response, supplier.get());
    }

    /**
     * 将响应结果转换为实体类实例
     * @param response 响应结果串
     * @param supplier 转换类
     * @param <T> 实体泛型
     * @return 实体实例
     * @author 小飞猪
     * @date 2021/02/24 16:43
     * @since 0.0.2
     */
    public static <T> BaseDingTalkResponse<T> convertBaseDingResponse(String response, Supplier<TypeReference<BaseDingTalkResponse<T>>> supplier) {
        return JSON.parseObject(response, supplier.get());
    }

    /**
     * 将响应结果转换为实体类实例
     * @param response 响应结果串
     * @param supplier 转换类
     * @param <T> 实体泛型
     * @return 实体实例
     * @author 小飞猪
     * @date 2020/12/21 16:43
     * @since 0.0.1
     */
    public static <T> CoreDingTalkResponse<T> convertCoreDingResponse(String response, Supplier<TypeReference<CoreDingTalkResponse<T>>> supplier) {
        return JSON.parseObject(response, supplier.get());
    }

    /**
     * 检查响应结果并返回响应数据
     * @param response 响应结果
     * @param allowNull 是否允许为空
     * @param <S> 响应数据类型
     * @return 响应数据
     * @throws NotExceptException 调用错误异常
     */
    public static <S> S checkResponseResult(IResultResponse<S> response, boolean allowNull) throws NotExceptException {
        return allowNull ? IResultResponse.getResponseDataAllowNull(response) :
                IResultResponse.getResponseDataNotAllowNull(response);
    }
}
