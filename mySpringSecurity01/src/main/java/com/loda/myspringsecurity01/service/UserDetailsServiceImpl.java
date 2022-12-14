package com.loda.myspringsecurity01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author loda
 * @Date 2022/12/10 16:16
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private PasswordEncoder pw;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("exec loadUserByUsername 方法");
        if (!"admin".equals(username)) {
            throw new UsernameNotFoundException("用户名不存在！");
        }

        String password = pw.encode("123");
        return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList(
                "admin, normal, ROLE_loda, " +
                        "/main.html, /delete, /insert"
        ));
    }
}
