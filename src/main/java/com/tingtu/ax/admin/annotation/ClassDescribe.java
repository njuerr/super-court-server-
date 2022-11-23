package com.tingtu.ax.admin.annotation;

import java.lang.annotation.*;


/**
 * @author Administrator
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ClassDescribe {
    String value() default "";
}
