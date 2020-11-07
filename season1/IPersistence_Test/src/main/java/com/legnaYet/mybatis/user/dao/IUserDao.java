package com.legnaYet.mybatis.user.dao;

import com.legnaYet.mybatis.user.pojo.User;

import java.util.List;

/**
 * @author yechenhao
 * @version 1.0
 * @date 2020/11/7 6:07 PM
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据条件查询单个用户
     * @param user
     * @return
     */
    User findByCondition(User user);
}
