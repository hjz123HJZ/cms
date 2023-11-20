package com.briup.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.briup.bean.User;
import com.briup.dto.in.Loginparam;
import com.briup.service.IUserService;
import com.briup.service.impl.UserServiceImpl;
import com.briup.util.Result;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: dmc(hjz)
 * @Date: 2023/11/20-11-20-11:14
 * @Description：com.briup.controller
 */
@Api(tags = "认证模块")
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final UserServiceImpl userService;
    @PostMapping("/login")
    //封装一个登录的接收对象，只需要用户名和密码
    public Result login(@RequestBody Loginparam user){
        String token = userService.login(user);
        return Result.success(token);
    }
}
