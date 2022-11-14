package com.hb0730.boot.admin.project.fy.mapper;

import com.hb0730.boot.admin.project.fy.entity.FyUsers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FyUsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FyUsers record);

    int insertSelective(FyUsers record);

    FyUsers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FyUsers record);

    int updateByPrimaryKey(FyUsers record);
}
