package com.tingtu.ax.admin.project.fy.mapper;

import com.tingtu.ax.admin.project.fy.entity.FyCourtInfors;
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

    @Select("select * from fy_court_infors left join fy_zone_infors on fy_zone_infors.zone_id= fy_court_infors.court_zone " +
        "where fy_court_infors.court_id=#{id} and fy_zone_infors.zone_id=#{zone}")
    List<FyCourtInfors> selectByCourtId(@Param("id") Integer id, @Param("zone") String zone);
}
