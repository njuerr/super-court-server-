package com.hb0730.boot.admin.project.fy.entity;

import lombok.Data;

@Data
public class FyDownFiles {
    private Long id;

    private String courtid;

    private String filename;

    private String filesavename;

    private String filetext;

    private String filetype;
}
