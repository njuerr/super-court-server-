package com.tingtu.ax.admin.project.fy.service;

import com.tingtu.ax.admin.project.fy.entity.FyNavigateMenus;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.tingtu.ax.admin.project.fy.mapper.FyNavigateMenusMapper;
@Service
public class FyNavigateMenusService{

    @Resource
    private FyNavigateMenusMapper fyNavigateMenusMapper;


    public int deleteByPrimaryKey(Long id) {
        return fyNavigateMenusMapper.deleteByPrimaryKey(id);
    }


    public int insert(FyNavigateMenus record) {
        return fyNavigateMenusMapper.insert(record);
    }


    public int insertSelective(FyNavigateMenus record) {
        return fyNavigateMenusMapper.insertSelective(record);
    }


    public FyNavigateMenus selectByPrimaryKey(Long id) {
        return fyNavigateMenusMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(FyNavigateMenus record) {
        return fyNavigateMenusMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(FyNavigateMenus record) {
        return fyNavigateMenusMapper.updateByPrimaryKey(record);
    }

}
