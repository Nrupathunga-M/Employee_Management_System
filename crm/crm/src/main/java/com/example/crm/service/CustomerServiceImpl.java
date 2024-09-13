package com.example.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crm.entity.Customer;
import com.example.crm.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;
	
	public List<Customer> getCustomers()
	{
		return customerRepo.findAll();
	}
	
	public Customer getCustomerById(int id)
	{
		return customerRepo.findById(id).get();
	}
	
	public String saveCustomer(String firstName,String lastName,String emailID,String phonenum)
	{
		Customer custObj=new Customer();
		custObj.setEmailid(emailID);
		custObj.setFirstname(firstName);
		custObj.setLastname(lastName);
		custObj.setPhonenum(phonenum);
		customerRepo.save(custObj);	
		
		return "Saved";
	}
	
	public String deleteCustomer(int id) {
	    Optional<Customer> cust = customerRepo.findById(id);
	    if (cust.isPresent()) {
	        customerRepo.deleteById(id);
	        return "Deleted";
	    } else {
	        return "Customer does not exist";
	    }
	}


	
	public String updateCustomer(int id,String firstName,String lastName,String emailID,String phonenum)
	{
		Optional<Customer> cust=customerRepo.findById(id);
		if(cust.isPresent())
		{
			Customer custObj=cust.get();
			custObj.setEmailid(emailID);
			custObj.setFirstname(firstName);
			custObj.setLastname(lastName);
			custObj.setPhonenum(phonenum);
			customerRepo.save(custObj);	
			
			return "Updated";
		}
		{
			return "Customer does not exists";
		}
	}
	

}
