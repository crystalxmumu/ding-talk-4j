package top.todev.ding.org.bean.response.v2.dept;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>员工在对应的部门中是否领导实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 10:03
 * @since 0.0.1
 */
@Data
public class DeptLeader implements Serializable {
    private static final long serialVersionUID = 3230783832611622311L;

    /**
     * 部门id
     */
    @JSONField(name = "dept_id")
    private Long deptId;
    /**
     * 是否领导
     */
    @JSONField(name = "leader")
    private Boolean leader;
}
