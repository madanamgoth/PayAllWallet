package com.payallwallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PayAllWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayAllWalletApplication.class, args);
	}
}
