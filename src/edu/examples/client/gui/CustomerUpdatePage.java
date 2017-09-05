package edu.examples.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.examples.client.gui.MyComposite;
import edu.examples.client.events.DataEvent;
import edu.examples.client.model.Customer;

public class CustomerUpdatePage extends MyComposite{
	private MainGUI mainview;
	private VerticalPanel vPanel = new VerticalPanel();
	
	private TextBox id;
	private TextBox name;
	private TextBox fname;
	private TextBox lname;
	private TextBox email;
	
	private Label errorLbl;
	
	public CustomerUpdatePage(MainGUI mainview, Customer customer) {
		initWidget(this.vPanel);
		this.mainview = mainview;
		
		Label titleLbl = new Label(" Edit Customer Info");
		this.vPanel.add(titleLbl);
		this.vPanel.setCellHorizontalAlignment(titleLbl, HasHorizontalAlignment.ALIGN_CENTER);
		
		FlexTable table = new FlexTable();
		this.vPanel.add(table);
		this.vPanel.setCellHorizontalAlignment(table, HasHorizontalAlignment.ALIGN_CENTER);
		
		Label idLbl = new Label("Id");
		table.setWidget(0, 0, idLbl);
		
		Label nameLbl = new Label("UserName");
		table.setWidget(1, 0, nameLbl);
		
		Label fnameLbl = new Label("FirstName");
		table.setWidget(2, 0, fnameLbl);
		
		Label lnameLbl = new Label("LastName");
		table.setWidget(3, 0, lnameLbl);
		
		Label emailLbl = new Label("Email");
		table.setWidget(4, 0, emailLbl);
		
		this.id = new TextBox();
		this.id.setText(customer.getId());
		table.setWidget(0, 1, this.id);
		
		this.name = new TextBox();
		this.name.setText(customer.getUserName());
		table.setWidget(1, 1, this.name);
		
		this.fname = new TextBox();
		this.fname.setText(customer.getFirstName());
		table.setWidget(2, 1, this.fname);
		
		this.lname = new TextBox();
		this.lname.setText(customer.getLastName());
		table.setWidget(3, 1, this.lname);
		
		this.email = new TextBox();
		this.email.setText(customer.getEmail());
		table.setWidget(4, 1, this.email);
		
		
		Button saveBtn = new Button("Save");
		this.vPanel.add(saveBtn);
		this.vPanel.setCellHorizontalAlignment(saveBtn, HasHorizontalAlignment.ALIGN_CENTER);
		saveBtn.addClickHandler(new SaveClickHandler());
		
		this.errorLbl = new Label("");
		this.vPanel.add(this.errorLbl);
		this.vPanel.setCellHorizontalAlignment(this.errorLbl, HasHorizontalAlignment.ALIGN_CENTER);
	}
	
	private class SaveClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			saveData();
		}
	}
	
	private void saveData() {
		
		Customer cust = new Customer();
		
		cust.setId(this.id.getText());
		cust.setUserName(this.name.getText());
		cust.setFirstName(this.fname.getText());
		cust.setLastName(this.lname.getText());
		cust.setEmail(this.email.getText());
	
		mainview.setCustomer(cust);				
		mainview.getListener().updateCustomer(cust);
	}

	@Override
	public void handleEvent(DataEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleError(String error) {
		this.errorLbl.setText(error);
	}
}
