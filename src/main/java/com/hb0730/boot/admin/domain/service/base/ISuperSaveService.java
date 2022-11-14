package com.hb0730.boot.admin.domain.service.base;

import com.hb0730.boot.admin.domain.model.dto.BaseDTO;
import org.springframework.lang.NonNull;

/**
 * 扩展MybatisPlus保存，针对{@link com.hb0730.boot.admin.domain.controller.base.IBaseSaveController}
 *
 * @param <DTO> 显示层对象类型
 * @author Administrator
 * @since 3.0.0
 */
public interface ISuperSaveService<DTO extends BaseDTO> {
    /**
     * 保存
     *
     * @param vo 信息
     * @return 是否成功
     */
    boolean save(@NonNull DTO vo);
}
