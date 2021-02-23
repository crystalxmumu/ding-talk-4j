package top.todev.ding.workflow.bean.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static cn.hutool.core.date.DatePattern.NORM_DATETIME_FORMATTER;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

/**
 * <p>审批流表单参数实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-23 14:02
 * @since 0.0.1
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class FormComponentValueVO implements Serializable {
    private static final long serialVersionUID = -8754387724875804263L;

    /**  组件ID。示例：DDHolidayField-J2Bxxxx。 */
    @JSONField(serialize = false)
    private String id;
    /** 组件类型。 示例：DDSelectField。 */
    @JSONField(name = "component_type", serialize = false)
    private String componentType;
    /** 表单每一栏的名称。示例：请假类型 */
    @NonNull
    private String name;
    /** 表单每一栏的值。示例：事假 */
    @NonNull
    private String value;
    /** 扩展值。示例：总天数:1 */
    @JSONField(name = "ext_value")
    private String extValue;

    /**
     * 设置附件的值。适用：附件。
     * @param attachments 附件列表
     * @return 审批流表单参数实体
     */
    public FormComponentValueVO setValueForAttachment(List<FormAttachmentComponentVO> attachments) {
        this.value = JSON.toJSONString(attachments);
        return this;
    }

    /**
     * 设置多选框的值。适用：图片。
     * @param values 多个值
     * @return 表单附件控件
     */
    public FormComponentValueVO setValueForMulti(String... values) {
        this.value = JSON.toJSONString(values);
        return this;
    }

    /**
     * 设置多选框的值。适用：图片。
     * @param values 多个值
     * @return 表单附件控件
     */
    public FormComponentValueVO setValueForMulti(List<String> values) {
        this.value = JSON.toJSONString(values);
        return this;
    }

    /**
     * 设置明细的值。适用：多选框、联系人。
     * @param value 值
     * @return 表单附件控件
     */
    public FormComponentValueVO setValueForDetail(FormDetailComponentVO value) {
        this.value = JSON.toJSONString(value);
        return this;
    }

    /**
     * 设置明细的值。适用：关联审批单。
     * @param values 多个值
     * @return 表单附件控件
     */
    public FormComponentValueVO setValueForDetailMulti(List<FormDetailComponentVO> values) {
        this.value = JSON.toJSONString(values);
        return this;
    }

    /**
     * 设置明细的值。适用：明细。
     * @param values 多个值
     * @return 表单附件控件
     */
    public FormComponentValueVO setValueForDetailNested(List<List<FormDetailComponentVO>> values) {
        this.value = JSON.toJSONString(values);
        return this;
    }

    /**
     * 设置日期的值。适用：日期。
     * @param date 日期
     * @return 表单附件控件
     */
    public FormComponentValueVO setValueForDate(LocalDate date) {
        this.value = ISO_LOCAL_DATE.format(date);
        return this;
    }

    /**
     * 设置时间的值。适用：日期。
     * @param time 时间
     * @return 表单附件控件
     */
    public FormComponentValueVO setValueForTime(LocalDateTime time) {
        this.value = NORM_DATETIME_FORMATTER.format(time);
        return this;
    }
}
