package top.todev.ding.org.bean.request.v2.dept;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.todev.ding.common.annotation.RequestParam;
import top.todev.ding.common.bean.request.BaseDingTalkRequest;
import top.todev.ding.common.constant.data.LangEnum;

import java.io.Serializable;

/**
 * <p>获取部门列表请求实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-15 18:28
 * @since 0.0.1
 */
@Data
@Builder
public class OapiV2DepartmentListSubRequest implements Serializable {
    private static final long serialVersionUID = -195197028005938414L;

    /** 父部门ID。如果不传，默认部门为根部门，根部门ID为1。只支持查询下一级子部门，不支持查询多级子部门。 */
    @RequestParam(key = "dept_id")
    private Integer deptId;

    /** 通讯录语言：zh_CN（默认）：中文; en_US：英文 */
    private LangEnum language;
}
