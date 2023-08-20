package com.b3i.monsterspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class} )
public class MonsterSpringApplication {


	public static void main(String[] args) {
		SpringApplication.run(MonsterSpringApplication.class, args);
	}

}
