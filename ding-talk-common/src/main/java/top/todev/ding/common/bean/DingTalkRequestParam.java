package top.todev.ding.common.bean;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.PropDesc;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Builder;
import lombok.Data;
import top.todev.ding.common.annotation.ParamType;
import top.todev.ding.common.annotation.RequestParam;
import top.todev.tool.model.constant.IStaticDataEnum;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static top.todev.ding.common.annotation.ParamType.QUERY;

/**
 * <p>钉钉请求参数实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-15 14:48
 * @since 0.0.1
 */
@Data
@Builder
public class DingTalkRequestParam implements Serializable {

    private static final long serialVersionUID = 3483857267619099752L;
    /** Query参数 */
    private Map<String, Object> queryParams;
    /** Body参数 */
    private Map<String, Object> bodyParams;

    public static DingTalkRequestParam buildRequest(Object bean) {
        Map<String, Object> queryParams = new HashMap<>();
        Map<String, Object> bodyParams = new HashMap<>();
        if (bean != null) {
            final Collection<PropDesc> props = BeanUtil.getBeanDesc(bean.getClass()).getProps();

            String key;
            Method getter;
            Field field;
            Object value;
            for (PropDesc prop : props) {
                key = prop.getFieldName();
                field = prop.getField();
                boolean isBody = true;
                boolean isConvertBool = false;
                if (AnnotationUtil.hasAnnotation(field, RequestParam.class)) {
                    ParamType type = AnnotationUtil.getAnnotationValue(field, RequestParam.class, "type");
                    if (QUERY.equals(type)) {
                        isBody = false;
                    }
                    String keyAlias = AnnotationUtil.getAnnotationValue(field, RequestParam.class, "key");
                    if (StrUtil.isNotBlank(keyAlias)) {
                        key = keyAlias;
                    }
                    isConvertBool = AnnotationUtil.getAnnotationValue(field, RequestParam.class, "isConvertBool");
                }
                // 过滤class属性
                // 得到property对应的getter方法
                getter = prop.getGetter();
                if (null != getter) {
                    // 只读取有getter方法的属性
                    try {
                        value = getter.invoke(bean);
                    } catch (Exception ignore) {
                        continue;
                    }
                    if (null != value && !value.equals(bean)) {
                        if (value instanceof IStaticDataEnum) {
                            //noinspection rawtypes
                            value = ((IStaticDataEnum) value).getValue();
                        }
                        if (value instanceof Boolean && isConvertBool) {
                            value = BooleanUtil.toInt((Boolean) value);
                        }
                        if (isBody) {
                            bodyParams.put(key, value);
                        } else {
                            queryParams.put(key, value);
                        }
                    }
                }
            }
        }
        return DingTalkRequestParam.builder().bodyParams(bodyParams).queryParams(queryParams).build();
    }
}
