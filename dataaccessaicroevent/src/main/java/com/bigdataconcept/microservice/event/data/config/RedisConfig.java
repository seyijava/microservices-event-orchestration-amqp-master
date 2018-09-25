package com.bigdataconcept.microservice.event.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;



/*@Profile("redis")
@Configuration
@ComponentScan("com.bigdataconcept.microservice.event.data")
@EnableRedisRepositories(basePackages = "com.bigdataconcept.microservice.event.data.dao")
@PropertySource("classpath:application.properties")*/
public class RedisConfig {

  /* 
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }*/
}
