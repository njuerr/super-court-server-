package com.tingtu.ax.admin.task.utils;

import cn.hutool.extra.spring.SpringUtil;
import com.tingtu.ax.admin.exceptions.JsonException;
import com.tingtu.ax.admin.task.domain.JobInvokeInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class JobInvokeUtilTest {
    @Autowired
    private ApplicationContext application;


    @Test
    public void invokeMethodTest() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, JsonException {
        JobInvokeInfo taskConstant = new JobInvokeInfo();
        taskConstant.setBean("taskTest");

        taskConstant.setMethod("params");
        taskConstant.setParams("{\"java.lang.String\":\"test\"}");
        JobInvokeUtil.invokeMethod(taskConstant);

        taskConstant.setMethod("multipleParams");
        taskConstant.setParams("{\"java.lang.String\":\"test\",\"java.lang.Boolean\":\"true\",\"java.lang.Long\":\"123L\",\"java.lang.Double\":\"123.03D\",\"java.lang.Integer\":\"123\"}");
        JobInvokeUtil.invokeMethod(taskConstant);

        taskConstant.setMethod("obj");
        taskConstant.setParams("{\"com.hb0730.boot.admin.project.system.quartz.handler.Test1\":{\"java.lang.Integer\":\"1\"}}");
        JobInvokeUtil.invokeMethod(taskConstant);
    }

    @Test
    public void invokeMethodParamsNullTest() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        JobInvokeInfo info = new JobInvokeInfo();
        info.setBean("taskTest");
        info.setMethod("noParams");
        JobInvokeUtil.invokeMethod(info);
    }

    @Test
    public void validClassName() throws ClassNotFoundException {
        SpringUtil.getApplicationContext().containsBean("taskTest");
    }
}
