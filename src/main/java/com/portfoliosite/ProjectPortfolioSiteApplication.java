package com.portfoliosite;

import com.portfoliosite.repository.AcademyRepository;
import com.portfoliosite.repository.ProfessionalRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {AcademyRepository.class, ProfessionalRepository.class})
public class ProjectPortfolioSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectPortfolioSiteApplication.class, args);
	}
}