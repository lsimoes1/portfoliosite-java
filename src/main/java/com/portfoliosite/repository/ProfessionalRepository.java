package com.portfoliosite.repository;

import com.portfoliosite.model.ProfessionalInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepository extends MongoRepository<ProfessionalInfo, String> {
}
