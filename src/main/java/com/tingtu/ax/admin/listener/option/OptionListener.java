package com.tingtu.ax.admin.listener.option;

import com.tingtu.ax.admin.event.option.OptionUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

/**
 * option listener
 *
 * @author Administrator
 * @since 3.0.0
 */
@Component
@RequiredArgsConstructor
public class OptionListener implements ApplicationListener<OptionUpdatedEvent> {
    @Override
    public void onApplicationEvent(@Nonnull OptionUpdatedEvent event) {
    }
}
