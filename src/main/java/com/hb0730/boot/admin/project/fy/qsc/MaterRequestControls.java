package com.hb0730.boot.admin.project.fy.qsc;

import lombok.Data;

@Data
public class MaterRequestControls {
    private String Name;
    public MaterRequestControls(String name){
        this.Name =name;
    }
}
