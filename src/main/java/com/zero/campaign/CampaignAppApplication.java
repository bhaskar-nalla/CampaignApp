package com.zero.campaign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.zero.campaign"})
@SpringBootApplication
public class CampaignAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampaignAppApplication.class, args);

	}
}
