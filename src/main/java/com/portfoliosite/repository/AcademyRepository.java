package com.portfoliosite.repository;

import com.portfoliosite.model.AcademyInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyRepository extends MongoRepository<AcademyInfo, String> {}
