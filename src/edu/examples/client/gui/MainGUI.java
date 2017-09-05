package edu.examples.client.gui;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.examples.client.events.CustomerCreatedEvent;
import edu.examples.client.events.CustomerDeletedEvent;
import edu.examples.client.events.CustomerRetrievedEvent;
import edu.examples.client.events.CustomerUpdatedEvent;
import edu.examples.client.events.DataEvent;
import edu.examples.client.model.Customer;
import edu.examples.client.service.ExampleServiceClientImpl;

public class MainGUI extends MyComposite {
	
private	VerticalPanel vPanel = new VerticalPanel();
private MyComposite currentPage;
private Customer customer;
private ExampleServiceClientImpl listener;
	
public MainGUI(ExampleServiceClientImpl listener)
{
	initWidget(vPanel);
	this.listener = listener;
	openDefaultPage();
}
public Customer getCustomer()
{
	return this.customer;
}
public void setCustomer(Customer cust)
{
	this.customer = cust;	
}
public void openCustomerInfoPage() {
	this.vPanel.clear();
	this.currentPage = new CustomerInfoPage(this, this.customer);
	this.vPanel.add(this.currentPage);
	this.vPanel.setCellHorizontalAlignment(this.currentPage, HasHorizontalAlignment.ALIGN_CENTER);
}
public void openCustomerInfoEditPage() {
	this.vPanel.clear();
	this.currentPage = new CustomerUpdatePage(this, this.customer);
	this.vPanel.add(this.currentPage);
	this.vPanel.setCellHorizontalAlignment(this.currentPage, HasHorizontalAlignment.ALIGN_CENTER);
}
public void openCustomerInfoCreatePage() {
	this.vPanel.clear();
	this.currentPage = new CustomerCreatePage(this);
	this.vPanel.add(this.currentPage);
	this.vPanel.setCellHorizontalAlignment(this.currentPage, HasHorizontalAlignment.ALIGN_CENTER);
}
public void openCustomerInfoSavedPage() {
	this.vPanel.clear();
	this.currentPage = new CustomerSavedPage(this);
	this.vPanel.add(this.currentPage);
	this.vPanel.setCellHorizontalAlignment(this.currentPage, HasHorizontalAlignment.ALIGN_CENTER);
}
public void openCustomerInfoDeletedPage() {
	this.vPanel.clear();
	this.currentPage = new CustomerDeletedPage(this);
	this.vPanel.add(this.currentPage);
	this.vPanel.setCellHorizontalAlignment(this.currentPage, HasHorizontalAlignment.ALIGN_CENTER);
}
public void openDefaultPage() {
	this.vPanel.clear();
	this.currentPage = new DefaultPage(this);
	this.vPanel.add(this.currentPage);
	this.vPanel.setCellHorizontalAlignment(this.currentPage, HasHorizontalAlignment.ALIGN_CENTER);
}
@Override
public void handleEvent(DataEvent event) {
	if(event instanceof CustomerRetrievedEvent) {
		CustomerRetrievedEvent theEvent = (CustomerRetrievedEvent) event;
		this.customer = theEvent.getTheCustomer();
		
		this.openCustomerInfoPage();
	}
	else if(event instanceof CustomerUpdatedEvent) {
		CustomerUpdatedEvent theEvent = (CustomerUpdatedEvent) event;
		this.customer = theEvent.getTheCustomer();
		
		this.openCustomerInfoSavedPage();
	}
	else if(event instanceof CustomerCreatedEvent) {
		CustomerCreatedEvent theEvent = (CustomerCreatedEvent) event;
		this.customer = theEvent.getTheCustomer();
		this.openCustomerInfoSavedPage();
	}
	else if(event instanceof CustomerDeletedEvent) {
		this.openCustomerInfoDeletedPage();
	}
	else {
		this.currentPage.handleEvent(event);
	}
}

@Override
public void handleError(String error) {
	this.currentPage.handleError(error);
}

public ExampleServiceClientImpl getListener() {
	return this.listener;
}

}
