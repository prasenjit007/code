package com.spring.pracktice.springreactfullstackapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@ComponentScan("com.spring")
@EnableJpaRepositories("com.spring.pracktice.repoaitory")
@EntityScan("com.spring.pracktice.domain")
@CrossOrigin
public class SpringReactFullstackApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringReactFullstackApplication.class, args);
	}
}
