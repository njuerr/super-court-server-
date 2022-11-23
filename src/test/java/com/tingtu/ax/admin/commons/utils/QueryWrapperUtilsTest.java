package com.tingtu.ax.admin.commons.utils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tingtu.ax.admin.project.system.dept.model.entity.DeptEntity;
import com.tingtu.ax.admin.project.system.dept.model.query.DeptParams;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

@Slf4j
class QueryWrapperUtilsTest {

    @Test
    void getLambdaQuery() {
        DeptParams params = new DeptParams();
        params.setGroupColumn(Lists.list("name"));
        LambdaQueryWrapper<DeptEntity> query = QueryWrapperUtils.getLambdaQuery(params);
        query.like(DeptEntity::getName, "测试");
        log.info("sql: {}", query.getSqlSet());
    }
}
