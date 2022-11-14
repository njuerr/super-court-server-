package com.hb0730.boot.admin.project.fy.service;

import com.hb0730.boot.admin.project.fy.entity.FyCourtInfors;
import com.hb0730.boot.admin.project.fy.entity.FyDeviceInfors;
import com.hb0730.boot.admin.project.fy.entity.FyZoneInfors;
import com.hb0730.boot.admin.project.fy.mapper.FyCourtInforsMapper;
import com.hb0730.boot.admin.project.fy.mapper.FyDeviceInforsMapper;
import com.hb0730.boot.admin.project.fy.vo.InfoListVo;
import com.hb0730.boot.admin.security.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class FyCourtInforsService {

    @Resource
    private FyCourtInforsMapper fyCourtInforsMapper;
    @Autowired
    private FyDeviceInforsMapper fyDeviceInforsMapper;
    @Autowired
    private FyZoneInforsService fyZoneInforsService;


    public int deleteByPrimaryKey(Long id) {
        return fyCourtInforsMapper.deleteByPrimaryKey(id);
    }


    public int insert(FyCourtInfors record) {
        return fyCourtInforsMapper.insert(record);
    }


    public int insertSelective(FyCourtInfors record) {
        return fyCourtInforsMapper.insertSelective(record);
    }


    public FyCourtInfors selectByPrimaryKey(Long id) {
        return fyCourtInforsMapper.selectById(id);
    }


    public int updateByPrimaryKeySelective(FyCourtInfors record) {
        return fyCourtInforsMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(FyCourtInfors record) {
        return fyCourtInforsMapper.updateByPrimaryKey(record);
    }

    public List<FyDeviceInfors> getDeviceUrl(String id) {
        Collection<String> role = SecurityUtils.getCurrentUser().getRole();
        if (role.contains("ROLE_COURT") || role.contains("ROLE_ADMINISTRATOR")) {
            return fyDeviceInforsMapper.selectListAll();
        } else {
            return fyDeviceInforsMapper.selectByDeviceId(id);
        }
    }

    public List<FyCourtInfors> getCourtStatus() {
        return fyCourtInforsMapper.selectListAll();
    }

    public List<InfoListVo> getInfoList() {
        List<FyZoneInfors> allList = fyZoneInforsService.getAllList();
        List<InfoListVo> result = new ArrayList<>();
        allList.forEach(i -> {
            InfoListVo infoListVo = new InfoListVo();
            infoListVo.setName(i.getZoneName());
            List<FyCourtInfors> fyCourtInfors = fyCourtInforsMapper.selectByZoneId(i.getZoneId());
            infoListVo.setCourtInfors(fyCourtInfors);
            result.add(infoListVo);
        });
        return result;
    }
}
