package service;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

import json.ArtistURLsSerializer;
import json.ArtistsSerializer;
import json.BiographiesSerializer;
import json.GenresSerializer;
import json.ImageURLsSerializer;
import json.NewsSerializer;
import model.ArtistURLs;
import model.Artists;
import model.Biographies;
import model.Genres;
import model.ImageURLs;
import model.NewsURLs;
import model.VideosURLs;

public final class JSONServiceHandler {
	public static final String API_KEY = "GJXTDB6QSTDCUQ6U3";
	private static JSONServiceHandler instance = null;

	private JSONServiceHandler() {
		System.setProperty("java.net.useSystemProxies", "true");
	}

	public synchronized static JSONServiceHandler getInstance() {

		if (instance == null) {
			instance = new JSONServiceHandler();
		}

		return instance;
	}

	/**
	 * Rest Client
	 * @return
	 */
	private String getGenresJSON(String style) {
		WebResource wr = Client.create().resource("http://developer.echonest.com/api/v4/genre/search");
		
		Builder b = wr.queryParam("api_key", API_KEY).
				queryParam("format", "json").
				queryParam("name", style).
				queryParam("results", "100").
				accept(MediaType.APPLICATION_JSON);
		
		return b.get(String.class);		
	}
	
	
	private String getArtistsJSON(String genre, String results) {
		WebResource wr = Client.create().resource("http://developer.echonest.com/api/v4/artist/search");
		
		Builder b = wr.queryParam("api_key", API_KEY).
				queryParam("format", "json").
				queryParam("genre", genre).
				queryParam("results", results).
				accept(MediaType.APPLICATION_JSON);
		
		return b.get(String.class);	
	
	}
	
	private String getArtistsURLsJSON(String artistId) {
		WebResource wr = Client.create().resource("http://developer.echonest.com/api/v4/artist/urls");
		
		Builder b = wr.queryParam("api_key", API_KEY).
				queryParam("format", "json").
				queryParam("id", artistId).
	
				accept(MediaType.APPLICATION_JSON);
		
		return b.get(String.class);	
	
	}
	
	private String getImageURLsJSON(String artistId){
		WebResource wr = Client.create().resource("http://developer.echonest.com/api/v4/artist/images");
	
		Builder b = wr.queryParam("api_key", API_KEY).
				queryParam("format", "json").
				queryParam("id", artistId).
				accept(MediaType.APPLICATION_JSON);
	
				
			return b.get(String.class);
		
	}
	

	private String getBiographiesJSON(String artistId){
		WebResource wr = Client.create().resource("http://developer.echonest.com/api/v4/artist/biographies");
	
		Builder b = wr.queryParam("api_key", API_KEY).
				queryParam("format", "json").
				queryParam("id", artistId).
				accept(MediaType.APPLICATION_JSON);
				
			return b.get(String.class);
	
	}
	
	private String getNewsURLsJSON(String artistId){
		WebResource wr = Client.create().resource("http://developer.echonest.com/api/v4/artist/news");
		
		Builder b = wr.queryParam("api_key", API_KEY).
				queryParam("format", "json").
				queryParam("id", artistId).
				accept(MediaType.APPLICATION_JSON);
				
			return b.get(String.class);
	
	}
	
	public String getVideoURLsJSON(String artistId){

		WebResource wr = Client.create().resource("http://developer.echonest.com/api/v4/artist/video");
	
		Builder b = wr.queryParam("api_key", API_KEY).
				queryParam("format", "json").
				queryParam("id", artistId).
				accept(MediaType.APPLICATION_JSON);
			return b.get(String.class);
	}

	/*
	 * json -> Object (gson.jar)
	 */
	public Genres createGenres(String style) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Genres.class, new GenresSerializer());
		Gson gson = gsonBuilder.create();
		Genres genres = gson.fromJson(getGenresJSON(style), Genres.class);
		return genres;
	}

	public Artists createArtists(String genre, int max) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Artists.class, new ArtistsSerializer());
		Gson gson = gsonBuilder.create();
		Artists artists = gson.fromJson(getArtistsJSON(genre,max+""), Artists.class);
		return artists;
	}
	
	public ArtistURLs createArtistURLs(String id) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(ArtistURLs.class, new ArtistURLsSerializer());
		Gson gson = gsonBuilder.create();
		ArtistURLs artistURLs = gson.fromJson(getArtistsURLsJSON(id), ArtistURLs.class);
//		System.out.println(artistURLs);
		return artistURLs;
	}
	public ImageURLs createImageURLs(String id) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(ImageURLs.class, new ImageURLsSerializer());
		Gson gson = gsonBuilder.create();
		ImageURLs imageURLs = gson.fromJson(getImageURLsJSON(id), ImageURLs.class);
//		System.out.println(imageURLs);
		return imageURLs;
	}

	public Biographies createBiographiesTxt(String id){
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Biographies.class, new BiographiesSerializer());
		Gson gson = gsonBuilder.create();
		Biographies bioTxt = gson.fromJson(getBiographiesJSON(id), Biographies.class);
//		System.out.println(bioTxt);
		return bioTxt;
	
	}
	
	public VideosURLs createVideosURLs(String id){
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(VideosURLs.class, new NewsSerializer());
		Gson  gson = gsonBuilder.create();
		VideosURLs videoURLs = gson.fromJson(getVideoURLsJSON(id), VideosURLs.class);
		System.out.println(videoURLs);
		
		return videoURLs;
		
	}
	
	public NewsURLs createNewsURLs(String id){
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(NewsURLs.class, new NewsSerializer());
		Gson  gson = gsonBuilder.create();
		NewsURLs newsURLs = gson.fromJson(getNewsURLsJSON(id), NewsURLs.class);
		System.out.println(newsURLs);
		
		return newsURLs;
		
	}
	
	public static void main(String[] args) {
		JSONServiceHandler service = new JSONServiceHandler();
		//System.out.println("-->"+service.getArtistsJSON("rock",100+""));
//		System.out.println(service.getArtistsURLsJSON("ARH6W4X1187B99274F"));
//		System.out.println(service.createArtistURLs("ARH6W4X1187B99274F"));
//		System.out.println(service.createBiographiesTxt("ARH6W4X1187B99274F"));
		System.out.println(service.createVideosURLs(API_KEY));
		System.out.println(service.createNewsURLs("ARH6W4X1187B99274F"));
	}

}
