package com.tingtu.ax.admin.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tingtu.ax.admin.cache.BootAdminCache;
import com.tingtu.ax.admin.configuration.properties.BootAdminProperties;
import com.tingtu.ax.admin.token.ITokenService;
import com.tingtu.ax.admin.token.impl.RedisTokenServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * boot admin 配置
 *
 * @author Administrator
 */
@Configuration
@RequiredArgsConstructor
public class BooAdminAutoConfiguration {
    private final BootAdminProperties properties;
    private final StringRedisTemplate stringRedisTemplate;
    private final ObjectMapper objectMapper;

    /**
     * 配置redis token缓存
     *
     * @return {@link ITokenService}
     */
    @Bean
    public ITokenService tokenService() {
        return new RedisTokenServiceImpl(properties.getTokenConfig(), cache(),objectMapper);
    }

    /**
     * 缓存
     *
     * @return 缓存
     */
    @Bean
    public BootAdminCache cache() {
        return new BootAdminCache(stringRedisTemplate, properties.getCache().getPrefix());
    }
}
