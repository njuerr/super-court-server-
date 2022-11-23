package com.hb0730.boot.admin.project.fy.service;

import com.hb0730.boot.admin.domain.service.ISuperBaseService;
import com.hb0730.boot.admin.domain.service.base.ISuperPoiService;
import com.hb0730.boot.admin.project.fy.dto.*;
import com.hb0730.boot.admin.project.fy.entity.FyDeviceTimes;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface IFyDeviceTimesService extends ISuperBaseService<Long, LineParams, LineDTO, FyDeviceTimes>, ISuperPoiService<LineParams, LineExcelDTO> {
    @Override
    List<LineExcelDTO> export(@NotNull LineParams params);
}
