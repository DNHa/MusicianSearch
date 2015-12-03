package json;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import model.NewsURLs;

public class NewsSerializer implements JsonDeserializer<NewsURLs> {

@Override
public NewsURLs deserialize (JsonElement jsonElement, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
	NewsURLs news = new NewsURLs();
	
	JsonElement responseElement = jsonElement.getAsJsonObject().get("response");		
	JsonElement newsElement = responseElement.getAsJsonObject().get("news");
	JsonArray newsArray = newsElement.getAsJsonArray();
	
	for (JsonElement newsURLs : newsArray) {
		JsonElement news1 = newsURLs.getAsJsonObject().get("summary");
		if(news1 != null){
			news.setNewsURLs(news1.getAsString());
		}
	
	}
	
	return news;
}


}
