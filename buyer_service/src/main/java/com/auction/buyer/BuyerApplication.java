package com.auction.buyer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BuyerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyerApplication.class, args);
	}

}
