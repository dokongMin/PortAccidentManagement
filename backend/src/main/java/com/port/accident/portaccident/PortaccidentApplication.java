package com.port.accident.portaccident;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

@SpringBootApplication
public class PortaccidentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortaccidentApplication.class, args);
	}

//	@Bean
//	JPAQueryFactory jpaQueryFactory(EntityManager em){
//		return new JPAQueryFactory(em);
//	}
}
