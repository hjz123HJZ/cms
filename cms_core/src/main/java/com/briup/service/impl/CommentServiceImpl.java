package com.briup.service.impl;

import com.briup.bean.Comment;
import com.briup.dao.CommentDao;
import com.briup.service.ICommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentDao, Comment> implements ICommentService {

}
