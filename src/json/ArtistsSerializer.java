package json;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import model.Artist;
import model.Artists;

public class ArtistsSerializer implements JsonDeserializer<Artists>{

	@Override
	public Artists deserialize(JsonElement jsonElement, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		Artists artists = new Artists();
		JsonElement responseElement = jsonElement.getAsJsonObject().get("response");		
		JsonElement  artistsElement = responseElement.getAsJsonObject().get("artists");
		JsonArray artistsArray = artistsElement.getAsJsonArray();
		
		for (JsonElement element : artistsArray) {
			JsonElement artistId = element.getAsJsonObject().get("id");
			JsonElement artistName = element.getAsJsonObject().get("name");
			if(artistName!=null){
				artists.addArtist(new Artist(artistId.getAsString(), 
						artistName.getAsString()));
			}
		}
		
		System.out.println(artists.getArtistList().size());
		return artists;
	}

}
