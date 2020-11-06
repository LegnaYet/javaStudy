package com.legnaYet.sqlSession;

import com.legnaYet.pojo.Configuration;

/**
 * @author yechenhao
 * @version 1.0
 * @date 2020/11/7 12:02 AM
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory{
    private Configuration configuration;
    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
