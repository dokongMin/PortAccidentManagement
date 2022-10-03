package com.port.accident.portaccident;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

import javax.persistence.EntityManager;

@SpringBootApplication
public class PortaccidentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortaccidentApplication.class, args);
	}

	@Bean
	public PageableHandlerMethodArgumentResolverCustomizer customize() {
		/* pagination 1부터 시작하도록 설정 */
		return p -> {
			p.setOneIndexedParameters(true);	// 1부터 시작
			p.setMaxPageSize(10);				// size=10
		};
	}

}
