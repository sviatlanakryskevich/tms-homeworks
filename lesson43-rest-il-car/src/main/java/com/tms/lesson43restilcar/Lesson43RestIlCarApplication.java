package com.tms.lesson43restilcar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.tms.lesson43restilcar.client")
public class Lesson43RestIlCarApplication {
	public static void main(String[] args) {
		SpringApplication.run(Lesson43RestIlCarApplication.class, args);
	}
}
