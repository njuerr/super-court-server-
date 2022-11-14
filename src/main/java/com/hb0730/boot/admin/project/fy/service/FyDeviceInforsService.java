package com.hb0730.boot.admin.project.fy.service;

import com.hb0730.boot.admin.project.fy.entity.FyDeviceInfors;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.hb0730.boot.admin.project.fy.mapper.FyDeviceInforsMapper;

import java.util.List;

@Service
public class FyDeviceInforsService{

    @Resource
    private FyDeviceInforsMapper fyDeviceInforsMapper;


    public int deleteByPrimaryKey(Long id) {
        return fyDeviceInforsMapper.deleteByPrimaryKey(id);
    }


    public int insert(FyDeviceInfors record) {
        return fyDeviceInforsMapper.insert(record);
    }


    public int insertSelective(FyDeviceInfors record) {
        return fyDeviceInforsMapper.insertSelective(record);
    }


    public FyDeviceInfors selectByPrimaryKey(Long id) {
        return fyDeviceInforsMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(FyDeviceInfors record) {
        return fyDeviceInforsMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(FyDeviceInfors record) {
        return fyDeviceInforsMapper.updateByPrimaryKey(record);
    }

    public List<FyDeviceInfors> selectByCourtId(String courtId) {
        return fyDeviceInforsMapper.selectByDeviceId(courtId);
    }
}
