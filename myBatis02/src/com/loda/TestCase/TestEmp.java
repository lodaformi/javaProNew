package com.loda.TestCase;

import com.loda.mapper.EmpMapper;
import com.loda.pojo.Emp;
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
 * @Date 2022/10/18 10:46
 * @Description 测试类
 * @Version 1.0
 */
public class TestEmp {
    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void generFactory() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));
    }

    @Test
    public void testSelectEmpByEmpno() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        System.out.println(mapper.selectEmpByEmpno(7369));

        sqlSession.close();
    }

    @Test
    public void testSelectEmpBySalAndDeptno() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

//        List<Emp> list = mapper.selectEmpBySalAndDeptno(1500.0, 30);
        Emp emp = new Emp();
        emp.setSal(1500.0);
        emp.setDeptno(30);
        List<Emp> list = mapper.selectEmpBySalAndDeptno(emp);
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testSelectEmpDynamicIf() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

//        List<Emp> list = mapper.selectEmpBySalAndDeptno(1500.0, 30);
        Emp emp = new Emp();
//        emp.setSal(1500.0);
//        emp.setDeptno(30);
        List<Emp> list = mapper.selectEmpDynamicIf(emp);
        list.forEach(System.out::println);
        sqlSession.close();
    }


    @Test
    public void selectEmpDynamicWhere() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

//        List<Emp> list = mapper.selectEmpBySalAndDeptno(1500.0, 30);
        Emp emp = new Emp();
//        emp.setSal(1500.0);
//        emp.setDeptno(30);
        List<Emp> list = mapper.selectEmpDynamicWhere(emp);
        list.forEach(System.out::println);
        sqlSession.close();
    }


    @Test
    public void selectEmpDynamicTrim() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

//        List<Emp> list = mapper.selectEmpBySalAndDeptno(1500.0, 30);
        Emp emp = new Emp();
//        emp.setSal(1500.0);
//        emp.setDeptno(30);
        List<Emp> list = mapper.selectEmpDynamicTrim(emp);
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void selectEmpByLike() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        List<Emp> list = mapper.selectEmpByLike("A");
        list.forEach(System.out::println);
        sqlSession.close();
    }
}
