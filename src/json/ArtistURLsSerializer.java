package json;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import model.ArtistURLs;

public class ArtistURLsSerializer implements JsonDeserializer<ArtistURLs> {

	@Override
	public ArtistURLs deserialize(JsonElement jsonElement, Type arg1, JsonDeserializationContext arg2)
			throws JsonParseException {
		ArtistURLs artists = new ArtistURLs();
		JsonElement responseElement = jsonElement.getAsJsonObject().get("response");

		JsonElement urlsElement = responseElement.getAsJsonObject().get("urls");
		JsonElement myspaceElement = urlsElement.getAsJsonObject().get("myspace_url");
		JsonElement lastfmElement = urlsElement.getAsJsonObject().get("lastfm_url");
		JsonElement mbElement = urlsElement.getAsJsonObject().get("mb_url");
		JsonElement wikiElement = urlsElement.getAsJsonObject().get("wikipedia_url");
		JsonElement officialElement = urlsElement.getAsJsonObject().get("official_url");
		JsonElement twitterElement = urlsElement.getAsJsonObject().get("twitter_url");

		try {
			if (myspaceElement != null) {
				artists.setMyspace_url(myspaceElement.getAsString());
			}
			if (lastfmElement != null) {
				artists.setLastfm_url(lastfmElement.getAsString());
			}
			if (mbElement != null) {
				artists.setMb_url(mbElement.getAsString());
			}

			if (wikiElement != null) {
				artists.setWikipedia_url(wikiElement.getAsString());
			}

			if (officialElement != null) {
				artists.setOfficial_url(officialElement.getAsString());
			}

			if (twitterElement != null) {

				artists.setTwitter_url(twitterElement.getAsString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nullllllllll*************");
		}

		return artists;
	}

}
