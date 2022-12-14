package com.loda.service;

import com.loda.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * @Author loda
 * @Date 2022/11/12 9:29
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class RoleService {
//    @Resource
    @Autowired
//    @Qualifier("roleDao")
    private RoleDao roleDao;

//    @Autowired
//    @Resource
//    public void setRoleDao(RoleDao roleDao) {
//        this.roleDao = roleDao;
//    }

    public void test() {
        System.out.println("RoleService test...");
        roleDao.test();
    }
}
