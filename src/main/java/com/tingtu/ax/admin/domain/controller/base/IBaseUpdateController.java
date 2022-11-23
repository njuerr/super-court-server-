package com.tingtu.ax.admin.domain.controller.base;

import cn.hutool.extra.validation.ValidationUtil;
import com.tingtu.ax.admin.annotation.ClassDescribe;
import com.tingtu.ax.admin.annotation.Log;
import com.tingtu.ax.admin.annotation.PreAuth;
import com.tingtu.ax.admin.commons.enums.BusinessTypeEnum;
import com.tingtu.ax.admin.commons.enums.ResponseStatusEnum;
import com.tingtu.ax.admin.commons.utils.ValidatorUtils;
import com.tingtu.ax.admin.domain.model.dto.BaseDTO;
import com.tingtu.ax.admin.domain.model.entity.BaseDomain;
import com.tingtu.ax.admin.domain.result.R;
import com.tingtu.ax.admin.domain.result.Result;
import com.tingtu.ax.admin.domain.service.ISuperBaseService;
import com.tingtu.ax.admin.aspectj.LogAspectj;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

/**
 * 修改
 * <pre>
 * 1. 实现根据id进行修改{@link #updateById(Serializable, BaseDTO)}
 * 2. 修改参数的校验{@link ValidationUtil#validate(Object, Class[])}
 * 3. 实现共用的权限{@link PreAuthorize}{@link PreAuth}{@link com.hb0730.boot.admin.security.service.PermissionService}
 * 4. 实现日志的记录{@link Log}{@link ClassDescribe} {@link LogAspectj}
 * </pre>
 *
 * @param <DTO>    vo类型
 * @param <ID>     id 类型
 * @param <ENTITY> 实体类型
 * @author Administrator
 * @since 3.0.0
 */
public interface IBaseUpdateController<ID extends Serializable, DTO extends BaseDTO, ENTITY extends BaseDomain> extends IBaseController<ENTITY> {
    /**
     * 根据id修改
     *
     * @param id  id
     * @param dto 修改参数
     * @return 是否成功
     */
    @PutMapping("/update/{id}")
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Log(value = "修改", paramsName = {"dto"}, businessType = BusinessTypeEnum.UPDATE)
    @PreAuthorize("@permissionHandler.hasAnyAuthority(this,'ROLE_ADMINISTRATOR','update')")
    default Result<String> updateById(@PathVariable("id") ID id, @Validated @RequestBody DTO dto) {
        ValidatorUtils.validate(dto);
        ISuperBaseService service = getBaseService();
        if (null != service) {
            service.updateById(id, dto);
            return R.success("修改成功");
        }
        return R.result(ResponseStatusEnum.PARAMS_REQUIRED_IS_NULL, "service is null");
    }
}
