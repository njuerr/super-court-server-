package com.hb0730.boot.admin.project.fy.qsc;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class MaterRequestControls {
    @JSONField(name = "Name")
    private String Name;
    @JSONField(name = "Value")
    private String Value;
    public MaterRequestControls(String name,String value){
        this.Name =name;
        this.Value=value;
    }
}
