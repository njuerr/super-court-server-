package com.tingtu.ax.admin.project.fy.qsc;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-17 09:14
 **/
@Data
public class MaterResParams {
    @JSONField(name="Id")
    private String Id;
    @JSONField(name="Changes")
    private List<MeterResChanges> Changes;
}
