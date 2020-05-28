package com.example.accessingdatamongodb;

import com.example.accessingdatamongodb.model.Customer;
import com.example.accessingdatamongodb.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

	public static final Logger logger = LoggerFactory.getLogger(AccessingDataMongodbApplication.class);

	@Autowired
	CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		//save a few customers
		repository.save(new Customer("Khoa", "Nguyen"));
		repository.save(new Customer("Hoang", "Le"));
		repository.save(new Customer("Linh", "Bui"));
		repository.save(new Customer("Kien", "Dinh"));

		//fetch all customers
		logger.info("Customers found with findAll()");
		logger.info("------------------------------");
		for (Customer customer : repository.findAll()) {
			//System.out.println(customer);	//the toString() method will be called in this case.
			logger.info(customer.toString());
		}
		logger.info("");

		//fetch by id
		logger.info("Customer found with findByFirstName('Hoang')");
		logger.info("--------------------------------");
		Customer customer = repository.findByFirstName("Hoang");
		logger.info(customer.toString());
		logger.info("");

		//fetch by last name
		logger.info("Customer found with findByLastName(\"Nguyen\")");
		logger.info("----------------------------------------------");
		repository.findByLastName("Nguyen").forEach(nguyen -> logger.info(nguyen.toString()));
		logger.info("");
	}
}
