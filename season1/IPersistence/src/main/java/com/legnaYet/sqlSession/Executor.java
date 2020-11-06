package com.legnaYet.sqlSession;

import com.legnaYet.pojo.Configuration;
import com.legnaYet.pojo.MappedStatement;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author yechenhao
 * @version 1.0
 * @date 2020/11/7 12:26 AM
 */
public interface Executor {
    <E> List<E> query(Configuration configuration, MappedStatement mappedStatement,Object... params) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, IntrospectionException, InstantiationException, InvocationTargetException;
}
