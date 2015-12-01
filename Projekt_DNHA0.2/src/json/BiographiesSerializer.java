package json;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class BiographiesSerializer implements JsonDeserializer<Biographies>{

	@Override
	public Biographies deserialize(JsonElement jsonElement, Type arg1, JsonDeserializationContext arg2)
			throws JsonParseException {
			Biographies biographies = new Biographies();
			
			JsonElement responseElement = jsonElement.getAsJsonObject().get("response");		
			JsonElement biographiesElement = responseElement.getAsJsonObject().get("biographies");
			JsonArray biographiesArray = biographiesElement.getAsJsonArray();
			
			for (JsonElement biography : biographiesArray) {
				JsonElement bio = biography.getAsJsonObject().get("text");
				if(bio != null){
					biographies.addBioTxt(bio.getAsString());
				}
			
			}
			
			return biographies;
	}

}
