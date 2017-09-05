package edu.examples.server;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.examples.client.events.CustomerCreatedEvent;
import edu.examples.client.events.CustomerDeletedEvent;
import edu.examples.client.events.CustomerRetrievedEvent;
import edu.examples.client.events.CustomerUpdatedEvent;
import edu.examples.client.events.DataEvent;
import edu.examples.client.model.Customer;
import edu.examples.client.service.ExampleService;
import edu.examples.server.data.CouchbaseRepository;
import edu.examples.server.data.Repository;

public class ExampleServiceImpl extends RemoteServiceServlet implements ExampleService{
	private static Cluster cluster;
	private JsonDocument record ;
	private static Repository repo;
	
	@Override
	public DataEvent readCustomer(String custId) 
	{
		Customer customer = new Customer();
		repo = getConnection();
		record = repo.findById(custId);
		System.out.println("Result is: "+record);
		
		customer.setId(record.id());
		customer.setCas(record.cas());
		
		JsonObject jsonObject = record.content();
		
		customer.setUserName((String) jsonObject.get("userName"));
		customer.setFirstName((String) jsonObject.get("firstName"));
		customer.setLastName((String) jsonObject.get("lastName"));
		customer.setEmail((String) jsonObject.get("email"));
				
		cluster.disconnect();
		CustomerRetrievedEvent theEvent = new CustomerRetrievedEvent();
		theEvent.setTheCustomer(customer);
		return theEvent;
	}
	
	@Override
	public DataEvent updateCustomer(Customer cust) {

		System.out.println("Inside update Customer");
		Customer customer = new Customer();
		repo = getConnection();
		record = repo.update(cust);
		System.out.println("Result is: "+record);
		customer.setId(record.id());
		customer.setCas(record.cas());
		JsonObject jsonObject = record.content();
		customer.setUserName((String) jsonObject.get("userName"));
		customer.setFirstName((String) jsonObject.get("firstName"));
		customer.setLastName((String) jsonObject.get("lastName"));
		customer.setEmail((String) jsonObject.get("email"));
				
		cluster.disconnect();		
		CustomerUpdatedEvent theEvent = new CustomerUpdatedEvent();
		theEvent.setTheCustomer(customer);
		return theEvent;
	}

	@Override
	public DataEvent createCustomer(Customer cust) {
		
		Customer customer = new Customer();
		repo = getConnection();
		record = repo.create(cust);
		System.out.println("Result is: "+record);
		customer.setId(record.id());
		customer.setCas(record.cas());
		JsonObject jsonObject = record.content();
		customer.setUserName((String) jsonObject.get("userName"));
		customer.setFirstName((String) jsonObject.get("firstName"));
		customer.setLastName((String) jsonObject.get("lastName"));
		customer.setEmail((String) jsonObject.get("email"));
				
		cluster.disconnect();
		CustomerCreatedEvent theEvent = new CustomerCreatedEvent();
		theEvent.setTheCustomer(customer);
		return theEvent;
	}

	@Override
	public DataEvent deleteCustomer(String custId) {
		
		repo = getConnection();
		repo.delete(custId);
		System.out.println("Document Deleted Successfully!");
		cluster.disconnect();
		CustomerDeletedEvent theEvent = new CustomerDeletedEvent();
		return theEvent;
	}
		
	public static Repository getConnection()
	{						
		cluster = CouchbaseCluster.create("127.0.0.1");
				repo = 
				new CouchbaseRepository(cluster, "customer360");
				System.out.println("Before returning repo");
			return repo;
	}

	
}
