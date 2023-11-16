package com.briup.mp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.briup.mp.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: dmc(hjz)
 * @Date: 2023/11/14-11-14-15:09
 * @Description：com.briup.mp.dao
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}
