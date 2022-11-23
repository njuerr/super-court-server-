package com.tingtu.ax.admin.commons.utils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.extra.validation.ValidationUtil;
import lombok.experimental.UtilityClass;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * 验证
 *
 * @author Administrator
 * @since 3.1.0
 */
@UtilityClass
public class ValidatorUtils {
    /**
     * 校验对象,如果不为空则抛出异常
     *
     * @param obj 校验对象
     */
    public void validate(Object obj) {
        Set<ConstraintViolation<Object>> validate = ValidationUtil.validate(obj);
        if (CollectionUtil.isNotEmpty(validate)) {
            throw new ConstraintViolationException(validate);
        }
    }
}
