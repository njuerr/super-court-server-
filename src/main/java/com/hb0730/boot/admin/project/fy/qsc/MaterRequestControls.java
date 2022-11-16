package com.hb0730.boot.admin.project.fy.qsc;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class MaterRequestControls {
    @JSONField(name = "Name")
    private String Name;
    public MaterRequestControls(String name){
        this.Name =name;
    }
}
