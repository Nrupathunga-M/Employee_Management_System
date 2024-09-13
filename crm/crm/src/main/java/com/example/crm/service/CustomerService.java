package com.example.crm.service;

import java.util.List;

import com.example.crm.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	public String saveCustomer(String firstName,String lastName,String phonenum,String emailID);
	public String deleteCustomer(int id);
	public String updateCustomer(int id,String firstName,String lastName,String emailID,String phonenum);
	public Customer getCustomerById(int id);
}
