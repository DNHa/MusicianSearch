package beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import model.Artist;
import model.ArtistURLs;
import model.Artists;
import model.Biographies;
import model.ImageURLs;
import model.NewsURLs;
import service.JSONServiceHandler;

@ManagedBean
@SessionScoped
public class MusicServiceBean {
	private JSONServiceHandler sh;
	private String currentGenre;
	private List<String> genreList;
	private String currentStyle = "Rock";
	private List<String> styles = Arrays.asList("Rock", "Jazz", "Pop", "Rap", "Reggae", "Alternativ","Indie","Hip Hop","Soul","Classic");
	private List<Artist> artistList = new ArrayList<>();
	private Artist selectedArtist;
	private ArtistURLs currentURLs = new ArtistURLs();
	private ImageURLs imageURLs;
	private Biographies biographiesTxt;
	private NewsURLs newsURLs;

	// Stelle zum initialisieren
	@PostConstruct
	public void init() {
		sh = JSONServiceHandler.getInstance();
		genreList = sh.createGenres(currentStyle).getGenreList();
	}

	public void createGenreAutocompleteList() {
		genreList = sh.createGenres(currentStyle).getGenreList();
	}

	public String getCurrentGenre() {
		return currentGenre;
	}

	public void setCurrentGenre(String currentGenre) {
		this.currentGenre = currentGenre;
	}

	public List<String> loadGenresList(String query) {
		List<String> completeList = new ArrayList<>();
		for (String genre : genreList) {
			if (genre.toLowerCase().startsWith(query.toLowerCase())) {
				completeList.add(genre);
			}
		}

		return completeList;
	}

	public String getCurrentStyle() {
		return currentStyle;
	}

	public void setCurrentStyle(String currentStyle) {
		this.currentStyle = currentStyle;
	}

	public List<String> getStyles() {
		return styles;
	}

	public void loadArtistList() {
		Artists artists = sh.createArtists(currentGenre, 30);
		artistList = artists.getArtistList();
	}

	public List<Artist> getArtistList() {
		return artistList;
	}

	public Artist getSelectedArtist() {
		return selectedArtist;
	}

	public void setSelectedArtist(Artist selectedArtist) {
		this.selectedArtist = selectedArtist;
	}

	public void onRowSelect(SelectEvent event) {
		Artist artist = (Artist) event.getObject();
		System.out.println("artist: " + artist);
		setCurrentURLs(sh.createArtistURLs(artist.getId()));
		setImageURLs(sh.createImageURLs(artist.getId()));
		setBiographiesTxt(sh.createBiographiesTxt(artist.getId()));
		setNewsURLs(sh.createNewsURLs(artist.getId()));
	}

	public ArtistURLs getCurrentURLs() {
		return currentURLs;
	}

	public void setCurrentURLs(ArtistURLs currentURLs) {
		this.currentURLs = currentURLs;
	}

	public ImageURLs getImageURLs() {
		return imageURLs;
	}

	public void setImageURLs(ImageURLs imageURLs) {
		this.imageURLs = imageURLs;
	}

	public Biographies getBiographiesTxt() {
		return biographiesTxt;
	}

	public void setBiographiesTxt(Biographies biographiesTxt) {
		this.biographiesTxt = biographiesTxt;
	}

	public NewsURLs getNewsURLs() {
		return newsURLs;
	}

	public void setNewsURLs(NewsURLs newsURLs) {
		this.newsURLs = newsURLs;
	}



}
