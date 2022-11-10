package com.auction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
@EnableEurekaClient
public class BidServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BidServiceApplication.class, args);
	}


}
