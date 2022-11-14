package com.hb0730.boot.admin.project.fy.service;

import com.hb0730.boot.admin.commons.utils.DateUtils;
import com.hb0730.boot.admin.project.fy.dto.FyFaillogsAddDTO;
import com.hb0730.boot.admin.project.fy.entity.FyFaillogs;
import com.hb0730.boot.admin.project.fy.mapper.FyFaillogsMapper;
import com.hb0730.boot.admin.project.fy.vo.FailLogVo;
import com.hb0730.boot.admin.security.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FyFaillogsService {

    @Resource
    private FyFaillogsMapper fyFaillogsMapper;


    public int deleteByPrimaryKey(Long id) {
        return fyFaillogsMapper.deleteByPrimaryKey(id);
    }


    public int insert(FyFaillogs record) {
        return fyFaillogsMapper.insert(record);
    }

    public int create(FyFaillogsAddDTO fyFaillogsAddDTO) {
        FyFaillogs fyFaillogs = new FyFaillogs();
        fyFaillogs.setRepair("0");
        fyFaillogs.setDeviceid(fyFaillogsAddDTO.getDeviceId());
        fyFaillogs.setCourtid(fyFaillogsAddDTO.getCourtId());
        fyFaillogs.setFailid(UUID.randomUUID().toString());
        fyFaillogs.setFailcontent(fyFaillogsAddDTO.getErrorInput());
        fyFaillogs.setReporttime(DateUtils.format("yyyy-MM-dd HH:mm:ss",new Date()));
        fyFaillogs.setReportuser(SecurityUtils.getCurrentUser().getId().toString());
        return insert(fyFaillogs);
    }


    public int insertSelective(FyFaillogs record) {
        return fyFaillogsMapper.insertSelective(record);
    }


    public FyFaillogs selectByPrimaryKey(Long id) {
        return fyFaillogsMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(FyFaillogs record) {
        return fyFaillogsMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(FyFaillogs record) {
        return fyFaillogsMapper.updateByPrimaryKey(record);
    }

    public List<FailLogVo> getLogs(String id) {
        return fyFaillogsMapper.getLogs(id);
    }

    public List<FyFaillogs> failRepair(String courtId) {
        return fyFaillogsMapper.failRepair(courtId);
    }
}
