package com.hb0730.boot.admin.project.fy.qsc;


import lombok.Data;

import java.util.List;

@Data
public class MaterRequestComponent {
    private String Name;
    private List<MaterRequestControls> Controls;

}
