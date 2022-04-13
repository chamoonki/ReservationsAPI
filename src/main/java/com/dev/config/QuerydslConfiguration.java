package com.dev.config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.querydsl.jpa.impl.JPAQueryFactory;

/**
 * Querydsl의 JPAQueryFactory를 주입 받아 사용하기 위해 
 * Configuration을 설정 해 준다.
 * 
 * @FileName : QuerydslConfiguration.java
 * @Project : api
 * @author : moonki
 * @date   : 2019. 10. 14.
 */
@Configuration
public class QuerydslConfiguration {
	
	/* 
	 * 
	 * Entity Manager는 Database Side에 엔티티를 반영하기 위한 객체입니다.
	 */
	@PersistenceContext
    private EntityManager entityManager;

	/*
	 * JPAQueryFactory를 어디서든지 사용하기 위해서 Bean에 등록 시켜 준다.
	 * QueryFactory를 주입 하기 위해 생성 해 준다.
	 */
    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
