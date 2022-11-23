package com.tingtu.ax.admin.project.fy.qsc;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class MaterRequestParams {
    @JSONField(name = "Name")
    private String Name;
    @JSONField(name = "Controls")
//    private MaterRequestComponent Component;
    private List<MaterRequestControls> Controls;
}
