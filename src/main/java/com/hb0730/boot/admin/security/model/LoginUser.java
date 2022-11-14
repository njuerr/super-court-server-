package com.hb0730.boot.admin.security.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 响应
 *
 * @author Administrator
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class LoginUser extends User {
    private String accessToken;
}
