package com.hb0730.boot.admin.domain.controller.base;

import cn.hutool.core.collection.CollectionUtil;
import com.hb0730.boot.admin.annotation.Log;
import com.hb0730.boot.admin.commons.enums.BusinessTypeEnum;
import com.hb0730.boot.admin.commons.enums.ResponseStatusEnum;
import com.hb0730.boot.admin.domain.model.entity.BaseDomain;
import com.hb0730.boot.admin.domain.result.R;
import com.hb0730.boot.admin.domain.result.Result;
import com.hb0730.boot.admin.domain.service.ISuperBaseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.List;

/**
 * 删除<br>
 * <pre>
 * 1. 根据id单一删除 {@link #deleteById(Serializable)}
 * 2. 通过id集批量删除 {@link #deleteByIds(List)}
 * 3. 实现共用的权限{@link PreAuthorize}{@link com.hb0730.boot.admin.annotation.PreAuth}{@link com.hb0730.boot.admin.security.handler.PermissionCustomHandler}
 * 4. 实现日志的记录{@link Log}{@link com.hb0730.boot.admin.annotation.ClassDescribe} {@link com.hb0730.boot.admin.aspectj.LogAspectj}
 * </pre>,
 * 如果重新当前方法需重新设置方法注解
 *
 * @param <ID>     id类型
 * @param <ENTITY> 实体类型
 * @author Administrator
 * @since 3.0.0
 */
public interface IBaseDeleteController<ID extends Serializable, ENTITY extends BaseDomain> extends IBaseController<ENTITY> {
    /**
     * 删除
     *
     * @param id id
     * @return 是否成功
     */
    @DeleteMapping("/delete/{id}")
    @SuppressWarnings({"rawtypes"})
    @Log(value = "删除", businessType = BusinessTypeEnum.DELETE)
    @PreAuthorize("@permissionHandler.hasAnyAuthority(this,'ROLE_ADMINISTRATOR','delete')")
    default Result<String> deleteById(@PathVariable("id") ID id) {
        ISuperBaseService service = getBaseService();
        if (service != null) {
            service.removeById(id);
            return R.success("删除成功");
        }
        return R.result(ResponseStatusEnum.PARAMS_REQUIRED_IS_NULL, "service is null");
    }

    /**
     * 根据id批量删除
     *
     * @param ids id
     * @return 是否成功
     */
    @PostMapping("/delete")
    @SuppressWarnings({"rawtypes"})
    @Log(value = "删除", paramsName = {"ids"}, businessType = BusinessTypeEnum.DELETE)
    @PreAuthorize("@permissionHandler.hasAnyAuthority(this,'ROLE_ADMINISTRATOR','delete')")
    default Result<String> deleteByIds(@RequestBody List<ID> ids) {
        ISuperBaseService service = getBaseService();
        if (service != null && !CollectionUtil.isEmpty(ids)) {
            service.removeByIds(ids);
            return R.success("删除成功");
        }
        return R.result(ResponseStatusEnum.PARAMS_REQUIRED_IS_NULL, "service is null");
    }
}
