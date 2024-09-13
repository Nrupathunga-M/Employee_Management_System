package com.example.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.crm.entity.Customer;
import com.example.crm.service.CustomerServiceImpl;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl serviceImpl;
	
	@RequestMapping(value="/customer/list", method = RequestMethod.GET)
    public ModelAndView customerList(){
		List<Customer> custList=serviceImpl.getCustomers();
		ModelAndView model=new ModelAndView("Home");
		model.addObject("list", custList);
		return model;
    }
	
	@RequestMapping(value="/customer/add", method = RequestMethod.GET)
    public String addCustomer(){		
		return "Customer";
    }
	
//	@RequestMapping(value="/customer/save", method = RequestMethod.POST)
//    public ModelAndView addCustomer(@RequestParam String fname,@RequestParam String lname,@RequestParam String emailid, @RequestParam String id){
//		String res="";
//		if (id=="") {
//			res = serviceImpl.saveCustomer(fname, lname, emailid);
//		}
//		else {
//			res = serviceImpl.updateCustomer(Integer.parseInt(id),fname, lname, emailid);
//		}
//		List<Customer> custList=serviceImpl.getCustomers();
//		ModelAndView model=new ModelAndView("Home");
//		model.addObject("list", custList);
//		return model;
//    }
	
	@RequestMapping(value="/customer/save", method = RequestMethod.POST)
    public ModelAndView addCustomer(@RequestParam String fname,@RequestParam String lname,@RequestParam String emailid,@RequestParam String phonenum, @RequestParam String id){
		String res="";
		if (id=="") {
			res = serviceImpl.saveCustomer(fname, lname, emailid,phonenum);
		}
		else {
			res = serviceImpl.updateCustomer(Integer.parseInt(id),fname, lname, emailid, phonenum);
		}
		List<Customer> custList=serviceImpl.getCustomers();
		ModelAndView model=new ModelAndView("Home");
		model.addObject("list", custList);
		return model;
    }
	
	@RequestMapping(value="/customer/delete", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@RequestParam int id){
		String res= serviceImpl.deleteCustomer(id);
		List<Customer> custList=serviceImpl.getCustomers();
		ModelAndView model=new ModelAndView("Home");
		model.addObject("list", custList);
		return model;
    }
	
	@RequestMapping(value="/customer/update", method = RequestMethod.GET)
    public ModelAndView GetCustomerById(@RequestParam int id){
		Customer custObj= serviceImpl.getCustomerById(id);
		ModelAndView model=new ModelAndView("Customer");
		model.addObject("custObj", custObj);
		return model;
    }

}
