package com.loda.myspringsecurity01.config;

import com.loda.myspringsecurity01.handler.MyAccessDeniedHandler;
import com.loda.myspringsecurity01.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @Author loda
 * @Date 2022/12/10 11:54
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder getPw() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单提交
        http.formLogin()
                //当发现/login时认为是登录，必须和表单提交的地址一样，去执行UserServiceImpl
                .loginProcessingUrl("/login")
                //自定义登录页面
                .loginPage("/login.html")
                //登录成功后跳转页面，必须是POST请求
                .successForwardUrl("/toMain")
//                .successHandler(new MyAuthenticationSuccessHandler("/main.html"))
                //登录失败后跳转页面，POST请求
                .failureForwardUrl("/toError")
//                .failureHandler(new MyAuthenticationFailureHandler("/error.html"))
                .usernameParameter("myUserName")
                .passwordParameter("myUserPwd");

        //主要是对url进行控制，也就是我们所说的授权（访问控制）
        //匹配的页面或资源必须加上斜杠/，否则匹配不到
        http.authorizeRequests()
                //login.html不需要被认证
//                .antMatchers("/login.html").permitAll()
                //access方法
                .antMatchers("/login.html").access("permitAll()")

                //error.html不需要被认证
//                .antMatchers("/error.html").permitAll()
                .antMatchers("/error.html").access("permitAll()")
//                .antMatchers("/js/**", "/css/**", "/images/**").permitAll()
//                .antMatchers("/**/*.png").permitAll()
                .antMatchers("/**/*.png").access("permitAll()")
                //正则表达式匹配
                //放行任何目录下面的png
//                .regexMatchers(".+[.]png").permitAll()
//                .regexMatchers("*.png").permitAll()
                //请求方式必须是post，否则拦截
                .regexMatchers(HttpMethod.GET, "/demo").permitAll()
                //当有项目路径需要配置时，可以使用mvcMatchers的servletPath方法，
                // 也可以直接在Matchers参数中写上项目路径
//                .regexMatchers(HttpMethod.GET, "/loda/demo").permitAll()
//                .mvcMatchers("/demo").servletPath("/loda").permitAll()
                //权限判断，严格区分大小写
//                .mvcMatchers("/main1.html").hasAuthority("normaL")
//                .antMatchers("/main1.html").hasAnyAuthority("normal","normaL")
                //角色判断
                //不能以ROLE_开头，会报错
                .antMatchers("/main1.html").hasRole("loda")
//                .antMatchers("/main1.html").hasAnyRole("lodA", "loda")
//                .antMatchers("/main1.html").access("hasAnyRole(\"lodA\", \"loda\")")
                //IP判断，可以是网段
//                .antMatchers("/main1.html").hasIpAddress("192.168.10.252")
//                .antMatchers("/main1.html").access("hasIpAddress(\"192.168.10.252\")")
                //自定义方法，判断登录用户是否具有访问当前 URL 权限
                //？？request和authentication怎么拿到？？
//                .anyRequest().access("@myServiceImpl.hasPermission(request, authentication)");
        //所有请求都必须被认证，必须登录后被访问
                .anyRequest().authenticated();

        //关闭csrf防护
        http.csrf().disable();

        //退出登陆
        http.logout()
//                .addLogoutHandler()
                //可自定义退出的url
                .logoutUrl("/user/logout")
                //退出登陆跳转页面
                .logoutSuccessUrl("/login.html");

        //自定义403异常处理，跳转到自定义界面上
        http.exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler);

        http.rememberMe()
                //自定义登陆逻辑
                .userDetailsService(userDetailsService)
                //持久层对象
                .tokenRepository(persistentTokenRepository);
    }

    @Bean
    public PersistentTokenRepository getPersistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //自动建表,第一次启动时候需要,第二次启动注释掉
        // Table 'persistent_logins' already exists
//        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }


}
