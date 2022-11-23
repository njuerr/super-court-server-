package com.tingtu.ax.admin.project.fy.service;

import com.tingtu.ax.admin.domain.service.ISuperBaseService;
import com.tingtu.ax.admin.domain.service.base.ISuperPoiService;
import com.tingtu.ax.admin.project.fy.dto.LineDTO;
import com.tingtu.ax.admin.project.fy.dto.LineExcelDTO;
import com.tingtu.ax.admin.project.fy.dto.LineParams;
import com.tingtu.ax.admin.project.fy.entity.FyDeviceTimes;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface IFyDeviceTimesService extends ISuperBaseService<Long, LineParams, LineDTO, FyDeviceTimes>, ISuperPoiService<LineParams, LineExcelDTO> {
    @Override
    List<LineExcelDTO> export(@NotNull LineParams params);
}
