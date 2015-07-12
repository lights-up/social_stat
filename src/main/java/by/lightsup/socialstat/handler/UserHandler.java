package by.lightsup.socialstat.handler;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import by.lightsup.socialstat.entity.ShortUser;

public class UserHandler {

	public static List<ShortUser> getUserFollows(JSONObject obj) {
		JSONArray jsonArray = (JSONArray) obj.get("data");
		return ShortUser.getShortUserList(jsonArray);
	}
	
	
}
