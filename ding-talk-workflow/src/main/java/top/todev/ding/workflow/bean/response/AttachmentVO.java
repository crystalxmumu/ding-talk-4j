package top.todev.ding.workflow.bean.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>评论附件实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 21:03
 * @since 0.0.1
 */
@Data
@Accessors(chain = true)
public class AttachmentVO implements Serializable {
    private static final long serialVersionUID = 7832042721209851771L;

    /** 附件名称。示例：学历证明。 */
    @JSONField(name = "file_name")
    private String fileName;
    /** 附件大小。示例：11890851。 */
    @JSONField(name = "file_size")
    private String fileSize;
    /** 附件ID。示例：22581233705。 */
    @JSONField(name = "file_id")
    private String fileId;
    /** 附件类型示例：pdf。 */
    @JSONField(name = "file_type")
    private String fileType;
}
