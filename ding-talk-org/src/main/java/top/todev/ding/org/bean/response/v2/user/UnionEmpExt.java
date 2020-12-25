package top.todev.ding.org.bean.response.v2.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>关联信息</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 10:05
 * @since 0.0.1
 */
@Data
public class UnionEmpExt implements Serializable {
    private static final long serialVersionUID = -6194679664128034190L;

    /**
     * 企业id
     */
    @JSONField(name = "corp_id")
    private String corpId;
    /**
     * 员工id
     */
    @JSONField(name = "userid")
    private String userid;
    /**
     * 关联映射关系
     */
    @JSONField(name = "union_emp_map_list")
    private List<UnionEmpMapVo> unionEmpMapList;
}
