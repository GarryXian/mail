package com.garry.mail;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.time.Duration;
import java.time.Instant;

@MapperScan(basePackages = {"com.garry.mail.dao","com.baomidou.mybatisplus.core.mapper"})
@SpringBootApplication
@ComponentScan("com.garry.mail")
@EnableAutoConfiguration
public class MailApplication {

	private static Logger log = LoggerFactory.getLogger(MailApplication.class);

	public static void main(String[] args) {
		Instant start = Instant.now();
		SpringApplication.run(MailApplication.class, args);
		log.info("=== MailSerivice start success! cost time {} ms", Duration.between(start, Instant.now()).toMillis());
	}

}
