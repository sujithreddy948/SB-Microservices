package in.jt.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class EmployeeServiceApplication {
	
	/*
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}*/
	
	/*
	@Bean
	WebClient webClient() {
		return WebClient.builder().build();
	}
	*/

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
