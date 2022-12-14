package com.loda.mybatis.test;

import com.loda.mybatis.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @Author loda
 * @Date 2022/10/17 10:58
 * @Description 测试类
 * @Version 1.0
 */
public class Demo01 {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));
    }

    @Test
    public void selectByDeptno() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Dept dept = sqlSession.selectOne("com.loda.mybatis.mapper.DeptMapper.selectDeptByDeptno", 20);

        System.out.println(dept);

        sqlSession.close();
    }

    @Test
    public void selectDeptAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<Dept> list = sqlSession.selectList("com.loda.mybatis.mapper.DeptMapper.selectDeptAll");

        System.out.println(list);

        sqlSession.close();
    }
}
