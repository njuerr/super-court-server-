package com.hb0730.boot.admin.project.fy.service;

import com.hb0730.boot.admin.project.fy.entity.FyCourtInfors;
import com.hb0730.boot.admin.project.fy.entity.FyDeviceInfors;
import com.hb0730.boot.admin.project.fy.entity.FyZoneInfors;
import com.hb0730.boot.admin.project.fy.mapper.FyCourtInforsMapper;
import com.hb0730.boot.admin.project.fy.mapper.FyDeviceInforsMapper;
import com.hb0730.boot.admin.project.fy.vo.InfoListVo;
import com.hb0730.boot.admin.project.system.dept.model.dto.DeptDTO;
import com.hb0730.boot.admin.project.system.dept.service.IDeptService;
import com.hb0730.boot.admin.project.system.dept.service.impl.DeptServiceImpl;
import com.hb0730.boot.admin.security.model.User;
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
    @Autowired
    private IDeptService deptService;


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
        User currentUser = SecurityUtils.getCurrentUser();
        assert currentUser != null;
        List<FyZoneInfors> allList = fyZoneInforsService.getAllList();
        List<InfoListVo> result = new ArrayList<>();
        allList.forEach(i -> {
            List<FyCourtInfors> fyCourtInfors = null;
            if (currentUser.getDeptId()!=(-1L)){
                DeptDTO byId = deptService.findById(currentUser.getDeptId());
                Integer sort = byId.getSort();
                fyCourtInfors = fyCourtInforsMapper.selectByCourtId(sort);
            }else {
                fyCourtInfors = fyCourtInforsMapper.selectByZoneId(i.getZoneId());
            }
            if (fyCourtInfors.size()>0){
                InfoListVo infoListVo = new InfoListVo();
                infoListVo.setName(i.getZoneName());
                infoListVo.setCourtInfors(fyCourtInfors);
                result.add(infoListVo);
            }
        });
        return result;
    }
}
