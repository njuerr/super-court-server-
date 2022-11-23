package com.tingtu.ax.admin.project.fy.service;

import com.tingtu.ax.admin.project.fy.entity.FyUsers;
import com.tingtu.ax.admin.project.fy.mapper.FyUsersMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class FyUsersService{

    @Resource
    private FyUsersMapper fyUsersMapper;


    public int deleteByPrimaryKey(Long id) {
        return fyUsersMapper.deleteByPrimaryKey(id);
    }


    public int insert(FyUsers record) {
        return fyUsersMapper.insert(record);
    }


    public int insertSelective(FyUsers record) {
        return fyUsersMapper.insertSelective(record);
    }


    public FyUsers selectByPrimaryKey(Long id) {
        return fyUsersMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(FyUsers record) {
        return fyUsersMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(FyUsers record) {
        return fyUsersMapper.updateByPrimaryKey(record);
    }

}
