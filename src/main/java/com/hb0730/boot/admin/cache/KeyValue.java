package com.hb0730.boot.admin.cache;

/**
 * 缓存定义
 *
 * @author Administrator
 */
public interface KeyValue {
    /**
     * KEY前缀
     *
     * @return 前缀
     */
    default String getPrefix() {
        return "";
    }

    /**
     * 过期时间（秒）
     *
     * @return 过期时间
     */
    default long getExpire() {
        return 0L;
    }

    /**
     * 缓存对象
     *
     * @return 缓存对象
     */
    default Class<?> getClazz() {
        return null;
    }

    /**
     * 缓存名称
     *
     * @return 缓存名称
     */
    default String getName() {
        return "";
    }

    /**
     * 缓存说明
     */
    default String getDesc() {
        return "";
    }

}
