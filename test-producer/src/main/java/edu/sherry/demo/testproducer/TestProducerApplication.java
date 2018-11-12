package edu.sherry.demo.testproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"edu.sherry.demo"})
@EnableDiscoveryClient
@SpringBootApplication
public class TestProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestProducerApplication.class, args);
	}
}
