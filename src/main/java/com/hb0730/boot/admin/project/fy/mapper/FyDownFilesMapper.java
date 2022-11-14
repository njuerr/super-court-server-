package com.hb0730.boot.admin.project.fy.mapper;

import com.hb0730.boot.admin.project.fy.entity.FyDownFiles;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FyDownFilesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FyDownFiles record);

    int insertSelective(FyDownFiles record);

    FyDownFiles selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FyDownFiles record);

    int updateByPrimaryKey(FyDownFiles record);
}
