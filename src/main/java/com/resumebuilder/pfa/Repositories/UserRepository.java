package com.resumebuilder.pfa.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.resumebuilder.pfa.Models.User;

@Repository
public interface UserRepository extends MongoRepository<User,Long>  {
    
}
