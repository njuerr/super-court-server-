package com.hb0730.boot.admin.project.fy.service;

import com.hb0730.boot.admin.project.fy.entity.FyZoneInfors;
import com.hb0730.boot.admin.project.fy.mapper.FyZoneInforsMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class FyZoneInforsService{

    @Resource
    private FyZoneInforsMapper fyZoneInforsMapper;


    public int deleteByPrimaryKey(Long id) {
        return fyZoneInforsMapper.deleteByPrimaryKey(id);
    }


    public int insert(FyZoneInfors record) {
        return fyZoneInforsMapper.insert(record);
    }


    public int insertSelective(FyZoneInfors record) {
        return fyZoneInforsMapper.insertSelective(record);
    }


    public FyZoneInfors selectByPrimaryKey(Long id) {
        return fyZoneInforsMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(FyZoneInfors record) {
        return fyZoneInforsMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(FyZoneInfors record) {
        return fyZoneInforsMapper.updateByPrimaryKey(record);
    }

    public List<FyZoneInfors> getAllList() {
        return fyZoneInforsMapper.getAllList();
    }
}
