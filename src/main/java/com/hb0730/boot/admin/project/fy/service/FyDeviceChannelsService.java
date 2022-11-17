package com.hb0730.boot.admin.project.fy.service;

import com.hb0730.boot.admin.project.fy.entity.FyDeviceChannels;
import com.hb0730.boot.admin.project.fy.entity.FyDeviceInfors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.hb0730.boot.admin.project.fy.mapper.FyDeviceChannelsMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class FyDeviceChannelsService{

    @Resource
    private FyDeviceChannelsMapper fyDeviceChannelsMapper;
    @Autowired
    private FyDeviceInforsService fyDeviceInforsService;


    public int deleteByPrimaryKey(Long id) {
        return fyDeviceChannelsMapper.deleteByPrimaryKey(id);
    }


    public int insert(FyDeviceChannels record) {
        return fyDeviceChannelsMapper.insert(record);
    }


    public int insertSelective(FyDeviceChannels record) {
        return fyDeviceChannelsMapper.insertSelective(record);
    }


    public FyDeviceChannels selectByPrimaryKey(Long id) {
        return fyDeviceChannelsMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(FyDeviceChannels record) {
        return fyDeviceChannelsMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(FyDeviceChannels record) {
        return fyDeviceChannelsMapper.updateByPrimaryKey(record);
    }

    public List<FyDeviceChannels> selectByDeviceId(String deviceId) {
       return fyDeviceChannelsMapper.selectByDeviceId(deviceId);
    }

    public List<String> getMater(String courtId) {
        List<FyDeviceInfors> fyDeviceInfors = fyDeviceInforsService.selectByCourtId(courtId);
        List<FyDeviceChannels> fyDeviceChannels = fyDeviceChannelsMapper.selectByDeviceId(fyDeviceInfors.get(0).getDeviceid());
        List<String> res = new ArrayList<>();
        fyDeviceChannels.forEach(i ->{
            res.add(i.getChannelCode());
        });
        return res;
    }
}
