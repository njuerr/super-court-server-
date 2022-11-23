package com.tingtu.ax.admin.event.job;

import com.tingtu.ax.admin.commons.enums.JobActionEnum;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;
import java.util.Collection;

/**
 * 任务调度 event
 *
 * @author Administrator
 */
public class JobEvent extends ApplicationEvent {
    @Getter
    private final JobActionEnum action;
    @Getter
    private final Collection<? extends Serializable> ids;

    public JobEvent(Object source, JobActionEnum action, Collection<? extends Serializable> ids) {
        super(source);
        this.action = action;
        this.ids = ids;
    }
}
