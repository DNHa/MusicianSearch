package json;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import model.Genres;

public class GenresSerializer implements JsonDeserializer<Genres>{

	@Override
	public Genres deserialize(JsonElement jsonElement, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		Genres genres = new Genres();
		JsonElement responseElement = jsonElement.getAsJsonObject().get("response");		
		JsonElement  genresElement = responseElement.getAsJsonObject().get("genres");
		JsonArray genresArray = genresElement.getAsJsonArray();
		
		for (JsonElement element : genresArray) {
			JsonElement genreElement = element.getAsJsonObject().get("name");
			if(genreElement!=null){
				genres.addGenre(genreElement.getAsString());
			}
		}
		
		System.out.println(genres.getGenreList().size());
		return genres;
	}

}
