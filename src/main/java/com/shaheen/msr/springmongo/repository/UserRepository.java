package com.shaheen.msr.springmongo.repository;

import com.shaheen.msr.springmongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

}