package edu.examples.client.events;

import edu.examples.client.model.Customer;

public class CustomerCreatedEvent extends DataEvent  {
	private Customer theCustomer;

	public Customer getTheCustomer() {
		return theCustomer;
	}

	public void setTheCustomer(Customer theCustomer) {
		this.theCustomer = theCustomer;
	}
}
