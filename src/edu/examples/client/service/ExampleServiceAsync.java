package edu.examples.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.examples.client.model.Customer;

public interface ExampleServiceAsync {

	void readCustomer(String customerId,AsyncCallback callback);
	void updateCustomer(Customer customer,AsyncCallback callback);
	void deleteCustomer(String customerId,AsyncCallback callback);
	void createCustomer(Customer customer,AsyncCallback callback);

}
