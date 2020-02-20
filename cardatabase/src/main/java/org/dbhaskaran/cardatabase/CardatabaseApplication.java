package org.dbhaskaran.cardatabase;

import org.dbhaskaran.dao.CarRepository;
import org.dbhaskaran.dao.OwnerRepository;
import org.dbhaskaran.dto.Car;
import org.dbhaskaran.dto.Owner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("org.dbhaskaran.dto")
@EnableJpaRepositories("org.dbhaskaran.dao")
public class CardatabaseApplication {
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	@Autowired
	private CarRepository carRepo;

	@Autowired
	private OwnerRepository ownRepo;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Hello Spring Boot");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {

			// Add Owners
			Owner o1 = new Owner("John", "Larmor");
			Owner o2 = new Owner("Mary", "Kasman");
			ownRepo.save(o1);
			ownRepo.save(o2);
			// Save demo data to database
			carRepo.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, o1));
			carRepo.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, o2));
			carRepo.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, o2));
		};
	}
}
