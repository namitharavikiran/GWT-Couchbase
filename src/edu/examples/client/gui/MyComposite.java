package edu.examples.client.gui;

import com.google.gwt.user.client.ui.Composite;

import edu.examples.client.events.DataEvent;

public abstract class MyComposite extends Composite {
	public abstract void handleEvent(DataEvent event);
	public abstract void handleError(String error);
}
