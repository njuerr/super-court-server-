package com.tingtu.ax.admin.security.handler;

import com.tingtu.ax.admin.commons.enums.ResponseStatusEnum;
import com.tingtu.ax.admin.domain.result.R;
import com.tingtu.ax.admin.domain.result.Result;
import com.hb0730.jsons.SimpleJsonProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 验证失败
 *
 * @author Administrator
 * @see org.springframework.security.web.authentication.AuthenticationFailureHandler
 * @since 1.0.0
 */
@Component
public class AuthenticationEntryPointServiceHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        authException.printStackTrace();
        String resultParams = String.format("请求访问:%s ,认证失败,无法访问系统资源", request.getRequestURI());
        Result<String> result = R.result(ResponseStatusEnum.UNAUTHORIZED, resultParams);
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        response.getWriter().println(SimpleJsonProxy.json.toJson(result));

    }
}
