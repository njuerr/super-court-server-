package com.tingtu.ax.admin.task.handler;

import com.tingtu.ax.admin.commons.enums.JobActionEnum;
import com.tingtu.ax.admin.project.system.quartz.mapper.IJobMapper;
import com.tingtu.ax.admin.task.domain.JobInfo;
import org.quartz.SchedulerException;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 新增
 *
 * @author Administrator
 */
@Component
public class JobAddAction extends AbstractAction {

    public JobAddAction(JobHelper helper, IJobMapper mapper) {
        super(helper, mapper);
    }

    @Override
    public void run(@Nullable Collection<? extends Serializable> ids) throws SchedulerException {
        List<JobInfo> jobInfos = getJobInfo(ids);
        for (JobInfo jobInfo : jobInfos) {
            getJobHelper().addJob(jobInfo);
        }
    }

    @Override
    public boolean support(@NonNull JobActionEnum actionEnum) {
        return JobActionEnum.ADD_NEW.equals(actionEnum);
    }

    @Override
    public JobActionEnum getActionEnum() {
        return JobActionEnum.ADD_NEW;
    }
}
