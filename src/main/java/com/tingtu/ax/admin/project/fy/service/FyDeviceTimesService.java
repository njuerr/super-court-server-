package com.tingtu.ax.admin.project.fy.service;

import com.tingtu.ax.admin.project.fy.entity.FyDeviceTimes;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.tingtu.ax.admin.project.fy.mapper.FyDeviceTimesMapper;

import java.util.Date;

@Service
public class FyDeviceTimesService{

    @Resource
    private FyDeviceTimesMapper fyDeviceTimesMapper;

    @Resource
    private FyCourtInforsService fyCourtInforsService;


    public int deleteByPrimaryKey(Integer id) {
        return fyDeviceTimesMapper.deleteByPrimaryKey(id);
    }


    public int insert(FyDeviceTimes record) {
        return fyDeviceTimesMapper.insert(record);
    }


    public int insertSelective(FyDeviceTimes record) {
        return fyDeviceTimesMapper.insertSelective(record);
    }


    public FyDeviceTimes selectByPrimaryKey(Integer id) {
        return fyDeviceTimesMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(FyDeviceTimes record) {
        return fyDeviceTimesMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(FyDeviceTimes record) {
        return fyDeviceTimesMapper.updateByPrimaryKey(record);
    }
    public int updateOutLine(FyDeviceTimes record) {
        return fyDeviceTimesMapper.updateOutLine(record);
    }

    public void online(Integer courtId) {
        FyDeviceTimes record = new FyDeviceTimes();
        record.setDeviceId(courtId.toString());
        record.setOnlineTime(new Date());
        insert(record);
        fyCourtInforsService.online(courtId);
    }


    public void outline(Integer courtId) {
        FyDeviceTimes fyDeviceTimes = fyDeviceTimesMapper.selectCourt(courtId);
        if (fyDeviceTimes!=null){
            fyDeviceTimes.setOutlineTime(new Date());
            updateOutLine(fyDeviceTimes);
            fyCourtInforsService.outline(courtId);
        }
    }
}
