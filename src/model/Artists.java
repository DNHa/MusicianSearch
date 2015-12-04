package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Artists implements Serializable{
	
	private List<Artist> artistList = new ArrayList<>();

	public List<Artist> getArtistList() {
		return artistList;
	}
	
	public void addArtist(Artist artist){
		artistList.add(artist);
	}

	@Override
	public String toString() {
		return "Artists [artistList=" + artistList + "]";
	}
	
	

}
