package com.hb0730.boot.admin.annotation;

import com.hb0730.boot.admin.aspectj.FieldInfoAspectj;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author Administrator
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface FieldClass {

    /**
     * 需要排除的表字段
     *
     * @return 需要排除的表字段
     */
    String[] exclude() default "";
}
