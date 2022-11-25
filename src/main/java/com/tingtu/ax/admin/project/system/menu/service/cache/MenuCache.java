package com.tingtu.ax.admin.project.system.menu.service.cache;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tingtu.ax.admin.cache.BootAdminCache;
import com.tingtu.ax.admin.cache.CacheUtil;
import com.tingtu.ax.admin.project.system.menu.model.dto.TreeMenuDTO;
import com.hb0730.jsons.SimpleJsonProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Administrator
 * @since 1.0.0
 */
@Component
@RequiredArgsConstructor
public class MenuCache implements CacheUtil {
    private final BootAdminCache cache;
    private final ObjectMapper objectMapper;
    private static final MenuCacheKeyValue keyValue = new MenuCacheKeyValue();

    /**
     * 设置缓存信息
     *
     * @param userId 用户id
     * @param menu   缓存菜单信息
     */
    public void setMenuCache(String userId, List<TreeMenuDTO> menu) {
        String cacheKey = getCacheKey(keyValue, userId);
        String json = SimpleJsonProxy.json.toJson(menu, objectMapper);
        cache.set(cacheKey, json);
    }


    public List<TreeMenuDTO> getMenuCache(String userId) {
        String cacheKey = getCacheKey(keyValue, userId);
        String json = cache.get(cacheKey);
        if (json==null){
            json = "[{\"createUserId\":\"-1\",\"createTime\":\"2020-09-08 06:16:13\",\"updateUserId\":\"-1\",\"updateTime\":\"2022-02-23 11:21:34\",\"isEnabled\":1,\"id\":\"1303215545302175746\",\"external\":0,\"iframe\":0,\"cache\":0,\"hidden\":0,\"showParent\":1,\"i18n\":0,\"title\":\"系统监控\",\"enname\":\"monitorManager\",\"parentId\":\"-1\",\"path\":\"/monitor\",\"component\":\"\",\"icon\":\"ep:monitor\",\"sort\":20,\"showLink\":true},{\"createUserId\":\"-1\",\"createTime\":\"2022-11-11 11:00:51\",\"updateUserId\":\"-1\",\"updateTime\":\"2022-11-11 11:04:28\",\"isEnabled\":1,\"description\":\"\",\"id\":\"1590902342799351809\",\"external\":0,\"iframe\":0,\"cache\":0,\"hidden\":0,\"showParent\":1,\"i18n\":0,\"title\":\"法院状态\",\"enname\":\"courtInfo/index.vue\",\"parentId\":\"1303215545302175746\",\"path\":\"/court/info\",\"component\":\"/courtInfo\",\"icon\":\"ep:chat-line-square\",\"sort\":999,\"authority\":[\"court:info:query\"],\"showLink\":true}]";
        }
        return SimpleJsonProxy.json.fromJson(json, new TypeReference<List<TreeMenuDTO>>() {
        }, objectMapper);

    }
}
