package model;

import java.io.Serializable;
import java.util.ArrayList;

public class VideosURLs implements Serializable{
	private String name;
	private int id;
	private String url = new String();
//	private ArrayList< String > urls = new ArrayList< String >();
//
//	public ArrayList<String> getUrls() {
//		return urls;
//	}
//
//	public void setUrls(ArrayList<String> urls) {
//		this.urls = urls;
//	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public VideosURLs(){
	}

	public VideosURLs(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public void addUrl(String url){
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
//
//	@Override
//	public String toString() {
//		String str = new String( "VideoURLs [" );
//
//		for (String string : urls) {
//			str += "url="+string+",";
//		}
//		str += "]";
//		
//		return str;
//	}
}
