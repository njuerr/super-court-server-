package com.tingtu.ax.admin.project.fy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingtu.ax.admin.project.fy.entity.FyFaillogs;
import com.tingtu.ax.admin.project.fy.vo.FailLogVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FyFaillogsMapper  extends BaseMapper<FyFaillogs> {
    int deleteByPrimaryKey(Long id);

    @Insert(" insert into fy_faillogs (failid, reporttime, processtime,\n" +
        "      courtid, reportuser, processuser,\n" +
        "      failcontent, processcontent, deviceid,\n" +
        "      repair,del_flag)\n" +
        "    values (#{failid,jdbcType=LONGVARCHAR}, #{reporttime,jdbcType=LONGVARCHAR}, #{processtime,jdbcType=LONGVARCHAR},\n" +
        "      #{courtid,jdbcType=LONGVARCHAR}, #{reportuser,jdbcType=LONGVARCHAR}, #{processuser,jdbcType=LONGVARCHAR},\n" +
        "      #{failcontent,jdbcType=LONGVARCHAR}, #{processcontent,jdbcType=LONGVARCHAR}, #{deviceid,jdbcType=LONGVARCHAR},\n" +
        "      #{repair,jdbcType=LONGVARCHAR},#{delFlag})")
    int insert(FyFaillogs record);

    int insertSelective(FyFaillogs record);

    FyFaillogs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FyFaillogs record);

    @Update("    update fy_faillogs\n" +
        "    set failid = #{failid,jdbcType=LONGVARCHAR},\n" +
        "      reporttime = #{reporttime,jdbcType=LONGVARCHAR},\n" +
        "      processtime = #{processtime,jdbcType=LONGVARCHAR},\n" +
        "      courtid = #{courtid,jdbcType=LONGVARCHAR},\n" +
        "      reportuser = #{reportuser,jdbcType=LONGVARCHAR},\n" +
        "      processuser = #{processuser,jdbcType=LONGVARCHAR},\n" +
        "      failcontent = #{failcontent,jdbcType=LONGVARCHAR},\n" +
        "      processcontent = #{processcontent,jdbcType=LONGVARCHAR},\n" +
        "      deviceid = #{deviceid,jdbcType=LONGVARCHAR},\n" +
        "      repair = #{repair,jdbcType=LONGVARCHAR}\n" +
        "    where id = #{id,jdbcType=BIGINT}")
    int updateByPrimaryKey(FyFaillogs record);

    @Select("select ff.failid as failId,ff.reporttime as reportTime," +
        "ff.processtime as processTime, ff.reportuser as reportUser," +
        "fci.court_name as courtName,ff.processcontent as processContent, " +
        "ff.failcontent as failContent from fy_faillogs ff "
        + "left join fy_court_infors fci on fci.court_id = ff.courtid " +
        "where ff.courtid = #{id}")
    List<FailLogVo> getLogs(String id);

    @Select("select ff.*,fdi.device_name as deviceName,tsui.nick_name as reportUserName from fy_faillogs ff "
        + "left join fy_device_infors fdi on ff.deviceid = fdi.deviceid " +
        "left join t_sys_user_info tsui on ff.reportuser = tsui.id " +
        "where ff.courtid=#{courtId} and ff.repair= '0' order by ff.reporttime desc")
    List<FailLogVo> failRepair(String courtId);

    @Select("select  * from fy_faillogs where failid=#{failId}")
    FyFaillogs selectByFailId(@Param("failId") String failId);
}
