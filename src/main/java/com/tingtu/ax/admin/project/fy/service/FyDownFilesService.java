package com.tingtu.ax.admin.project.fy.service;

import com.tingtu.ax.admin.project.fy.entity.FyDownFiles;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.tingtu.ax.admin.project.fy.mapper.FyDownFilesMapper;

import java.util.List;

@Service
public class FyDownFilesService{

    @Resource
    private FyDownFilesMapper fyDownFilesMapper;


    public int deleteByPrimaryKey(Long id) {
        return fyDownFilesMapper.deleteByPrimaryKey(id);
    }


    public int insert(FyDownFiles record) {
        return fyDownFilesMapper.insert(record);
    }


    public int insertSelective(FyDownFiles record) {
        return fyDownFilesMapper.insertSelective(record);
    }


    public FyDownFiles selectByPrimaryKey(Long id) {
        return fyDownFilesMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(FyDownFiles record) {
        return fyDownFilesMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(FyDownFiles record) {
        return fyDownFilesMapper.updateByPrimaryKey(record);
    }

    public List<FyDownFiles>  downloadFile(String courtId) {
        return fyDownFilesMapper.selectByCourtId(courtId);
    }
}
