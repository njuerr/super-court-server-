package com.hb0730.boot.admin.project.fy.service;

import com.hb0730.boot.admin.project.fy.entity.FyDeviceChannels;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.hb0730.boot.admin.project.fy.mapper.FyDeviceChannelsMapper;

import java.util.List;

@Service
public class FyDeviceChannelsService{

    @Resource
    private FyDeviceChannelsMapper fyDeviceChannelsMapper;


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
}
