package com.tingtu.ax.admin.commons.enums;

/**
 * 排序类型
 *
 * @author Administrator
 * @since 3.0.0
 */
public enum SortTypeEnum implements ValueEnum<String> {
    /**
     * 降序
     */
    DESC("DESC"),
    /**
     * 升序
     */
    ASC("ASC");

    private final String value;

    SortTypeEnum(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
