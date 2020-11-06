package com.legnaYet.mybatis.test;

import com.legnaYet.io.Resources;
import com.legnaYet.mybatis.user.pojo.User;
import com.legnaYet.sqlSession.SqlSession;
import com.legnaYet.sqlSession.SqlSessionFactory;
import com.legnaYet.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * @author yechenhao
 * @version 1.0
 * @date 2020/11/6 4:02 PM
 */
public class IPersistenceTest {

    @Test
    public void test() throws PropertyVetoException, DocumentException, IllegalAccessException, IntrospectionException, InstantiationException, NoSuchFieldException, SQLException, InvocationTargetException, ClassNotFoundException {
        InputStream inputStream = Resources.getResourcesAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(1);
        user.setUsername("lucy");
        User u = sqlSession.selectOne("user.selectOne", user);
        System.out.println(u);
    }
}
