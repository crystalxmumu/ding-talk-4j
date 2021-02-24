package top.todev.ding.common.constant.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.todev.tool.model.constant.IStaticDataEnum;

/**
 * <p>回调事件枚举</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 21:27
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum DingTalkEventTypeEnum implements IStaticDataEnum<String> {

    /** 测试回调URL事件 */
    check_url("check_url", "测试回调URL事件", "check_url"),
    /** 审批结果枚举 */
    bpms_task_change("bpms_task_change", "审批任务开始、结束、转交", "bpms_task_change"),
    bpms_instance_change("bpms_instance_change", "审批实例开始、结束", "bpms_instance_change");

    public static final String KEY_EVENT_TYPE = "EventType";
    /** 编码 */
    private final String code;
    /** 名称 */
    private final String cnName;
    /** 值 */
    private final String value;

    public static DingTalkEventTypeEnum queryByCode(String code) {
        return IStaticDataEnum.queryByCode(DingTalkEventTypeEnum.values(), code);
    }
}
