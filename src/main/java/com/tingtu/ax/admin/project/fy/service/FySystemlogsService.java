package com.tingtu.ax.admin.project.fy.service;

import com.tingtu.ax.admin.project.fy.entity.FySystemlogs;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.tingtu.ax.admin.project.fy.mapper.FySystemlogsMapper;

@Service
public class FySystemlogsService{

    @Resource
    private FySystemlogsMapper fySystemlogsMapper;


    public int deleteByPrimaryKey(Long id) {
        return fySystemlogsMapper.deleteByPrimaryKey(id);
    }


    public int insert(FySystemlogs record) {
        return fySystemlogsMapper.insert(record);
    }


    public int insertSelective(FySystemlogs record) {
        return fySystemlogsMapper.insertSelective(record);
    }


    public FySystemlogs selectByPrimaryKey(Long id) {
        return fySystemlogsMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(FySystemlogs record) {
        return fySystemlogsMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(FySystemlogs record) {
        return fySystemlogsMapper.updateByPrimaryKey(record);
    }

}
