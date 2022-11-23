package com.tingtu.ax.admin.project.system.option.controller;


import com.tingtu.ax.admin.domain.controller.SuperSimpleBaseController;
import com.tingtu.ax.admin.project.system.option.model.dto.OptionDTO;
import com.tingtu.ax.admin.project.system.option.model.entity.OptionEntity;
import com.tingtu.ax.admin.project.system.option.model.query.OptionParams;
import com.tingtu.ax.admin.project.system.option.service.IOptionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * options选项  前端控制器
 *
 * @author Administrator
 * @since 3.0.0
 */
@RestController
@RequestMapping("/system/option")
public class OptionController extends SuperSimpleBaseController<Long, OptionDTO, OptionParams, OptionEntity> {
    private final IOptionService service;

    public OptionController(IOptionService service) {
        super(service);
        this.service = service;
    }
}

