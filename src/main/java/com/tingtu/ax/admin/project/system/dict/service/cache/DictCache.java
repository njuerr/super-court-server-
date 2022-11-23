package com.tingtu.ax.admin.project.system.dict.service.cache;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tingtu.ax.admin.cache.BootAdminCache;
import com.tingtu.ax.admin.cache.CacheUtil;
import com.tingtu.ax.admin.project.system.dict.model.vo.DictVO;
import com.hb0730.jsons.SimpleJsonProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 字典缓存
 *
 * @author Administrator
 * @since 1.0.0
 */
@Component
@RequiredArgsConstructor
public class DictCache implements CacheUtil {
    private final BootAdminCache cache;
    private final DictKeyValue keyValue = new DictKeyValue();

    public void setDictCache(List<DictVO> dictList) {
        String cacheKey = getCacheKey(keyValue);
        String json = SimpleJsonProxy.json.toJson(dictList);
        cache.set(cacheKey, json);
    }

    public List<DictVO> getDictCache() {
        String cacheKey = getCacheKey(keyValue);
        String json = cache.get(cacheKey);
        if (StrUtil.isNotBlank(json)) {
            return SimpleJsonProxy.json.fromJson(json, new TypeReference<List<DictVO>>() {
            });
        }
        return null;
    }
}
