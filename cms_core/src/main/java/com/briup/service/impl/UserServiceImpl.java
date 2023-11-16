package com.briup.service.impl;

import com.briup.bean.User;
import com.briup.dao.UserDao;
import com.briup.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
