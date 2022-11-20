package com.profeel.monsterfac.monsterfactoryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonsterFactoryServerApplication {

//	public static final String APPLICATION_LOCATIONS = "spring.config.location="
//			+ "classpath:application.yml, "
//			+ "classpath:aws.yml";
	public static void main(String[] args) {
//		new SpringApplicationBuilder(MonsterFactoryServerApplication.class)
//				.properties(APPLICATION_LOCATIONS)
//						.run(args);
		SpringApplication.run(MonsterFactoryServerApplication.class, args);
	}

}
