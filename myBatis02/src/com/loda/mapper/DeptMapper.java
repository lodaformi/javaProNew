package com.loda.mapper;

import com.loda.pojo.Dept;

/**
 * @Author loda
 * @Date 2022/10/18 10:39
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public interface DeptMapper {
    Dept selectDeptByDeptno(Integer deptno);
}
