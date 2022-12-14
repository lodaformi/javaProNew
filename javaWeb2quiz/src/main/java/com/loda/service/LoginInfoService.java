package com.loda.service;

import com.loda.base.BaseService;
import com.loda.dao.LoginInfoMapper;
import com.loda.entity.po.LoginInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author loda
 * @Date 2022/12/6 16:37
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class LoginInfoService extends BaseService<LoginInfo, Integer> {
    @Resource
    private LoginInfoMapper loginInfoMapper;
}
