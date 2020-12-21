package top.todev.ding.common.bean.response;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import top.todev.tool.model.bean.IResultResponse;

import java.io.Serializable;

/**
 * <p>
 * 钉钉Api基础相应类
 * </p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/9/4 10:18
 * @since 0.0.1
 */
@Data
public abstract class BaseDingTalkResponse<T> implements Serializable, IResultResponse<T> {
    private static final long serialVersionUID = -7964977655580784429L;

    public static final String SUCCESS = "0";

    /** API状态码 */
    @JSONField(name = "errcode")
    protected String errCode;
    /** API状态码 */
    @JSONField(name = "errmsg")
    protected String errMsg;

    @Override
    public Boolean getSuccess() {
        return StrUtil.equals(this.errCode, SUCCESS);
    }

    @Override
    public String getMessage() {
        return this.errMsg;
    }

    @Override
    public String getCode() {
        return this.errCode;
    }
}
