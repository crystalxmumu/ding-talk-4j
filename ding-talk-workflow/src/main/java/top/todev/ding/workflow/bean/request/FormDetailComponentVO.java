package top.todev.ding.workflow.bean.request;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

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
public class FormDetailComponentVO implements Serializable {
    private static final long serialVersionUID = -6687953828254382368L;

    private String name;
    private String value;

    /**
     * 设置多选框的值
     * @param values 多个值
     * @return 表单附件控件
     */
    public FormDetailComponentVO setValueForMulti(String... values) {
        this.value = JSON.toJSONString(values);
        return this;
    }



    /**
     * 设置日期区间的名称及值
     * @param begin 开始日期
     * @param end 结束日期
     * @return 表单附件控件
     */
    public FormDetailComponentVO setValueForDateRange(LocalDate begin, LocalDate end) {
        this.name = JSON.toJSONString(new String[]{"开始时间", "结束时间"});
        this.value = JSON.toJSONString(new String[]{ISO_LOCAL_DATE.format(begin) , ISO_LOCAL_DATE.format(end)});
        return this;
    }
}
