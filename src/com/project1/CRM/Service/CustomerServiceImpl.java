package com.project1.CRM.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.CRM.Entity.Customer;
import com.project1.CRM.dao.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO customerdao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {		
		return customerdao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {		
		customerdao.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {		
		return customerdao.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerdao.deleteCustomer(id);
	}

}
