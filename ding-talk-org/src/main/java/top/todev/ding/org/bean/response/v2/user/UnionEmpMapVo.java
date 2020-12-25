package top.todev.ding.org.bean.response.v2.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>关联映射关系</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 10:06
 * @since 0.0.1
 */
@Data
public class UnionEmpMapVo implements Serializable {
    private static final long serialVersionUID = 5230873243368201216L;

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
}
