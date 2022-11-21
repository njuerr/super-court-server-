package com.hb0730.boot.admin.project.fy.service;

import com.hb0730.boot.admin.commons.utils.DateUtils;
import com.hb0730.boot.admin.domain.service.impl.SuperBaseServiceImpl;
import com.hb0730.boot.admin.project.fy.dto.FyFaillogsAddDTO;
import com.hb0730.boot.admin.project.fy.dto.FyFaillogsUpdateDTO;
import com.hb0730.boot.admin.project.fy.entity.FyFaillogs;
import com.hb0730.boot.admin.project.fy.mapper.FyFaillogsMapper;
import com.hb0730.boot.admin.project.fy.vo.FailLogVo;
import com.hb0730.boot.admin.project.system.post.mapper.IPostMapper;
import com.hb0730.boot.admin.project.system.post.model.dto.PostDTO;
import com.hb0730.boot.admin.project.system.post.model.entity.PostEntity;
import com.hb0730.boot.admin.project.system.post.model.query.PostParams;
import com.hb0730.boot.admin.security.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
        fyFaillogs.setFailid(UUID.randomUUID().toString().substring(0,10));
        fyFaillogs.setFailcontent(fyFaillogsAddDTO.getErrorInput());
        fyFaillogs.setReporttime(DateUtils.format("yyyy-MM-dd HH:mm:ss", new Date()));
        fyFaillogs.setReportuser(Objects.requireNonNull(SecurityUtils.getCurrentUser()).getId().toString());
        fyFaillogs.setDelFlag(0);
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

    public List<FailLogVo> failRepair(String courtId) {
        return fyFaillogsMapper.failRepair(courtId);
    }

    public void process(FyFaillogsUpdateDTO fyFaillogsUpdateDTO) {
        FyFaillogs fyFaillogs = fyFaillogsMapper.selectByFailId(fyFaillogsUpdateDTO.getFailId());
        fyFaillogs.setRepair("1");
        fyFaillogs.setProcesstime(DateUtils.format("yyyy-MM-dd HH:mm:ss", new Date()));
        fyFaillogs.setProcessuser(Objects.requireNonNull(SecurityUtils.getCurrentUser()).getId().toString());
        fyFaillogs.setProcesscontent(fyFaillogsUpdateDTO.getProcessContent());
        updateByPrimaryKey(fyFaillogs);
    }
}
