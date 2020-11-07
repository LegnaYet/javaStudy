package com.legnaYet.sqlSession;

import com.legnaYet.pojo.Configuration;
import com.legnaYet.pojo.MappedStatement;

import java.beans.IntrospectionException;
import java.lang.reflect.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @author yechenhao
 * @version 1.0
 * @date 2020/11/7 12:08 AM
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> selectList(String statementId, Object... params) throws IllegalAccessException, IntrospectionException, InstantiationException, NoSuchFieldException, SQLException, InvocationTargetException, ClassNotFoundException {
        //将要完成对simpleExecutor里的query方法的调用
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
        List<Object> query = simpleExecutor.query(configuration, mappedStatement, params);
        return (List<E>) query;
    }

    @Override
    public <T> T selectOne(String statementId, Object... params) throws IllegalAccessException, ClassNotFoundException, IntrospectionException, InstantiationException, SQLException, InvocationTargetException, NoSuchFieldException {
        List<Object> objects = selectList(statementId, params);
        if (objects.size() == 1){
            return (T) objects.get(0);
        }else{
            throw new RuntimeException("查询结果为空或者返回结果过多");
        }
    }

    @Override
    public <T> T getMapping(Class<?> mapperClass) {
        //使用JDBC动态代理为dao接口生成代理对象并返回
        Object o = Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //底层都还是执行JDBC代码  根据不同情况，来调用selectList或者selectOne
                //准备参数 1、statementId ：sql语句的唯一标识 namespace.id = 接口全限定名.方法名
                //方法名
                String name = method.getName();
                //接口全限定名
                String className = method.getDeclaringClass().getName();
                String statementId = className + "." +name;

                //准备参数2：params：args

                //获取被调用方法的返回值类型
                Type genericReturnType = method.getGenericReturnType();
                //判断是否进行了范型类型参数化
                if (genericReturnType instanceof ParameterizedType){
                    List<Object> objects = selectList(statementId, args);
                    return objects;
                }else{
                    return selectOne(statementId,args);
                }
            }
        });
        return (T) o;
    }
}
