package com.practice.aop.demo.aop;

import com.practice.aop.demo.security.PermissionAuthImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Configuration
public class AuthAspect {

    @Autowired
    private PermissionAuthImpl permissionAuthImpl;

    @Before("@annotation(com.practice.aop.demo.annotation.Authorize) && args(request,..)")
    public void before(HttpServletRequest request) {

        String apiKey = getApiKey(request);
        if (!permissionAuthImpl.authorize(apiKey))
            throw new RuntimeException("Authorization Error..!!!");
    }

    private String getApiKey(HttpServletRequest request) {
        String apiKey;
        if (null == request)
            throw new RuntimeException("Request cannot be null");

        apiKey = request.getHeader("api-key");
        if (null == apiKey)
            throw new RuntimeException("APIkey cannot be null");

        return apiKey;
    }
}
