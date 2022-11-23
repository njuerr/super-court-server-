package com.tingtu.ax.admin.task.handler;

import com.tingtu.ax.admin.commons.enums.JobActionEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@Component
public class JobActionFactory {
    private final Map<JobActionEnum, IJobAction> actions = new HashMap<>(6);

    public JobActionFactory(ApplicationContext applicationContext) {
        Map<String, IJobAction> beans = applicationContext.getBeansOfType(IJobAction.class);
        if (!CollectionUtils.isEmpty(beans)) {
            beans.values().forEach(value -> actions.put(value.getActionEnum(), value));
        }
    }

    @Nullable
    public IJobAction getJobAction(JobActionEnum actionEnum) {
        return actions.get(actionEnum);
    }
}
