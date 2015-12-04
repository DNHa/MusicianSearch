package json;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import model.VideosURLs;

public class VideoURLsSerializer implements JsonDeserializer<VideosURLs>{

	@Override
	public VideosURLs deserialize(JsonElement jsonElement, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		VideosURLs videos = new VideosURLs();

		JsonElement responseElement = jsonElement.getAsJsonObject().get("response");		
		JsonElement  videosElement = responseElement.getAsJsonObject().get("videos");
		JsonArray videosArray = videosElement.getAsJsonArray();
		for (JsonElement video : videosArray) {
			JsonElement url =video.getAsJsonObject().get("url");
			videos.getUrl();
		}
		
		System.out.println(videos.getUrl());
		return videos;
	}

}
