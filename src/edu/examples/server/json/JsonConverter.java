package edu.examples.server.json;

import edu.examples.client.model.Customer;

public interface JsonConverter {
	Customer fromJson(String source, Customer type);

	String toJson(Customer source);
}