package com.tingtu.ax.admin.project.fy.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tingtu.ax.admin.project.fy.entity.FyCourtInfors;
import com.tingtu.ax.admin.project.fy.entity.FyDeviceInfors;
import com.tingtu.ax.admin.project.fy.entity.FyFaillogs;
import com.tingtu.ax.admin.project.fy.entity.FyZoneInfors;
import com.tingtu.ax.admin.project.fy.mapper.FyCourtInforsMapper;
import com.tingtu.ax.admin.project.fy.mapper.FyDeviceInforsMapper;
import com.tingtu.ax.admin.project.fy.vo.InfoListVo;
import com.tingtu.ax.admin.project.system.dept.model.dto.DeptDTO;
import com.tingtu.ax.admin.project.system.dept.service.IDeptService;
import com.tingtu.ax.admin.security.model.User;
import com.tingtu.ax.admin.security.utils.SecurityUtils;
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

    @Resource
    private IFyFaillogsService fyFaillogsService;


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
                fyCourtInfors = fyCourtInforsMapper.selectByCourtId(sort,i.getZoneId());
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

    public void outline(Integer courtId) {
        fyCourtInforsMapper.line(courtId,0);
    }

    public void online(Integer courtId) {
        //检查有没有没解决的故障
        QueryWrapper<FyFaillogs> wrapper = new QueryWrapper<>();
        wrapper.eq("repair",0);
        wrapper.eq("courtid",courtId);
        List<FyFaillogs> list = fyFaillogsService.list(wrapper);
        if (list.size()>0){
            fyCourtInforsMapper.line(courtId,1);
        }else {
            fyCourtInforsMapper.line(courtId,2);
        }
    }
}
