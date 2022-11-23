package com.tingtu.ax.admin.project.fy.mapper;

import com.tingtu.ax.admin.project.fy.entity.FyZoneInfors;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FyZoneInforsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FyZoneInfors record);

    int insertSelective(FyZoneInfors record);

    FyZoneInfors selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FyZoneInfors record);

    int updateByPrimaryKey(FyZoneInfors record);

    @Select("select * from fy_zone_infors")
    List<FyZoneInfors> getAllList();
}
