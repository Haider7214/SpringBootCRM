package com.telusko.SpringCRMWebappThymleaf.service;

import java.util.List;

import com.telusko.SpringCRMWebappThymleaf.model.Customer;

public interface ICustomerService 
{
	public List<Customer> getCustomerInfo();
	public void registerCustomer(Customer customer);
	public Customer fetchCxById(Integer id);
	public void deleteCxRecord(Integer id);

}
