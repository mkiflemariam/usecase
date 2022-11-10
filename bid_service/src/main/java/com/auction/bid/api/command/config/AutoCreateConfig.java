package com.auction.bid.api.command.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("local")
public class AutoCreateConfig {
	
	@Bean
	public NewTopic bidEvents() {
		return TopicBuilder.name("bid-events").partitions(3).replicas(3).build();
	}

}
