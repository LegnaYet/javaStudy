package com.legnaYet.sqlSession;

/**
 * @author yechenhao
 * @version 1.0
 * @date 2020/11/6 11:05 PM
 */
public interface SqlSessionFactory {
    SqlSession openSession();
}
