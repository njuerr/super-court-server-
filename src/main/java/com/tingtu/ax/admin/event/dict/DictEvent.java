package com.tingtu.ax.admin.event.dict;

import org.springframework.context.ApplicationEvent;

/**
 * 数据字典event
 *
 * @author Administrator
 * @since 3.0.0
 */
public class DictEvent extends ApplicationEvent {

    public DictEvent(Object source) {
        super(source);
    }
}
