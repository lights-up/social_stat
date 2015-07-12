package by.lightsup.socialstat.handler;

import static by.lightsup.socialstat.util.UrlUtil.TAKE_LARGE_USER;
import static by.lightsup.socialstat.util.UrlUtil.TAKE_USER_FOLLOWS;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.fluent.Request;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import by.lightsup.socialstat.entity.LargeUser;
import by.lightsup.socialstat.entity.ShortUser;
import by.lightsup.socialstat.exception.ServiceLayerException;

public class StatisticHandler {
	private static final Logger LOG = Logger.getLogger(StatisticHandler.class);

	public static List<ShortUser> getUserStatistic(String idUser, String accessToken) throws ServiceLayerException {
		List<ShortUser> users = null;
		
		StringBuilder largeUserRequest = new StringBuilder(TAKE_LARGE_USER.replace("{id-user}", idUser));
		StringBuilder followsUserRequest = new StringBuilder(TAKE_USER_FOLLOWS.replace("{id-user}", idUser));
		
		largeUserRequest.append(accessToken);
		followsUserRequest.append(accessToken);

		String largeUser = null;
		String followsUser = null;
		
		try {
			largeUser = Request.Get(largeUserRequest.toString()).execute().returnContent().toString();
			followsUser = Request.Get(followsUserRequest.toString()).execute().returnContent().toString();
		
			JSONParser parser = new JSONParser();
			
			JSONObject largeUserObject = (JSONObject) parser.parse(largeUser);
			JSONObject followsUserObject = (JSONObject) parser.parse(followsUser);
			
			LargeUser user = LargeUser.newInstance((JSONObject) largeUserObject.get("data"));
			
			users = UserHandler.getUserFollows(followsUserObject);
			
		} catch (IOException e) {
			LOG.error("Trouble with getting responce from Instagram.com", e);
			throw new ServiceLayerException("Trouble with getting responce from Instagram.com", e);
		} catch (ParseException e) {
			LOG.error("Trouble with parsing json", e);
			throw new ServiceLayerException("Trouble with parsing json", e);
		}
		return users;
	}
}
