package com.project1.CRM.dao;

import java.util.List;

import com.project1.CRM.Entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);


}
