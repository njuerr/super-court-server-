package com.hb0730.boot.admin.project.system.dict.service;

import com.hb0730.boot.admin.domain.service.ISuperBaseService;
import com.hb0730.boot.admin.project.system.dict.model.dto.DictEntryDTO;
import com.hb0730.boot.admin.project.system.dict.model.entity.DictEntryEntity;
import com.hb0730.boot.admin.project.system.dict.model.query.DictEntryParams;

/**
 * 数据字典项  服务类
 *
 * @author Administrator
 * @since 3.0.0
 */
public interface IDictEntryService extends ISuperBaseService<Long, DictEntryParams, DictEntryDTO, DictEntryEntity> {

}
