package edu.examples.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.examples.client.events.DataEvent;
import edu.examples.client.gui.MyComposite;
import edu.examples.client.model.Customer;

public class CustomerInfoPage extends MyComposite{
	private MainGUI mainview;
	private VerticalPanel vPanel = new VerticalPanel();
	
	private Label errorLbl;
	
	public CustomerInfoPage(MainGUI mainview, Customer customer) {
		initWidget(this.vPanel);
		this.mainview = mainview;
		
		Label titleLbl = new Label("Personal Info");
		this.vPanel.add(titleLbl);
		this.vPanel.setCellHorizontalAlignment(titleLbl, HasHorizontalAlignment.ALIGN_CENTER);
		
		FlexTable table = new FlexTable();
		this.vPanel.add(table);
		this.vPanel.setCellHorizontalAlignment(table, HasHorizontalAlignment.ALIGN_CENTER);
		
		Label idLbl = new Label("Id:");
		table.setWidget(0, 0, idLbl);
		
		Label nameLbl = new Label("UserName:");
		table.setWidget(1, 0, nameLbl);
		
		Label fnameLbl = new Label("FirstName:");
		table.setWidget(2, 0, fnameLbl);
		
		Label lnameLbl = new Label("LastName:");
		table.setWidget(3, 0, lnameLbl);
		
		Label emailLbl = new Label("Email:");
		table.setWidget(4, 0, emailLbl);
		
		Label id = new Label("      " + customer.getId());
		table.setWidget(0, 1, id);
		
		Label name = new Label(" " + customer.getUserName());
		table.setWidget(1, 1, name);
		
		Label fname = new Label(" " +customer.getFirstName());
		table.setWidget(2, 1, fname);
		
		Label lname = new Label(" " +customer.getLastName());
		table.setWidget(3, 1, lname);
		
		Label email = new Label("    " +customer.getEmail());
		table.setWidget(4, 1, email);
		
		Button editBtn = new Button("Edit");
		this.vPanel.add(editBtn);
		this.vPanel.setCellHorizontalAlignment(editBtn, HasHorizontalAlignment.ALIGN_CENTER);
		editBtn.addClickHandler(new EditClickHandler());
		
		this.errorLbl = new Label("");
		this.vPanel.add(this.errorLbl);
		this.vPanel.setCellHorizontalAlignment(this.errorLbl, HasHorizontalAlignment.ALIGN_CENTER);
	}
	
	private class EditClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			mainview.openCustomerInfoEditPage();
		}
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
