package edu.examples.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.examples.client.events.DataEvent;

public class CustomerDeletedPage extends MyComposite {
	private MainGUI mainview;
	private VerticalPanel vPanel = new VerticalPanel();

	public CustomerDeletedPage(MainGUI mainview)
	{
			initWidget(this.vPanel);
			this.mainview = mainview;
			
			Label titleLbl = new Label("Customer Info Deleted");
			this.vPanel.add(titleLbl);
			this.vPanel.setCellHorizontalAlignment(titleLbl, HasHorizontalAlignment.ALIGN_CENTER);
			
			Button backBtn = new Button("Back");
			this.vPanel.add(backBtn);
			this.vPanel.setCellHorizontalAlignment(backBtn, HasHorizontalAlignment.ALIGN_CENTER);
			backBtn.addClickHandler(new BackClickHandler());
		}
		
	private class BackClickHandler implements ClickHandler {
			@Override
			public void onClick(ClickEvent event) {
				mainview.openDefaultPage();
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
