package com.tingtu.ax.admin.project.system.dict.service;

import com.tingtu.ax.admin.domain.service.ISuperBaseService;
import com.tingtu.ax.admin.project.system.dict.model.dto.DictDTO;
import com.tingtu.ax.admin.project.system.dict.model.entity.DictEntity;
import com.tingtu.ax.admin.project.system.dict.model.query.DictParams;
import com.tingtu.ax.admin.project.system.dict.model.vo.DictVO;

import java.util.List;

/**
 * 数据字典  服务类
 *
 * @author Administrator
 * @since 数据字典
 */
public interface IDictService extends ISuperBaseService<Long, DictParams, DictDTO, DictEntity> {
    /**
     * 更新缓存
     */
    void updateCache();

    /**
     * 获取缓存
     *
     * @return 缓存值
     */
    List<DictVO> getCache();
}
