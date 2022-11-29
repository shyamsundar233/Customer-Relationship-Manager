package com.project1.CRM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project1.CRM.Entity.Customer;
import com.project1.CRM.Service.CustomerService;

@Controller
@RequestMapping("/crm")
public class HomeController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/listCustomers")
	public String listCustomers(Model theModel){
		
		List<Customer> customers = customerService.getCustomers();
		
		theModel.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	
	  @GetMapping("/showFormForAdd") 
	  public String showFormForAdd(Model theModel) {
		  
		  Customer customer = new Customer();
		  
		  theModel.addAttribute("customer", customer);
		  
		  return "customer-form"; 
	  }
	  
	  @PostMapping("/saveCustomer")
	  public String saveCustomer(@ModelAttribute ("customer") Customer customer) {
		  
		  customerService.saveCustomer(customer);
		  
		  return "redirect:/crm/listCustomers";
		  
	  }
	  
	  @GetMapping("/showFormForUpdate")
	  public String showFormForUpdate(@RequestParam("customerId") int id, Model theModel) {
		  
		  Customer customer = customerService.getCustomer(id);
		  
		  theModel.addAttribute("customer", customer);
		  
		  return "customer-form";
	  }
	  
	  @GetMapping("/delete")
	  public String delete(@RequestParam("customerId") int id) {
		  
		  customerService.deleteCustomer(id);
		  
		  return "redirect:/crm/listCustomers";
	  }
	 
	
}
