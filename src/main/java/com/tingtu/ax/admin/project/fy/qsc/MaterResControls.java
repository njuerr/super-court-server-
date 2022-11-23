package com.tingtu.ax.admin.project.fy.qsc;

import lombok.Data;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-17 09:13
 **/
@Data
public class MaterResControls {
    private String jsonrpc;
    private String method;
    private MaterResParams params;
}
