package com.shaheen.msr.springmongo.repository;

import java.util.List;

import com.shaheen.msr.springmongo.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);

    public List<Customer> findByLastName(String lastName);

}