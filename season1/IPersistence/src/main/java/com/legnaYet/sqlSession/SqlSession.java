package com.legnaYet.sqlSession;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author yechenhao
 * @version 1.0
 * @date 2020/11/7 12:07 AM
 */
public interface SqlSession {
    /**
     * 查询所有
     * @param <E>
     * @param statementId
     * @param params
     * @return
     */
    <E> List<E> selectList(String statementId,Object... params) throws IllegalAccessException, IntrospectionException, InstantiationException, NoSuchFieldException, SQLException, InvocationTargetException, ClassNotFoundException;

    /**
     * 根据条件查询单个
     * @param statementId
     * @param params
     * @param <T>
     * @return
     */
    <T> T selectOne(String statementId,Object... params) throws IllegalAccessException, ClassNotFoundException, IntrospectionException, InstantiationException, SQLException, InvocationTargetException, NoSuchFieldException;
}
