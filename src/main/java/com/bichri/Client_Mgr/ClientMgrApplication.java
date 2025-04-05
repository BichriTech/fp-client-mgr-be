package com.bichri.Client_Mgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active:default}.yml")
public class ClientMgrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientMgrApplication.class, args);
	}

}
