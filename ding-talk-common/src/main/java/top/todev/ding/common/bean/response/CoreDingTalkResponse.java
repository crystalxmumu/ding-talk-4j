package top.todev.ding.common.bean.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.todev.tool.model.bean.CommonResultResponse;
import top.todev.tool.model.bean.IResultResponse;
import top.todev.tool.model.constant.IStaticDataEnum;

import static top.todev.tool.model.constant.BaseErrorCodeEnum.ERROR_CODE_0;

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

    /** 响应结果 */
    protected T result;

    @Override
    public T getData() {
        return this.result;
    }

    @Override
    public CoreDingTalkResponse<T> initSuccess(T data) {
        this.errCode = ERROR_CODE_0.getValue();
        this.result = data;
        return this;
    }
}
