package com.flow.mo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableCaching
@ComponentScan("com.flow.mo.api")
@SpringBootApplication
public class FlowMoApiApplication extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer{
	
	private static Logger logger = LoggerFactory.getLogger(FlowMoApiApplication.class);
	
	public static void main(String[] args) {
		ApplicationContext applicationContext =SpringApplication.run(FlowMoApiApplication.class, args);
		
        for (String name: applicationContext.getBeanDefinitionNames()) {
        	logger.info("Bean Name" + name);
        }
	}
}
