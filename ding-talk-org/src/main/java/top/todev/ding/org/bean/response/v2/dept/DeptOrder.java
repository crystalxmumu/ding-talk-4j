package top.todev.ding.org.bean.response.v2.dept;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>员工在对应的部门中的排序实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-24 10:01
 * @since 0.0.1
 */
@Data
public class DeptOrder implements Serializable {
    private static final long serialVersionUID = -3800292878218689419L;

    /**
     * 部门id
     */
    @JSONField(name = "dept_id")
    private Long deptId;
    /**
     * 员工在部门中的排序。
     */
    @JSONField(name = "order")
    private Long order;
}
