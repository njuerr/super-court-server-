package com.tingtu.ax.admin.exceptions;

/**
 * 用户不存在
 *
 * @author Administrator
 */
public class UsernameNotFoundException extends AbstractException {
    public UsernameNotFoundException(String message) {
        super(message);
    }

    public UsernameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
