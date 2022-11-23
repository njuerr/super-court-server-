package com.tingtu.ax.admin.project.system.option.service.impl;

import com.tingtu.ax.admin.project.system.option.service.IOptionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@Slf4j
public class OptionServiceImplTest {
    @Autowired
    private IOptionService service;


    @Test
    public void listOptionsTest() {
        Map<String, Object> stringObjectMap = service.listOptions();
        Assert.assertNotNull(stringObjectMap);
    }
}
