package com.banelethabede.beacon;

import org.springframework.boot.SpringApplication;

public class TestBeaconApplication {

	public static void main(String[] args) {
		SpringApplication.from(BeaconApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
