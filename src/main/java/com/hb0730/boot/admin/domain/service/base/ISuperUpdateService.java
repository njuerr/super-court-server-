package com.hb0730.boot.admin.domain.service.base;

import com.hb0730.boot.admin.domain.model.dto.BaseDTO;
import org.springframework.lang.NonNull;

import java.io.Serializable;

/**
 * 基础service之修改,针对{@link com.hb0730.boot.admin.domain.controller.base.IBaseUpdateController}
 *
 * @param <DTO> 显示层对象类型
 * @param <ID>  id类型
 * @author Administrator
 * @since 3.0.0
 */
public interface ISuperUpdateService<ID extends Serializable, DTO extends BaseDTO> {
    /**
     * 根据修改删除
     *
     * @param id id
     * @param vo 修改参数
     * @return 是否成功
     */
    boolean updateById(@NonNull ID id, @NonNull DTO vo);
}
