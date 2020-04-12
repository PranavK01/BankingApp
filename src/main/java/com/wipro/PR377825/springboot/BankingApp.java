package com.wipro.PR377825.springboot;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.wipro.PR377825.springboot.entity.CurrentAccount;
import com.wipro.PR377825.springboot.entity.Customer;
import com.wipro.PR377825.springboot.entity.SavingAccount;
import com.wipro.PR377825.springboot.repository.CurrentAccRepo;
import com.wipro.PR377825.springboot.repository.CustomerRepo;
import com.wipro.PR377825.springboot.repository.SavingAccRepo;


@SpringBootApplication
public class BankingApp extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BankingApp.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BankingApp.class, args);
	}

//	@Bean
//	  CommandLineRunner insertSavingData(SavingAccRepo saveRepo, CurrentAccRepo currentRepo, CustomerRepo custRepo) {
//	    return args -> {
//	     logger.info("Preloading " + saveRepo.save(new SavingAccount("Saving", 10000.00, "INR", "Active")));
////	      logger.info("Preloading " + saveRepo.save(new SavingAccount("Saving", 10000.00, "INR", "Active")));
//	   
//	     logger.info("Preloading " + currentRepo.save(new CurrentAccount("Current", 1000.00, "INR", "Active")));
////	      logger.info("Preloading " + currentRepo.save(new CurrentAccount("Current", 1000.00, "INR", "Active")));
//	 
//	     logger.info("Preloading " + custRepo.save(new Customer("PK01", "123", "Pranav", "Kalra", "pranav.kalra3@wipro.com", "9717275141")));
////	      logger.info("Preloading " + custRepo.save(new Customer("AB02", "1234", "ABC", "XYZ", "abc.xyz@wipro.com", "9898976670")));
//	    };
//	  }
	
}
