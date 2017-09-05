package edu.examples.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import edu.examples.client.events.DataEvent;
import edu.examples.client.gui.MainGUI;
import edu.examples.client.model.Customer;


public class ExampleServiceClientImpl implements ExampleServiceClientInt{
	
	private ExampleServiceAsync service;
	private MainGUI mainGUI;

public ExampleServiceClientImpl(String url)
{
	this.service 	= GWT.create(ExampleService.class);
	ServiceDefTarget endpoint = (ServiceDefTarget) this.service;
	endpoint.setServiceEntryPoint(url);
	
	this.mainGUI = new MainGUI(this);
}


public MainGUI getMainGUI()
{
	return this.mainGUI;
}
	
	@Override
	public void readCustomer(String customer) {

		this.service.readCustomer(customer,new DefaultCallback());
		
	}
	@Override
	public void updateCustomer(Customer customer) {
		this.service.updateCustomer(customer, new DefaultCallback());
	}

	@Override
	public void deleteCustomer(String customerId) {
		this.service.deleteCustomer(customerId, new DefaultCallback());
	}

	@Override
	public void createCustomer(Customer customer) {
	this.service.createCustomer(customer, new DefaultCallback());	
	}
	
	private class DefaultCallback implements AsyncCallback<DataEvent>
	{

		@Override
		public void onFailure(Throwable caught) {

			System.out.println("An Error Has Occured");
		}

		@Override
		public void onSuccess(DataEvent result) {
			mainGUI.handleEvent(result);
			
		}
		
	}

}
