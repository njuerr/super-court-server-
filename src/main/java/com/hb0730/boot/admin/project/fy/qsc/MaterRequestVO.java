package com.hb0730.boot.admin.project.fy.qsc;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MaterRequestVO {
    private String jsonrpc;
    private Integer id;
    private String method;
    private MaterRequestParams params;

    public MaterRequestVO(){
        this.jsonrpc ="2.0";
        this.id=1234;
        this.method ="ChangeGroup.AddComponentControl";
        MaterRequestParams materRequestParams = new MaterRequestParams();
        materRequestParams.setId("changegroup_3");
        MaterRequestComponent component = new MaterRequestComponent();
        component.setName("web_remoteMonitor_001");
        List<MaterRequestControls> materRequestControls = new ArrayList<>();
        MaterRequestControls controls = new MaterRequestControls("meter 1");
        MaterRequestControls controls2 = new MaterRequestControls("meter 2");
        MaterRequestControls controls3 = new MaterRequestControls("meter 3");
        MaterRequestControls controls4 = new MaterRequestControls("meter 4");
        MaterRequestControls controls5 = new MaterRequestControls("meter 5");
        MaterRequestControls controls6 = new MaterRequestControls("meter 6");
        MaterRequestControls controls7 = new MaterRequestControls("meter 7");
        MaterRequestControls controls8 = new MaterRequestControls("meter 8");
        MaterRequestControls controls9 = new MaterRequestControls("meter 9");
        MaterRequestControls controls10 = new MaterRequestControls("meter 10");
        MaterRequestControls controls11 = new MaterRequestControls("meter 11");
        MaterRequestControls controls12 = new MaterRequestControls("meter 12");
        MaterRequestControls controls13 = new MaterRequestControls("meter 13");
        MaterRequestControls controls14 = new MaterRequestControls("meter 14");
        MaterRequestControls controls15 = new MaterRequestControls("meter 15");
        MaterRequestControls controls16 = new MaterRequestControls("meter 16");
        materRequestControls.add(controls);
        materRequestControls.add(controls2);
        materRequestControls.add(controls3);
        materRequestControls.add(controls4);
        materRequestControls.add(controls5);
        materRequestControls.add(controls6);
        materRequestControls.add(controls7);
        materRequestControls.add(controls8);
        materRequestControls.add(controls9);
        materRequestControls.add(controls10);
        materRequestControls.add(controls11);
        materRequestControls.add(controls12);
        materRequestControls.add(controls13);
        materRequestControls.add(controls14);
        materRequestControls.add(controls15);
        materRequestControls.add(controls16);
        component.setControls(materRequestControls);
        materRequestParams.setComponent(component);
        this.params =materRequestParams;
    }
}
