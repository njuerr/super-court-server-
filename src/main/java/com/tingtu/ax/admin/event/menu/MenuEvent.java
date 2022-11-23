package com.tingtu.ax.admin.event.menu;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 菜单event
 *
 * @author Administrator
 * @since 3.0.0
 */
public class MenuEvent extends ApplicationEvent {
    @Getter
    private final Long userId;

    public MenuEvent(Object source, Long userId) {
        super(source);
        this.userId = userId;
    }
}
