package com.tingtu.ax.admin.project.system.post.service;

import com.tingtu.ax.admin.domain.service.ISuperBaseService;
import com.tingtu.ax.admin.domain.service.base.ISuperPoiService;
import com.tingtu.ax.admin.project.system.post.model.dto.PostDTO;
import com.tingtu.ax.admin.project.system.post.model.dto.PostExcelDTO;
import com.tingtu.ax.admin.project.system.post.model.entity.PostEntity;
import com.tingtu.ax.admin.project.system.post.model.query.PostParams;

/**
 * 岗位  服务类
 *
 * @author Administrator
 * @since 3.0.0
 */
public interface IPostService extends ISuperBaseService<Long, PostParams, PostDTO, PostEntity>, ISuperPoiService<PostParams, PostExcelDTO> {

}
