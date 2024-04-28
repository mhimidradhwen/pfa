package com.resumebuilder.pfa.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.resumebuilder.pfa.Models.Education;

@Repository
public interface EducationRepository extends MongoRepository<Education,String>{
    
}
