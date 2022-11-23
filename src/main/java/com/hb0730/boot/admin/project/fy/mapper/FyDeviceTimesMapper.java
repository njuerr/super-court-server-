package com.hb0730.boot.admin.project.fy.mapper;

import com.hb0730.boot.admin.project.fy.entity.FyDeviceTimes;
import org.apache.ibatis.annotations.*;

@Mapper
public interface FyDeviceTimesMapper {
    int deleteByPrimaryKey(Integer id);

    @Insert("    insert into fy_device_times (device_id, online_time, outline_time\n" +
        "      )\n" +
        "    values (#{deviceId,jdbcType=VARCHAR}, #{onlineTime,jdbcType=TIMESTAMP}, #{outlineTime,jdbcType=TIMESTAMP}\n" +
        "      )")
    int insert(FyDeviceTimes record);

    int insertSelective(FyDeviceTimes record);

    FyDeviceTimes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FyDeviceTimes record);

    @Update("    update fy_device_times\n" +
        "    set device_id = #{deviceId,jdbcType=VARCHAR},\n" +
        "      online_time = #{onlineTime,jdbcType=TIMESTAMP},\n" +
        "      outline_time = #{outlineTime,jdbcType=TIMESTAMP}\n" +
        "    where id = #{id,jdbcType=INTEGER}")
    int updateByPrimaryKey(FyDeviceTimes record);

    @Select("select * from fy_device_times where device_id=#{courtId} and outline_time is null")
    FyDeviceTimes selectCourt(@Param("courtId") Integer courtId);
}
