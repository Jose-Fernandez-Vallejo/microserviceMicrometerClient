package com.example.microservicioCircuitBreakerMicrometerClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.microservicioCircuitBreakerMicrometerClient.services.StatusService;

@SpringBootApplication
public class MicroservicioCircuitBreakerMicrometerClientApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(MicroservicioCircuitBreakerMicrometerClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		StatusService service = new StatusService();
		
		for (int i = 0; i < 5; i++) {
			
			
			if (i < 4) {
				service.open();
				service.halfOpen();
				Thread.sleep(1000);
			}
			
			if (i == 4) {
				service.close();
			}

			

		}
		
		
		
	}

}
