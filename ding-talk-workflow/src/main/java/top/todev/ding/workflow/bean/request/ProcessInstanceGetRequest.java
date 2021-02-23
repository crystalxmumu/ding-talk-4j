package top.todev.ding.workflow.bean.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;
import top.todev.ding.workflow.constant.data.WorkflowCopyPositionEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>获取审批实例详情请求实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 10:24
 * @since 0.0.1
  */
@Data
@Accessors(chain = true)
public class ProcessInstanceGetRequest implements Serializable {

    private static final long serialVersionUID = 4435835515281364913L;

    /** 审批实例ID，可通过获取审批实例ID列表接口获取。示例：1a2b-3e4dxxxx */
    @JSONField(name = "process_instance_id")
    private String processInstanceId;

}
