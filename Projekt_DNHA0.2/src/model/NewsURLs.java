package model;

import java.util.ArrayList;

public class NewsURLs {

	private ArrayList<String> urls = new ArrayList<String>();

	public ArrayList<String> getUrls() {
		return urls;
	}

	public void setUrls(ArrayList<String> urls) {
		this.urls = urls;
	}
	public String toString(){
		return "[News " + urls + "]";
	}
}

