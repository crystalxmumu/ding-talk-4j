package top.todev.ding.workflow.bean.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>表单附件控件</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 14:22
 * @since 0.0.1
 */
@Data
@Accessors(chain = true)
public class FormAttachmentComponentVO implements Serializable {
    private static final long serialVersionUID = -6687953828254382368L;

    private String spaceId;
    private String fileName;
    private String fileSize;
    private String fileType;
    private String fileId;
}
