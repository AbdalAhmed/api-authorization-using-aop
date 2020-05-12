package com.practice.aop.demo.controller;


import com.practice.aop.demo.domain.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping
    public List<User> getUsers() {
        return IntStream.range(0, 10).mapToObj(i ->
                new User(i, RandomStringUtils.random(10, true, false)))
                .collect(Collectors.toList());
    }


}
