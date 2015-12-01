package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Genres implements Serializable{
	
	private List<String> genreList = new ArrayList<>();

	public List<String> getGenreList() {
		return genreList;
	}

	public void addGenre(String genre){
		genreList.add(genre);
	}

	@Override
	public String toString() {
		return "Genres [genreList=" + genreList + "]";
	}
	

}
