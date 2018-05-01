package org.abhinav.automation.controller;

import java.util.List;

import org.abhinav.automation.model.User;
import org.abhinav.automation.service.SeleniumService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstaController {

	/*@Autowired
	CustomerService customerService;*/
	@Autowired
	SeleniumService seleniumService;

	/*@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Customer> getAllCustomers(Model model) {

		List<Customer> listOfCustomers = customerService.getAllCustomers();
		model.addAttribute("customer", new Customer());
		model.addAttribute("listOfCustomers", listOfCustomers);
		return listOfCustomers;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllCustomers";
	}

	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getCustomerById(@PathVariable int id) {
		customerService.getCustomer(id);
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);

	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer); 

	}	

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCustomer(@PathVariable("id") int id) {
		customerService.deleteCustomer(id);


	}*/
	@RequestMapping(value = "/selenium", method = RequestMethod.POST, headers = "Accept=application/json")
	public void startSelenium(@RequestBody User user) {
		System.out.println("Entering --startSelenium in CustomerController");
		
		if(user!=null){
			System.out.println("user"+ user.getUsername());
		seleniumService.startSelenium(user.getUsername(),user.getPassword(),user.getUsernames());
		}
		else
			System.out.println("Invalid user!");

	}
}
