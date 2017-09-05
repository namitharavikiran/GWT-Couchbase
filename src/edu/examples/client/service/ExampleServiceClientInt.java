package edu.examples.client.service;

import edu.examples.client.model.Customer;



public interface ExampleServiceClientInt {
	
	void readCustomer(String customerId);
	void updateCustomer(Customer customer);
	void deleteCustomer(String customerId);
	void createCustomer(Customer customer);
}
