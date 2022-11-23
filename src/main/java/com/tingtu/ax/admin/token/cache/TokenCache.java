package com.tingtu.ax.admin.token.cache;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tingtu.ax.admin.cache.BootAdminCache;
import com.tingtu.ax.admin.cache.CacheUtil;
import com.tingtu.ax.admin.cache.KeyValue;
import com.tingtu.ax.admin.security.model.User;
import com.hb0730.jsons.SimpleJsonProxy;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class TokenCache implements CacheUtil {
    @Getter
    private final BootAdminCache cache;
    private final ObjectMapper objectMapper;
    private static TokenKeyValue keyValue = new TokenKeyValue();
    private static TokenUserValue userValue = new TokenUserValue();

    public void setUserToken(String accessToken, String userToken, long timeout, TimeUnit timeUnit) {
        String cacheKey = getCacheKey(keyValue, accessToken);
        cache.set(cacheKey, userToken, timeout, timeUnit);
    }

    public String getUserTokenKey(String accessToken) {
        return getCacheKey(keyValue, accessToken);
    }

    public String getUserToken(String accessToken) {
        String cacheKey = getCacheKey(keyValue, accessToken);
        return cache.get(cacheKey);
    }

    public void delUserToken(String accessToken) {
        String cacheKey = getCacheKey(keyValue, accessToken);
        cache.del(cacheKey);
    }

    public void setUserInfo(String token, User user, long timeout, TimeUnit timeUnit) {
        String cacheKey = getCacheKey(userValue, token);
        cache.set(cacheKey, SimpleJsonProxy.json.toJson(user, objectMapper), timeout, timeUnit);
    }

    public User getUserInfo(String token) {
        String cacheKey = getCacheKey(userValue, token);
        String json = cache.get(cacheKey);
        if (StrUtil.isNotBlank(json)) {
            return SimpleJsonProxy.json.fromJson(json, User.class, objectMapper);
        }
        return null;
    }

    public void delUserInfo(String token) {
        String cacheKey = getCacheKey(userValue, token);
        cache.del(cacheKey);
    }

    private static class TokenKeyValue implements KeyValue {
        @Override
        public String getPrefix() {
            return "access_token";
        }

        @Override
        public String getName() {
            return "缓存用户token";
        }
    }

    private static class TokenUserValue implements KeyValue {
        @Override
        public String getPrefix() {
            return "user_token";
        }

        @Override
        public Class<?> getClazz() {
            return User.class;
        }

        @Override
        public String getName() {
            return "缓存用户信息";
        }
    }
}
