package com.hb0730.boot.admin.project.fy.mapper;

import com.hb0730.boot.admin.project.fy.entity.FySystemlogs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FySystemlogsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FySystemlogs record);

    int insertSelective(FySystemlogs record);

    FySystemlogs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FySystemlogs record);

    int updateByPrimaryKey(FySystemlogs record);
}
