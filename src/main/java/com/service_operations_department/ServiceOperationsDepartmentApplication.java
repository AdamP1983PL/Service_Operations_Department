package com.service_operations_department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:database.properties")
/*@EnableFeignClients annotation enables component scanning for interfaces that declare they are Feign Clients*/
@EnableFeignClients
public class ServiceOperationsDepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceOperationsDepartmentApplication.class, args);
	}

}
