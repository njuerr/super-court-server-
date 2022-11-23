package com.tingtu.ax.admin.project.system.dict.controller;


import com.tingtu.ax.admin.annotation.ClassDescribe;
import com.tingtu.ax.admin.annotation.PreAuth;
import com.tingtu.ax.admin.domain.controller.SuperSimpleBaseController;
import com.tingtu.ax.admin.project.system.dict.model.dto.DictEntryDTO;
import com.tingtu.ax.admin.project.system.dict.model.entity.DictEntryEntity;
import com.tingtu.ax.admin.project.system.dict.model.query.DictEntryParams;
import com.tingtu.ax.admin.project.system.dict.service.IDictEntryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据字典项  前端控制器
 *
 * @author Administrator
 * @since 3.0.0
 */
@RestController
@RequestMapping("/system/dict/entry")
@ClassDescribe("数据字典项")
@PreAuth("dict:entry")
public class DictEntryController extends SuperSimpleBaseController<Long, DictEntryDTO, DictEntryParams, DictEntryEntity> {
    private final IDictEntryService service;

    public DictEntryController(IDictEntryService service) {
        super(service);
        this.service = service;
    }
}

