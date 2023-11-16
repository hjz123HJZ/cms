package com.briup.service.impl;

import com.briup.bean.Log;
import com.briup.dao.LogDao;
import com.briup.service.ILogService;
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
public class LogServiceImpl extends ServiceImpl<LogDao, Log> implements ILogService {

}
