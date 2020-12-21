package top.todev.ding.common.constant.data;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import top.todev.tool.model.constant.IStaticDataEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 多语言枚举类
 * </p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/9/4 19:42
 * @since 0.0.1
 */
@Getter
public enum LangEnum implements IStaticDataEnum<String> {

    /** 简体中文 */
    LANGUAGE_ZH_CN("LANGUAGE_ZH_CN", "简体中文", "zh_CN", "zh-hans"),
    /** 英文 */
    LANGUAGE_EN_US("LANGUAGE_EN_US", "英文", "en_US"),
    ;

    /** 编码 */
    private final String code;
    /** 名称 */
    private final String cnName;
    /** 值 */
    private final String value;
    /** 值 */
    private final List<String> values;

    LangEnum(String code, String cnName, String value, String... values) {
        this.code = code;
        this.cnName = cnName;
        this.value = value;
        this.values = new ArrayList<>(Arrays.asList(values));
        if (!this.values.contains(this.value)) {
            this.values.add(this.value);
        }
    }

    /**
     * 根据语言码查询语言枚举
     * @param value 语言码
     * @return 语言枚举
     */
    public static LangEnum queryLangByValue(String value) {
        LangEnum[] sdds = LangEnum.values();
        if (StrUtil.isNotBlank(value)) {
            for (LangEnum sdd : sdds) {
                if (sdd.getValues().contains(value)) {
                    return sdd;
                }
            }
        }
        return null;
    }
}
