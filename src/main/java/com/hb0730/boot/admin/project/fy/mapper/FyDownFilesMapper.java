package com.hb0730.boot.admin.project.fy.mapper;

import com.hb0730.boot.admin.project.fy.entity.FyDownFiles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FyDownFilesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FyDownFiles record);

    int insertSelective(FyDownFiles record);

    @Select("select * from fy_down_files where id=#{id}")
    FyDownFiles selectByPrimaryKey(@Param("id") Long id);

    int updateByPrimaryKeySelective(FyDownFiles record);

    int updateByPrimaryKey(FyDownFiles record);

    @Select("select * from fy_down_files where courtid=#{courtId}")
    List<FyDownFiles> selectByCourtId(@Param("courtId") String courtId);
}
