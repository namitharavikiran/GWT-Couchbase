package edu.examples.server.data;

import com.couchbase.client.java.document.JsonDocument;

import edu.examples.client.model.Customer;
import edu.examples.server.domain.Entity;

public interface Repository {
	JsonDocument findById(String id);
	
	JsonDocument create(Customer cust);

	JsonDocument update(Customer cust);

	JsonDocument upsert(Customer cust);

	void delete(String id);
}