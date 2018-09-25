package com.bigdataconcept.microservice.event.loan.processor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;




@Configuration
@ComponentScan("com.bigdataconcept.microservice.event.loan.processor")
@EnableRedisRepositories(basePackages = "com.bigdataconcept.microservice.event.loan.processor.dao")
public class RedisConfig {

    
    @Value("${spring.redis.host:localhost}")
    private String redisHost;
    
    
    @Value("${spring.redis.port}")
    private int redisPort;
    
  
    
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
	
	RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
	    configuration.setHostName(redisHost);
	    configuration.setPort(redisPort);
	JedisConnectionFactory jedisConFactory
	      = new JedisConnectionFactory(configuration);
	   
	
	return jedisConFactory;
    }
     
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}
