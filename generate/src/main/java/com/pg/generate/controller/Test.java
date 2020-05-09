package com.pg.generate.controller;

import com.pg.generate.entity.Users;
import com.pg.generate.service.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class Test {

    @Resource
    private UsersService usersService;

    @GetMapping(value = "/test1")
    public List<Users> aa() {
        List<Users> list = usersService.list();
        return list;
    }

}
