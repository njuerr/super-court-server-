package com.hb0730.boot.admin.project.fy.mapper;

import com.hb0730.boot.admin.project.fy.entity.FyDeviceTimes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FyDeviceTimesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FyDeviceTimes record);

    int insertSelective(FyDeviceTimes record);

    FyDeviceTimes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FyDeviceTimes record);

    int updateByPrimaryKey(FyDeviceTimes record);
}
