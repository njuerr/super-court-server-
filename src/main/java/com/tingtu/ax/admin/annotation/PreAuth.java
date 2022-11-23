package com.tingtu.ax.admin.annotation;

import java.lang.annotation.*;


/**
 * 权限注解
 * @author Administrator
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PreAuth {
    String value() default "";
}
