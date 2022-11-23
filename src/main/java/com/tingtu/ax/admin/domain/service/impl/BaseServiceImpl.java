package com.tingtu.ax.admin.domain.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingtu.ax.admin.domain.model.entity.BusinessDomain;
import com.tingtu.ax.admin.security.model.User;
import com.tingtu.ax.admin.security.utils.SecurityUtils;
import org.apache.ibatis.mapping.MappedStatement;

import java.time.LocalDateTime;

/**
 * 基类service(填充删除修改) <br>
 * mybatis Plus 无法填充 非entity {@link com.baomidou.mybatisplus.core.MybatisDefaultParameterHandler#process(MappedStatement, Object)}<br>
 * 注意：这里只对{@link #update(Wrapper)}进行扩展，理应对所有的cud等方法扩展修改时间与修改者
 *
 * @author bing_huang
 * @since 3.0.0
 */
public class BaseServiceImpl<MAPPER extends BaseMapper<ENTITY>, ENTITY> extends ServiceImpl<MAPPER, ENTITY> {

    @Override
    public boolean update(Wrapper<ENTITY> updateWrapper) {
        if (updateWrapper instanceof UpdateWrapper) {
            UpdateWrapper<ENTITY> update = (UpdateWrapper<ENTITY>) updateWrapper;
            update.set(BusinessDomain.UPDATE_TIME, LocalDateTime.now());
            // 设置用户
            User currentUser = SecurityUtils.getCurrentUser();
            if (null != currentUser) {
                update.set(BusinessDomain.UPDATE_USER_ID, currentUser.getId());
            }
        }
        return super.update(updateWrapper);
    }

    @Override
    @SuppressWarnings({"unchecked"})
    protected Class<MAPPER> currentMapperClass() {
        return (Class<MAPPER>) ReflectionKit.getSuperClassGenericType(getClass(), BaseServiceImpl.class, 0);
    }

    @Override
    @SuppressWarnings({"unchecked"})
    protected Class<ENTITY> currentModelClass() {
        return (Class<ENTITY>) ReflectionKit.getSuperClassGenericType(getClass(), BaseServiceImpl.class, 1);
    }
}
