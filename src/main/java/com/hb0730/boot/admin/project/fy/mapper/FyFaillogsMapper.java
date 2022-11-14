package com.hb0730.boot.admin.project.fy.mapper;

import com.hb0730.boot.admin.project.fy.entity.FyFaillogs;
import com.hb0730.boot.admin.project.fy.vo.FailLogVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FyFaillogsMapper {
    int deleteByPrimaryKey(Long id);

    @Insert(" insert into fy_faillogs (failid, reporttime, processtime,\n" +
        "      courtid, reportuser, processuser,\n" +
        "      failcontent, processcontent, deviceid,\n" +
        "      repair)\n" +
        "    values (#{failid,jdbcType=LONGVARCHAR}, #{reporttime,jdbcType=LONGVARCHAR}, #{processtime,jdbcType=LONGVARCHAR},\n" +
        "      #{courtid,jdbcType=LONGVARCHAR}, #{reportuser,jdbcType=LONGVARCHAR}, #{processuser,jdbcType=LONGVARCHAR},\n" +
        "      #{failcontent,jdbcType=LONGVARCHAR}, #{processcontent,jdbcType=LONGVARCHAR}, #{deviceid,jdbcType=LONGVARCHAR},\n" +
        "      #{repair,jdbcType=LONGVARCHAR})")
    int insert(FyFaillogs record);

    int insertSelective(FyFaillogs record);

    FyFaillogs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FyFaillogs record);

    int updateByPrimaryKey(FyFaillogs record);

    @Select("select ff.failid as failId,ff.reporttime as reportTime," +
        "ff.processtime as processTime, ff.reportuser as reportUser," +
        "fci.court_name as courtName,ff.processcontent as processContent, " +
        "ff.failcontent as failContent from fy_faillogs ff "
        + "left join fy_court_infors fci on fci.court_id = ff.courtid " +
        "where ff.courtid = #{id}")
    List<FailLogVo> getLogs(String id);

    @Select("select * from fy_faillogs where courtid=#{courtId} and repair= '0'")
    List<FyFaillogs> failRepair(String courtId);
}
