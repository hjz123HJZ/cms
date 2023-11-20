package com.briup.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.briup.bean.User;
import com.briup.dao.UserDao;
import com.briup.dto.in.Loginparam;
import com.briup.exception.ServiceException;
import com.briup.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.briup.util.JwtUtil;
import com.briup.util.ResultCode;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author briup
 * @since 2023-11-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

    public String login(Loginparam user) {
        //数据库查到的一条用户数据
        User one = this.getOne(Wrappers.lambdaQuery(User.class)
                .eq(User::getUsername, user.getUsername())
                .eq(User::getPassword, user.getPassword())
        );
        if (ObjectUtils.isEmpty(one)){
            throw new ServiceException(ResultCode.USER_LOGIN_ERROR);
        }
        if (!"启用".equals(one.getStatus())){
            throw new ServiceException(ResultCode.USER_ACCOUNT_FORBIDDEN);
        }
        //产生token
        Map<String,Object> map = new HashMap<>();
        //放入token的信息
        map.put("userId",one.getId());
        map.put("username", one.getUsername());
        String token = JwtUtil.generateJwt(map);
        return token;
    }
}
