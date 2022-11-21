package com.hb0730.boot.admin.project.fy.dto;

import com.hb0730.boot.admin.domain.model.query.BaseParams;
import lombok.Data;
import lombok.ToString;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-21 14:06
 **/
@Data
@ToString
public class FailLogParams extends BaseParams {
    private String failid;
}
