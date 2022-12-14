package com.loda.myredis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author loda
 * @Date 2022/12/7 20:37
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Configuration
public class RedisConfig {
    //服务器地址
    @Value("${spring.redis.host}")
    private String host;
    //服务器端口
    @Value("${spring.redis.port}")
    private Integer port;
    //访问密码
    @Value("${spring.redis.password}")
    private String password;
    //连接超时时间
    @Value("${spring.redis.timeout}")
    private String timeout;

    //最大连接数
    @Value("${spring.redis.jedis.pool.max-active}")
    private Integer maxTotal;
    //最大连接阻塞等待时间
    @Value("${spring.redis.jedis.pool.max-wait}")
    private String maxWaitMills;
    //最大空闲连接
    @Value("${spring.redis.jedis.pool.max-idle}")
    private Integer maxIdle;
    //最小空闲连接
    @Value("${spring.redis.jedis.pool.min-idle}")
    private Integer minIdle;

    @Bean
    public JedisPool getJedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxWaitMillis(Long.valueOf(maxWaitMills.substring(0, maxWaitMills.length()-2)));
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, Integer.valueOf(timeout.substring(0, timeout.length() - 2)), password);
        return jedisPool;
    }
}
