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
public class MeterResChanges {
    @JSONField(name = "Component")
    private String Component;
    @JSONField(name = "Name")
    private String Name;
    @JSONField(name = "String")
    private String String;
    @JSONField(name = "Value")
    private Double Value;
    @JSONField(name = "Position")
    private Double Position;
    @JSONField(name = "Choices")
    private List<Integer> Choices;
    @JSONField(name = "Color")
    private String Color;
    @JSONField(name = "Indeterminate")
    private Boolean Indeterminate;
    @JSONField(name = "Invisible")
    private Boolean Invisible;
    @JSONField(name = "Disabled")
    private Boolean Disabled;
    @JSONField(name = "Legend")
    private String Legend;
}
