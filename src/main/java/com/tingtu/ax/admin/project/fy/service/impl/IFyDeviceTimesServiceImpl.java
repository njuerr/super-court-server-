package com.tingtu.ax.admin.project.fy.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tingtu.ax.admin.commons.utils.DateUtils;
import com.tingtu.ax.admin.domain.service.impl.SuperBaseServiceImpl;
import com.tingtu.ax.admin.project.fy.dto.LineDTO;
import com.tingtu.ax.admin.project.fy.dto.LineExcelDTO;
import com.tingtu.ax.admin.project.fy.dto.LineParams;
import com.tingtu.ax.admin.project.fy.entity.FyDeviceTimes;
import com.tingtu.ax.admin.project.fy.mapper.FyDeviceTimesMapper;
import com.tingtu.ax.admin.project.fy.service.FyCourtInforsService;
import com.tingtu.ax.admin.project.fy.service.IFyDeviceTimesService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-23 14:06
 **/
@Service
public class IFyDeviceTimesServiceImpl extends SuperBaseServiceImpl<Long, LineParams, LineDTO, FyDeviceTimes, FyDeviceTimesMapper> implements IFyDeviceTimesService {

    @Autowired
    private FyCourtInforsService fyCourtInforsService;

    @Override
    public boolean upload(Collection<LineExcelDTO> dataList) {
        return false;
    }

    @Override
    public List<LineExcelDTO> export(@NotNull LineParams params) {
        QueryWrapper<FyDeviceTimes> query = this.query(params);
        List<FyDeviceTimes> entities = super.list(query);
        List<LineExcelDTO> failLogsExcelDTOS = BeanUtil.copyToList(entities, LineExcelDTO.class);
        for (LineExcelDTO lineExcelDTO : failLogsExcelDTOS) {
            lineExcelDTO.setDeviceName(fyCourtInforsService.selectByPrimaryKey(Long.valueOf(lineExcelDTO.getDeviceId())).getCourtName());
        }
        return failLogsExcelDTOS;
    }

    @Override
    public Page<LineDTO> page(LineParams params) {
        Page<LineDTO> page = super.page(params);
        for (LineDTO record : page.getRecords()) {
            record.setDeviceName(fyCourtInforsService.selectByPrimaryKey(Long.valueOf(record.getDeviceId())).getCourtName());
            record.setOnlineTimeStr(DateUtils.format("yyyy-MM-dd HH:mm:ss",record.getOnlineTime()));
            record.setOutlineTimeStr(DateUtils.format("yyyy-MM-dd HH:mm:ss",record.getOutlineTime()));
        }
        return page;
    }
}
