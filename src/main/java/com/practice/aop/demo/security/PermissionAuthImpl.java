package com.practice.aop.demo.security;


import org.springframework.stereotype.Component;

@Component
public class PermissionAuthImpl {

    public boolean authorize(String apiKey) {

        return true;
    }
}
