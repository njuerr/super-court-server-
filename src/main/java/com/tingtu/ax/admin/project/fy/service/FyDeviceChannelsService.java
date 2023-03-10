package com.tingtu.ax.admin.project.fy.service;

import com.tingtu.ax.admin.project.fy.entity.FyDeviceChannels;
import com.tingtu.ax.admin.project.fy.entity.FyDeviceInfors;
import com.tingtu.ax.admin.project.fy.mapper.FyDeviceChannelsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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

    public String getChannelName(String channelCode, String courtId){
        List<FyDeviceInfors> fyDeviceInfors = fyDeviceInforsService.selectByCourtId(courtId);
        List<FyDeviceChannels> fyDeviceChannels = fyDeviceChannelsMapper.selectByDeviceId(fyDeviceInfors.get(0).getDeviceid());
        AtomicReference<String> channelName= new AtomicReference<>("");
        fyDeviceChannels.forEach(i ->{
           if (i.getChannelCode().equals(channelCode)){
               channelName.set(i.getChannelName());
           }
        });
        return channelName.get();
    }
}
