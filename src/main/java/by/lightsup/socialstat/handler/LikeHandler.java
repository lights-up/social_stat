package by.lightsup.socialstat.handler;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import by.lightsup.socialstat.entity.Like;

public class LikeHandler {
	public static List<Like> getMediaLikeList(JSONObject obj){
		JSONArray jsonArray = (JSONArray) obj.get("data");
		return Like.getLikesList(jsonArray);
	}

}
