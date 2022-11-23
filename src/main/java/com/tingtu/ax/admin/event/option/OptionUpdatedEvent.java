package com.tingtu.ax.admin.event.option;

import org.springframework.context.ApplicationEvent;

/**
 * options update
 *
 * @author Administrator
 * @since 3.0.0
 */
public class OptionUpdatedEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public OptionUpdatedEvent(Object source) {
        super(source);
    }
}
