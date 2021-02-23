package top.todev.ding.workflow.constant.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.todev.tool.model.constant.IStaticDataEnum;

/**
 * <p>工作流抄送节点</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 14:08
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum WorkflowCopyPositionEnum implements IStaticDataEnum<String> {

    /** 开始 */
    START("START", "开始", "START"),
    /** 结束 */
    FINISH("FINISH", "结束", "FINISH"),
    /** 开始和结束 */
    START_FINISH("START_FINISH", "开始和结束", "START_FINISH");


    /** 编码 */
    private final String code;
    /** 名称 */
    private final String cnName;
    /** 值 */
    private final String value;
}
