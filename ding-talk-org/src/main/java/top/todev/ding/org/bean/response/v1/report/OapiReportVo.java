package top.todev.ding.org.bean.response.v1.report;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>日志数据实体</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-21 15:32
 * @since 0.0.1
 */
@Data
public class OapiReportVo implements Serializable {

    private static final long serialVersionUID = -2371530628795834540L;
    /**
     * 日志唯一id
     */
    @JSONField(name = "report_id")
    private String reportId;
    /**
     * 日志模板名
     */
    @JSONField(name = "template_name")
    private String templateName;
    /**
     * 部门
     */
    @JSONField(name = "dept_name")
    private String deptName;
    /**
     * 日志创建人userid
     */
    @JSONField(name = "creator_id")
    private String creatorId;
    /**
     * 日志创建人
     */
    @JSONField(name = "creator_name")
    private String creatorName;
    /**
     * 日志创建时间
     */
    @JSONField(name = "create_time")
    private Long createTime;
    /**
     * 日志修改时间
     */
    @JSONField(name = "modified_time")
    private Long modifiedTime;
    /**
     * 备注
     */
    private String remark;
    /**
     * 日志内容
     */
    private List<OapiReportContentVo> contents;
    /**
     * 日志图片列表
     */
    private List<String> images;
    /**
     * 提交日志时点击获取位置，定位到的纬度（没有获取位置则为空），此字段的值默认为空，需要单独申请开通
     */
    private String latitude;
    /**
     * 提交日志时点击获取位置，定位到的经度（没有获取位置则为空），此字段的值默认为空，需要单独申请开通
     */
    private String longitude;
}
