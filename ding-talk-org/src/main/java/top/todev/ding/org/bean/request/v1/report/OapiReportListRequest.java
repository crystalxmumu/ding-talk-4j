package top.todev.ding.org.bean.request.v1.report;

import lombok.Builder;
import lombok.Data;
import top.todev.ding.common.annotation.RequestParam;

import java.io.Serializable;

/**
 * <p>获取用户发出的日志列表请求</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-21 18:38
 * @since 0.0.1
 */
@Data
@Builder
public class OapiReportListRequest implements Serializable {

	private static final long serialVersionUID = 6227920414098499028L;

	/** 查询的日志创建的开始时间，Unix时间戳，单位毫秒。必填：是。示例：1507564800000 */
	@RequestParam(key = "start_time")
	private Long startTime;
	/** 查询的日志创建的结束时间，Unix时间戳，单位毫秒。必填：是。示例：1507564800000 */
	@RequestParam(key = "end_time")
	private Long endTime;
	/** 要查询的模板名称。必填：否。示例：周报 */
	@RequestParam(key = "template_name")
	private String templateName;
	/** 员工的userid。必填：否。示例：user123 */
	@RequestParam(key = "userid")
	private String userId;
	/** 查询游标，初始传入0，后续从上一次的返回值中获取。必填：是。示例：0 */
	private Long cursor;
	/** 每页数据量，最大值为20。必填：是。示例：10 */
	private Long size;
	/** 查询的日志修改的开始时间，Unix时间戳，单位毫秒。必填：否。示例：1507564800000 */
	@RequestParam(key = "modified_start_time")
	private Long modifiedStartTime;
	/** 查询的日志修改的结束时间，Unix时间戳，单位毫秒必填：否。示例：1507564800000 */
	@RequestParam(key = "modified_end_time")
	private Long modifiedEndTime;

}