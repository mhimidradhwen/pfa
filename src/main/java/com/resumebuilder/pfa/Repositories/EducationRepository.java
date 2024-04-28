package com.resumebuilder.pfa.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.resumebuilder.pfa.Models.Education;

@Repository
public interface EducationRepository extends MongoRepository<Education,String>{

    @Query("{UID:?0}")
    List<Education> findAllByUID(Long id);
    
}
