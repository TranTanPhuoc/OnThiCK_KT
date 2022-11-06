package com.serverCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ServerCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerCloudApplication.class, args);
	}

}
