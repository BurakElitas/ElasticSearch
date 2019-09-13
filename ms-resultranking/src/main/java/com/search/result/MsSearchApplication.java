package com.search.result;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class MsSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSearchApplication.class, args);
	}

}
