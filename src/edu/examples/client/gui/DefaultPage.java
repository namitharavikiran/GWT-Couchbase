package edu.examples.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.examples.client.events.DataEvent;

public class DefaultPage extends MyComposite{
	private TextBox custId ;
	private MainGUI mainview;
	private	VerticalPanel vPanel = new VerticalPanel();
	public DefaultPage(MainGUI mainview)
	{
		initWidget(this.vPanel);
		this.mainview = mainview;
	HorizontalPanel hpanel = new HorizontalPanel();
	Label id = new Label("Enter Customer ID");
	hpanel.add(id);
	custId = new TextBox();
	hpanel.add(custId);
	this.vPanel.add(hpanel);
	
	Button read = new Button("Read Customer Details");
	read.addClickHandler(new ReadClickHandler());
	this.vPanel.add(read);
	
	Button update = new Button("Update Customer Details");
	update.addClickHandler(new UpdateClickHandler());
	this.vPanel.add(update);
	
	Button delete = new Button("Delete Customer Details");
	delete.addClickHandler(new DeleteClickHandler());
	this.vPanel.add(delete);
	
	Button create = new Button("Create Customer Details");
	create.addClickHandler(new CreateClickHandler());
	this.vPanel.add(create);
	}
	
	private class ReadClickHandler implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			String id = custId.getText();
			mainview.getListener().readCustomer(id);
		}
	}

	private class UpdateClickHandler implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			mainview.openCustomerInfoEditPage();
		}
}
	private class DeleteClickHandler implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			String id = custId.getText();
			mainview.getListener().deleteCustomer(id);
		}
	}
	private class CreateClickHandler implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event) {
			mainview.openCustomerInfoCreatePage();
		}
	}
	@Override
	public void handleEvent(DataEvent event) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleError(String error) {
		// TODO Auto-generated method stub
		
	}

	
}
