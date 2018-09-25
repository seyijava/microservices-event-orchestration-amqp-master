package com.bigdataconcept.microservice.event.loan.loanProcessorService;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisConnection;
import redis.embedded.RedisServer;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.index.GeoIndexed;
import org.springframework.data.redis.core.index.Indexed;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bigdataconcept.microservice.event.loan.processor.config.RedisConfig;
import com.bigdataconcept.microservice.event.loan.processor.dao.LoanApplicationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisConfig.class)
public class LoanApplicationRepositoryTest<K,V> {
    
        private static final int DEFAULT_PORT = 6379;
	private RedisServer server;
	private int port = DEFAULT_PORT;
	private boolean suppressExceptions = false;
 
	
	
	
	
	@Autowired 
	LoanApplicationRepository loanApplicationRepository;
    
    
	
  
	@Before
	public  void before() throws IOException {

		try {

			this.server = new RedisServer(9090);
			 this.server.start();
		} catch (Exception e) {
			if (!suppressExceptions) {
				throw e;
			}
		}
	}

	
	@After
	public  void after() {

		try {
			this.server.stop();
		} catch (Exception e) {
			if (!suppressExceptions) {
				throw e;
			}
		}
	}

	
	@Test
	public void saveSingleEntity() {

		
		
	}
}
