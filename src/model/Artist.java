package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Artist implements Serializable{
	private String id;
	private String name;
	
	public Artist() {
	}
	public Artist(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + "]";
	}
	
	

}
