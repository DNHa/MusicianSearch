package model;

import java.util.ArrayList;

public class ImageURLs {
	private ArrayList< String > urls = new ArrayList< String >();

	public ArrayList<String> getUrls() {
		return urls;
	}

	public void setUrls(ArrayList<String> urls) {
		this.urls = urls;
	}

	public void addUrl(String url){
		urls.add(url);
	}
	
	@Override
	public String toString() {
		String str = new String( "ImageURLs [" );

		for (String string : urls) {
			str += "url="+string+",";
		}
		str += "]";
		
		return str;
	}
}
