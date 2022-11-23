package com.tingtu.ax.admin.task.handler;

import com.tingtu.ax.admin.commons.enums.JobActionEnum;
import com.tingtu.ax.admin.project.system.quartz.mapper.IJobMapper;
import com.tingtu.ax.admin.task.domain.JobInfo;
import org.quartz.SchedulerException;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 立即执行
 *
 * @author Administrator
 */
@Component
public class JobRunAction extends AbstractAction {
    public JobRunAction(JobHelper helper, IJobMapper mapper) {
        super(helper, mapper);
    }

    @Override
    public void run(@Nullable Collection<? extends Serializable> ids) throws SchedulerException {
        List<JobInfo> jobInfos = getJobInfo(ids);
        for (JobInfo jobInfo : jobInfos) {
            getJobHelper().runJob(jobInfo.getId(), jobInfo.getGroup(), jobInfo);
        }
    }

    @Override
    public boolean support(JobActionEnum actionEnum) {
        return JobActionEnum.RUN.equals(actionEnum);
    }

    @Override
    public JobActionEnum getActionEnum() {
        return JobActionEnum.RUN;
    }
}
