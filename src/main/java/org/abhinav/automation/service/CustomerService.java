package org.abhinav.automation.service;
/*package org.arpit.java2blog.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.arpit.java2blog.dao.CustomerDao;
import org.arpit.java2blog.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("customerService")
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Transactional
	public List<Customer> getAllCustomers() {
		Customer customer = new Customer("Abhinav", "abhibansal60@gmail.com");
		Customer customer1 = new Customer("akshi", "sakshi2006@gmail.com");
		List<Customer> list= new ArrayList<Customer>();
		list.add(customer);
		list.add(customer1);
		return list;
		//return customerDao.getAllCustomers();
	}

	@Transactional
	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}

	@Transactional
	public Customer addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
		return customer;
	}

	@Transactional
	public Customer updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
		return customer;
	}

	@Transactional
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
	}
}
*/