package com.shaheen.msr.springmongo.repository;

import com.shaheen.msr.springmongo.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String role);
}