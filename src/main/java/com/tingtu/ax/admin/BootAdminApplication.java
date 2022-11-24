package com.tingtu.ax.admin;

import cn.hutool.extra.spring.EnableSpringUtil;
import com.tingtu.ax.admin.project.fy.qsc.QscUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 入口
 *
 * @author Administrator
 * @since 3.0.0
 */
@SpringBootApplication
@EnableAsync
@EnableSpringUtil
public class BootAdminApplication{
    public static void main(String[] args) {
        SpringApplication.run(BootAdminApplication.class, args);
    }
}
