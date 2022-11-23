package com.tingtu.ax.admin.project.fy.vo;

import com.tingtu.ax.admin.project.fy.entity.FyCourtInfors;
import lombok.Data;

import java.util.List;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-11 11:42
 **/
@Data
public class InfoListVo {
    private String name;
    private List<FyCourtInfors> courtInfors;
}
