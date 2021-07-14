package top.todev.ding.common.annotation;

import java.lang.annotation.*;

import static top.todev.ding.common.annotation.ParamType.BODY;

/**
 * <p>请求参数注解。注意该注解目前不支持递归使用。</p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-15 11:07
 * @since 0.0.1
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestParam {

    /**
     * <p>获取请求参数类型。</p>
     * @return 请求参数类型
     */
    ParamType type() default BODY;

    /**
     * <p>获取参数名。参数名为空时，默认使用属性名</p>
     * @return 参数名
     */
    String key() default "";

    /**
     * <p>是否转换布尔值：0 / false,1 / true</p>
     * @return 布尔值
     */
    boolean isConvertBool() default false;
}
