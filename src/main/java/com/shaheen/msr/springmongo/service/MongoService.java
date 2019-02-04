package com.shaheen.msr.springmongo.service;


import com.shaheen.msr.springmongo.model.Customer;
import com.shaheen.msr.springmongo.model.Role;
import com.shaheen.msr.springmongo.repository.CustomerRepository;
import com.shaheen.msr.springmongo.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MongoService {
    private final CustomerRepository repository;
    private final RoleRepository roleRepository;

    public MongoService(CustomerRepository repository, RoleRepository roleRepository) {

        this.repository = repository;
        this.roleRepository = roleRepository;

        log.info("****************************Initializing Mongo Role Database");

        Role adminRole = roleRepository.findByRole("ADMIN");
        if (adminRole == null) {
            Role newAdminRole = new Role();
            newAdminRole.setRole("ADMIN");
            roleRepository.save(newAdminRole);
        }

        Role userRole = roleRepository.findByRole("USER");
        if (userRole == null) {
            Role newUserRole = new Role();
            newUserRole.setRole("USER");
            roleRepository.save(newUserRole);
        }

        /*log.info("****************************Initializing MongoService");
        deleteAllData();
        saveSomeData();
        fetchUser();*/
    }

    public void deleteAllData() {
        log.info("****************************MongoService | Deleting all data.");
        repository.deleteAll();
    }

    public void saveSomeData() {
        log.info("****************************MongoService | Saving some data.");
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));
    }

    public void fetchUser() {
        Customer customer = repository.findByFirstName("Alice");
        log.info("****************************Found Customer : {}", customer.toString());
        List<Customer> customerList = repository.findByLastName("Smith");
        log.info("****************************CustomerList: {}", customerList.toString());
    }
}
