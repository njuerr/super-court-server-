package com.tingtu.ax.admin.task.quartz.job;

import com.tingtu.ax.admin.project.system.quartz.model.entity.JobEntity;
import com.tingtu.ax.admin.task.domain.JobInvokeInfo;
import com.tingtu.ax.admin.task.utils.JobInvokeUtil;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;

/**
 * 定时任务处理（禁止并发执行）
 *
 * @author Administrator
 * @since 3.0.0
 */
@DisallowConcurrentExecution
public class QuartzDisallowConcurrentExecution extends AbstractQuartzJob {
    @Override
    void doExecute(JobExecutionContext context, JobEntity job) throws Exception {
        String bean = job.getBeanName();
        String method = job.getBeanMethod();
        String params = job.getMethodParams();
        JobInvokeUtil.invokeMethod(new JobInvokeInfo(bean, method, params));
    }
}
