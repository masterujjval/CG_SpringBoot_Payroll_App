package com.employee.payroll_application.modules;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class ModulesApplication {
	private static final Logger log = LoggerFactory.getLogger(ModulesApplication.class);

	public static void main(String[] args) {
		ApplicationContext context=  SpringApplication.run(ModulesApplication.class, args);
		log.info("Logger started in {} Environment", context.getEnvironment().getProperty("environment"));
		log.info("Employee Payroll DB user is {}",context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
