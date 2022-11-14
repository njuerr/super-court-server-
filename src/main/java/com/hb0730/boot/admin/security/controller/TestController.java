package com.hb0730.boot.admin.security.controller;

import com.hb0730.boot.admin.domain.result.R;
import com.hb0730.boot.admin.domain.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @since 1.0.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test1")
    public Result<String> test1() {
        return R.success("测试1");
    }
}
