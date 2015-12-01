package json;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import model.ImageURLs;

public class ImageURLsSerializer implements JsonDeserializer<ImageURLs>{

	@Override
	public ImageURLs deserialize(JsonElement jsonElement, Type arg1, JsonDeserializationContext arg2)
			throws JsonParseException {
		ImageURLs imageURLs = new ImageURLs();
	
		JsonElement responseElement = jsonElement.getAsJsonObject().get("response");
		JsonElement imagesElement = responseElement.getAsJsonObject().get("images");
		JsonArray images = imagesElement.getAsJsonArray();
		for (JsonElement image : images) {
			JsonElement url =image.getAsJsonObject().get("url");
			imageURLs.addUrl(url.getAsString());
		}
		return imageURLs;
	}

}
