package top.todev.ding.org.bean.response.v1.report;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>日志内容实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-21 15:38
 * @since 0.0.1
 */
@Data
public class OapiReportContentVo implements Serializable {

    private static final long serialVersionUID = -7707334266919068256L;
    /**
     * 模板内容
     */
    private String key;
    /**
     * 排序
     */
    private String sort;
    /**
     * 类型
     */
    private String type;
    /**
     * 用户填写的内容
     */
    private String value;
}
