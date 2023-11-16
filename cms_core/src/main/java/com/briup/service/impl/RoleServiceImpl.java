package com.briup.service.impl;

import com.briup.bean.Role;
import com.briup.dao.RoleDao;
import com.briup.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements IRoleService {

}
