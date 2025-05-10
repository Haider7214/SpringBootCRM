package com.telusko.SpringCRMWebappThymleaf.repo;

import org.springframework.data.repository.CrudRepository;

import com.telusko.SpringCRMWebappThymleaf.model.Customer;

public interface ICustomerRepo extends CrudRepository<Customer, Integer> {

}
