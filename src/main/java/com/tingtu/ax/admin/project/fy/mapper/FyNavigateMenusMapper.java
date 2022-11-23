package com.tingtu.ax.admin.project.fy.mapper;

import com.tingtu.ax.admin.project.fy.entity.FyNavigateMenus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FyNavigateMenusMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FyNavigateMenus record);

    int insertSelective(FyNavigateMenus record);

    FyNavigateMenus selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FyNavigateMenus record);

    int updateByPrimaryKey(FyNavigateMenus record);
}
