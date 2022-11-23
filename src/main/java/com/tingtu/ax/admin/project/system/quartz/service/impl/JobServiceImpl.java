package com.tingtu.ax.admin.project.system.quartz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tingtu.ax.admin.commons.enums.JobActionEnum;
import com.tingtu.ax.admin.commons.utils.QueryWrapperUtils;
import com.tingtu.ax.admin.domain.service.impl.SuperBaseServiceImpl;
import com.tingtu.ax.admin.event.job.JobEvent;
import com.tingtu.ax.admin.exceptions.BusinessException;
import com.tingtu.ax.admin.project.system.quartz.mapper.IJobMapper;
import com.tingtu.ax.admin.project.system.quartz.model.dto.JobDTO;
import com.tingtu.ax.admin.project.system.quartz.model.entity.JobEntity;
import com.tingtu.ax.admin.project.system.quartz.model.query.JobParams;
import com.tingtu.ax.admin.project.system.quartz.service.IJobService;
import com.tingtu.ax.admin.task.quartz.utils.CronUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

/**
 * 定时任务(quartz)  服务实现类
 *
 * @author Administrator
 * @since 3.0.0
 */
@Service
@RequiredArgsConstructor
public class JobServiceImpl extends SuperBaseServiceImpl<Long, JobParams, JobDTO, JobEntity, IJobMapper> implements IJobService {
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public boolean save(@Nonnull JobDTO dto) {
        JobEntity entity = dto.convertTo();
        checkCron(entity.getCron());
        boolean result = save(entity);
        eventPublisher.publishEvent(new JobEvent(this, JobActionEnum.ADD_NEW, Collections.singletonList(entity.getId())));
        return result;
    }

    @Override
    public boolean updateById(JobEntity entity) {
        checkCron(entity.getCron());
        boolean result = super.updateById(entity);
        eventPublisher.publishEvent(new JobEvent(this, JobActionEnum.UPDATE, Collections.singletonList(entity.getId())));
        return result;
    }

    @Override
    public boolean removeById(Serializable id) {
        boolean result = super.removeById(id);
        eventPublisher.publishEvent(new JobEvent(this, JobActionEnum.DELETE, Collections.singletonList(id)));
        return result;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public boolean removeByIds(Collection<?> idList) {
        boolean result = super.removeByIds(idList);
        eventPublisher.publishEvent(new JobEvent(this, JobActionEnum.DELETE, (Collection<? extends Serializable>) idList));
        return result;
    }


    @Override
    public void execution(Long id) {
        eventPublisher.publishEvent(new JobEvent(this, JobActionEnum.RUN, Collections.singletonList(id)));
    }

    @Override
    public boolean updateIsPause(Long id, Integer isEnabled) {
        if (0 == isEnabled) {
            eventPublisher.publishEvent(new JobEvent(this, JobActionEnum.PAUSE, Collections.singletonList(id)));
        } else {
            eventPublisher.publishEvent(new JobEvent(this, JobActionEnum.RESUME, Collections.singletonList(id)));
        }
        return false;
    }

    @Override
    public QueryWrapper<JobEntity> query(@Nonnull JobParams params) {
        QueryWrapper<JobEntity> query = QueryWrapperUtils.getQuery(params);
        if (StrUtil.isNotBlank(params.getName())) {
            query.eq(JobEntity.NAME, params.getName());
        }
        if (StrUtil.isNotBlank(params.getGroup())) {
            query.eq(JobEntity.GROUP, params.getGroup());
        }
        if (Objects.nonNull(params.getIsEnabled())) {
            query.eq(JobEntity.IS_ENABLED, params.getIsEnabled());
        }
        return query;
    }

    private void checkCron(String cron) {
        if (StrUtil.isBlank(cron)) {
            throw new BusinessException("cron为空");
        }
        if (!CronUtils.isValid(cron)) {
            throw new BusinessException("cron不合法");
        }
    }
}
