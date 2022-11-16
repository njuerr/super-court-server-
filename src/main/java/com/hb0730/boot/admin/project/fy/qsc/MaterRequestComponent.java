package com.hb0730.boot.admin.project.fy.qsc;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class MaterRequestComponent {
    @JSONField(name = "Name")
    private String Name;
    @JSONField(name = "Controls")
    private List<MaterRequestControls> Controls;

}
