package com.tingtu.ax.admin.project.fy.mapper;

import com.tingtu.ax.admin.project.fy.entity.FyDeviceChannels;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FyDeviceChannelsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FyDeviceChannels record);

    int insertSelective(FyDeviceChannels record);

    FyDeviceChannels selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FyDeviceChannels record);

    int updateByPrimaryKey(FyDeviceChannels record);

    @Select("select * from fy_device_channels where deviceid=#{deviceId}")
    List<FyDeviceChannels> selectByDeviceId(String deviceId);
}
