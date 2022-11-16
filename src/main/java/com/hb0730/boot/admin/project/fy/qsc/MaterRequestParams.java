package com.hb0730.boot.admin.project.fy.qsc;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class MaterRequestParams {
    @JSONField(name = "Id")
    private String Id;
    @JSONField(name = "Component")
    private MaterRequestComponent Component;
}
