package com.tingtu.ax.admin.annotation;

import java.lang.annotation.*;



/**
 * 属性描述
 * @author Administrator
 */
@Documented
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface FieldInfo {
    /**
     * 属性名称
     *
     * @return 属性名称
     */
    String name() default "";

    /**
     * 表字段
     *
     * @return 表字段
     */
    String columnName() default "";
}
