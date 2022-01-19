package com.experiment.TransferFileToDb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransferFileToDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransferFileToDbApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner test(OrderRepository repository){
		return (args)->{
			repository.save(new Order(2,123456,100.05, LocalDateTime.now()));
			for (Order order : repository.findAll()) {

				System.out.println(order.toString());
			}
			System.out.println(" id 1:- "+repository.getById(1L).toString());

		};
	}*/

}
