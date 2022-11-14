package com.hb0730.boot.admin.project.fy.dto;

import lombok.Data;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-11 09:50
 **/
@Data
public class FyFaillogsAddDTO {
    private String courtId;
    private String errorInput;
    private String deviceId;
}
