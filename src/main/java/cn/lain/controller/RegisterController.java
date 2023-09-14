package cn.lain.controller;

import cn.lain.utils.R;
import cn.lain.domain.User;
import cn.lain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private IUserService iUserService;

    @PostMapping
    public R register(@RequestBody User user) throws IOException {
        if (user.getWorkid().equals("a")) throw new IOException();
        boolean flag = iUserService.save(user);
        return new R(flag, flag ? "注册成功!" : "注册失败!");
    }

}
