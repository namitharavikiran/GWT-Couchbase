package edu.examples.client.model;

import java.io.Serializable;

public class ImagesList implements Serializable {
	
	private String[] images;

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

}
