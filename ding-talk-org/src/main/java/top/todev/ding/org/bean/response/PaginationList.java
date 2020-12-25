package top.todev.ding.org.bean.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>分页数据类</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-21 15:29
 * @since 0.0.1
 */
@Data
public class PaginationList<T> implements Serializable {

    private static final long serialVersionUID = 952991936681305310L;
    /**
     * 日志列表
     */
    @JSONField(name = "list")
    private List<T> dataList;
    /**
     * 是否还有下一页
     */
    @JSONField(name = "has_more")
    private Boolean hasMore;
    /**
     * nextCursor
     */
    @JSONField(name = "next_cursor")
    private Long nextCursor;
}
