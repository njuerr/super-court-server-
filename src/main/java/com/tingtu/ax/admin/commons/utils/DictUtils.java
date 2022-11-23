package com.tingtu.ax.admin.commons.utils;

import cn.hutool.extra.spring.SpringUtil;
import com.tingtu.ax.admin.exceptions.JsonException;
import com.tingtu.ax.admin.project.system.dict.model.vo.DictVO;
import com.tingtu.ax.admin.project.system.dict.service.IDictService;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

/**
 * 数据字典
 *
 * @author Administrator
 */
public class DictUtils {

    /**
     * 获取字典项值
     *
     * @param type 字典类型
     * @param name 字典项名称
     * @return 字典项值
     */
    @Nullable
    public static String getEntryValue(@Nonnull String type, @Nonnull String name) {
        Assert.hasText(type, "字典类型不为空");
        Assert.hasText(name, "字典项名称不为空");
        IDictService service = SpringUtil.getBean(IDictService.class);
        List<DictVO> cache = service.getCache();
        if (CollectionUtils.isEmpty(cache)) {
            return "";
        }
        try {
            Optional<DictVO.DictEntryVO> entryValue = cache
                .stream()
                .filter(dictType -> type.equals(dictType.getType()))
                .map(DictVO::getEntry)
                .flatMap(List::stream)
                .filter(entry -> name.equals(entry.getLabel()))
                .findFirst();
            if (entryValue.isPresent()) {
                return entryValue.get().getValue();
            } else {
                return "";
            }
        } catch (JsonException e) {
            e.printStackTrace();
            return "";
        }

    }
}
