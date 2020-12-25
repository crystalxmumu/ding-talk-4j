package top.todev.ding.org.bean.request.v2.dept;

import lombok.Builder;
import lombok.Data;
import top.todev.ding.common.annotation.RequestParam;
import top.todev.ding.common.constant.data.LangEnum;

import java.io.Serializable;

/**
 * <p>获取部门详情请求实体</p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 10:32
 * @since 0.0.1
 */
@Data
@Builder
public class OapiV2DepartmentGetRequest implements Serializable {
    private static final long serialVersionUID = 6447833513907421186L;

    /**
     * 部门id，根部门ID为1
     */
    @RequestParam(key = "dept_id")
    private Long deptId;

    /**
     * 通讯录语言（默认zh_CN）
     */
    private LangEnum language;
}
