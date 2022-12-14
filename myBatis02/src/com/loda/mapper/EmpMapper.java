package com.loda.mapper;

import com.loda.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author loda
 * @Date 2022/10/18 10:39
 * @Description emp表接口
 * @Version 1.0
 */
public interface EmpMapper {
    //select
    //根据员工编号查找员工信息
    Emp selectEmpByEmpno(Integer num);

    //根据员工工资和部门编号查找员工信息
//    List<Emp> selectEmpBySalAndDeptno(Double salary, Integer deptnum);
    List<Emp> selectEmpBySalAndDeptno(Emp emp);
//    List<Emp> selectEmpBySalAndDeptno(@Param("salary") Double s, @Param("deptnum") Integer d);

    //动态sql-if
    List<Emp> selectEmpDynamicIf(Emp emp);

    //动态sql-where
    List<Emp> selectEmpDynamicWhere(Emp emp);

    //动态sql-trim
    List<Emp> selectEmpDynamicTrim(Emp emp);

    //模糊查询
    List<Emp> selectEmpByLike(String str);
    //add

    //delete

    //update
}
