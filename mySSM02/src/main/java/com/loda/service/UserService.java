package com.loda.service;

import com.loda.dao.UserDao;
import com.loda.entity.po.User;
import com.loda.exceptions.BusinessException;
import com.loda.exceptions.ParamsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author loda
 * @Date 2022/11/16 17:51
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User queryUserById(Integer id) {
//                int a=1/0;
//        if(1==1){
//            throw  new ParamsException();
////            throw  new BusinessException();
//        }
        return userDao.queryUserById(id);
    }
}
