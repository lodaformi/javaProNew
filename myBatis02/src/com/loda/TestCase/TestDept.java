package com.loda.TestCase;

import com.loda.mapper.DeptMapper;
import com.loda.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/10/18 20:49
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class TestDept {
    private SqlSessionFactory factory;
    @Before
    public void setFactory() throws IOException {
        factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));
    }

    @Test
    public void testSelectDeptByDeptno() {
        SqlSession session = factory.openSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);

        Dept dept = mapper.selectDeptByDeptno(10);
        System.out.println(dept);

        session.close();
    }
}
