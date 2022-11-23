package com.tingtu.ax.admin.project.system.menu.service.cache;

import com.tingtu.ax.admin.cache.KeyValue;

import java.util.List;

/**
 * 菜单缓存-参数信息
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MenuCacheKeyValue implements KeyValue {
    @Override
    public String getPrefix() {
        return "menu";
    }

    @Override
    public long getExpire() {
        return 0L;
    }

    @Override
    public Class<?> getClazz() {
        return List.class;
    }

    @Override
    public String getName() {
        return "菜单缓存";
    }

    @Override
    public String getDesc() {
        return "根据用户id缓存菜单信息";
    }
}
