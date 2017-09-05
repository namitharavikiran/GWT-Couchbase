package edu.examples.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.examples.client.events.DataEvent;
import edu.examples.client.model.Customer;
import edu.examples.client.model.ImagesList;

@RemoteServiceRelativePath("exampleservice")
public interface ExampleService extends RemoteService{

	DataEvent readCustomer(String CustId);
	DataEvent updateCustomer(Customer Cust);
	DataEvent createCustomer(Customer Cust);
	DataEvent deleteCustomer(String CustId);
	
}
