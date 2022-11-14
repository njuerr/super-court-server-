package com.hb0730.boot.admin.project.fy.mapper;

import com.hb0730.boot.admin.project.fy.entity.FyCourtInfors;
import com.hb0730.boot.admin.project.fy.entity.FyDeviceInfors;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface FyCourtInforsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FyCourtInfors record);

    int insertSelective(FyCourtInfors record);

    FyCourtInfors selectByPrimaryKey(Long id);

    @Select("select * from fy_court_infors where id = #{id}")
    FyCourtInfors selectById(@Param("id") Long id);


    int updateByPrimaryKeySelective(FyCourtInfors record);

    @Update("update fy_court_infors\n" +
        "    set court_id = #{courtId,jdbcType=LONGVARCHAR},\n" +
        "      court_zone = #{courtZone,jdbcType=LONGVARCHAR},\n" +
        "      court_name = #{courtName,jdbcType=LONGVARCHAR},\n" +
        "      court_state = #{courtState,jdbcType=LONGVARCHAR},\n" +
        "      court_sort = #{courtSort,jdbcType=BIGINT}\n" +
        "    where id = #{id,jdbcType=BIGINT}")
    int updateByPrimaryKey(FyCourtInfors record);

    @Select("select * from fy_court_infors")
    List<FyCourtInfors> selectListAll();

    @Select("select * from fy_court_infors where court_zone=#{zoneId}")
    List<FyCourtInfors> selectByZoneId(@Param("zoneId") String zoneId);
}
