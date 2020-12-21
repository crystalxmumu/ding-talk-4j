package top.todev.ding.common.util;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import top.todev.ding.common.bean.DingTalkRequestParam;
import top.todev.ding.common.bean.response.CoreDingTalkResponse;
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

    /**
     * <p>使用get方式请求接口</p>
     * @param url 请求路径
     * @param request 请求实体
     * @return 响应结果
     * @author 小飞猪
     * @date 2020/12/15 18:21
     * @since 0.0.1
     */
    public static String getUrl(String url, Object request) {
        return dealUrl(url, request, true);
    }

    /**
     * <p>使用post方式请求接口</p>
     * @param url 请求路径
     * @param request 请求实体
     * @return 响应结果
     * @author 小飞猪
     * @date 2020/12/15 18:21
     * @since 0.0.1
     */
    public static String postUrl(String url, Object request) {
        return dealUrl(url, request, false);
    }

    /**
     * <p>使用get方式请求接口</p>
     * @param url 请求路径
     * @param request 请求实体
     * @return 响应结果
     * @author 小飞猪
     * @date 2020/12/15 18:21
     * @since 0.0.1
     */
    public static String dealUrl(String url, Object request, boolean isGet) {
        LocalDateTime begin = LocalDateTime.now();
        DingTalkRequestParam param = DingTalkRequestParam.buildRequest(request);
        String urlWithQuery = HttpUtil.urlWithForm(url, param.getQueryParams(), StandardCharsets.UTF_8, false);
        String body = MapUtil.isEmpty(param.getBodyParams()) ? null : JSON.toJSONString(param.getBodyParams());

        HttpResponse response = null;
        if (isGet) {
            response = HttpRequest.get(urlWithQuery)
                    .body(body)
                    .execute();
        } else {
            response = HttpRequest.post(urlWithQuery)
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
     * 将响应结果转换为实体类实例
     * @param response 响应结果串
     * @param supplier 转换类
     * @param <T> 实体泛型
     * @return 实体实例
     * @author 小飞猪
     * @date 2020/12/21 16:43
     * @since 0.0.1
     */
    public static <T> CoreDingTalkResponse<T> convertResponse(String response, Supplier<TypeReference<CoreDingTalkResponse<T>>> supplier) {
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
