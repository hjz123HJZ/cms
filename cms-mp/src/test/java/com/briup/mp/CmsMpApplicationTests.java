package com.briup.mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.briup.mp.bean.User;
import com.briup.mp.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CmsMpApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
    }

    @Test
    void testGetAll() {
        List<User> userList = userDao.selectList(null);
        System.out.println(userList);
    }

    //分页查询
    @Test
    void testSelectPage() {
        //1 创建IPage分页对象,设置分页参数
        IPage<User> page = new Page<>(1, 3);
        //不带条件的分页查询
        userDao.selectPage(page, null);
        //3 获取分页结果
        System.out.println("当前页码值：" + page.getCurrent());
        System.out.println("每页显示数：" + page.getSize());
        System.out.println("总页数：" + page.getPages());
        System.out.println("总条数：" + page.getTotal());
        System.out.println("当前页数据：" + page.getRecords());
    }

    //条件查询
    @Test
    public void query() {
        QueryWrapper<User> pw = new QueryWrapper<>();
        //less than grater then  le也叫 less equals
        pw.lt("age", 15);
        List<User> users = userDao.selectList(pw);
        for (User user : users) {
            System.out.println(user);
        }

    }

    //条件查询 lambda表达式
    @Test
    public void query1() {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        //条件
        lqw.le(User::getAge, 15);
        List<User> users = userDao.selectList(lqw);
        users.forEach(System.out::println);
    }

    //组合条件查询
    @Test
    void testSelectByConditions() {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        //条件 大于10小于20
        lqw.lt(User::getAge, 20).gt(User::getAge, 10);
        List<User> users = userDao.selectList(lqw);
        users.forEach(System.out::println);
    }

    @Test
    void testSelectByConditions1() {
        //或者关系
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        //或者关系：小于10岁或者大于25岁
        lqw.lt(User::getAge, 10).or().gt(User::getAge, 25);
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
    }
}
