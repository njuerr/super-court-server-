package com.tingtu.ax.admin.project.fy.mapper;

import com.tingtu.ax.admin.project.fy.entity.FyDeviceInfors;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FyDeviceInforsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FyDeviceInfors record);

    int insertSelective(FyDeviceInfors record);

    FyDeviceInfors selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FyDeviceInfors record);

    int updateByPrimaryKey(FyDeviceInfors record);

    @Select("select * from fy_device_infors where deviceid = #{id}")
    List<FyDeviceInfors> selectByDeviceId(@Param("id") String id);


    @Select("select * from fy_device_infors")
    List<FyDeviceInfors> selectListAll();
}
