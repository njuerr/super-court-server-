package com.tingtu.ax.admin.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class CacheUtilTest {

    @Test
    void concatKeys() {
        String cccc = new CacheUtil() {
        }.getCacheKey(new KeyValue() {
            @Override
            public String getPrefix() {
                return "test";
            }
        }, "cccc");
        log.info(cccc);
    }
}
