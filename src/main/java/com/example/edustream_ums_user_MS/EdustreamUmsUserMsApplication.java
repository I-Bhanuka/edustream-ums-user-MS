package com.example.edustream_ums_user_MS;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"com.example.edustream_ums_user_MS",
				"com.example.edustream_lib_security",
		})
@Slf4j
public class EdustreamUmsUserMsApplication implements CommandLineRunner {

	@Value("${server.port}")
	private int port;

	public static void main(String[] args) {
		SpringApplication.run(EdustreamUmsUserMsApplication.class, args);
	}

	// To run some code after the application starts.
	@Override
	public void run(String... args) throws Exception {
		log.info("EduStream User Microservice started");
		log.info("User Microservice is running at http://localhost:{}", port);

	}

}
