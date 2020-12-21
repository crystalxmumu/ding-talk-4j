package top.todev.ding.common.bean.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <p>获取部门列表响应实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-15 18:36
 * @since 0.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CoreDingTalkResponse<T> extends BaseDingTalkResponse<T> {
    private static final long serialVersionUID = -80374356675611799L;

    /** 部门列表。 */
    protected T result;

    @Override
    public T getData() {
        return this.result;
    }
}