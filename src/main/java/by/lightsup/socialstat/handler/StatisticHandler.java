package by.lightsup.socialstat.handler;

import static by.lightsup.socialstat.util.UrlUtil.TAKE_LARGE_USER;
import static by.lightsup.socialstat.util.UrlUtil.TAKE_USER_FOLLOWS;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.fluent.Request;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import by.lightsup.socialstat.entity.LargeUser;
import by.lightsup.socialstat.entity.Like;
import by.lightsup.socialstat.entity.Media;
import by.lightsup.socialstat.entity.ShortUser;
import by.lightsup.socialstat.exception.ServiceLayerException;


public class StatisticHandler {
	private static final Logger LOG = Logger.getLogger(StatisticHandler.class);


	public static List<ShortUser> getUserFollows(String idUser, String accessToken) throws ServiceLayerException {
		List<ShortUser> users = null;
		//TODO(vlad): change {id-user} to format String
		StringBuilder followsUserRequest = new StringBuilder(TAKE_USER_FOLLOWS.replace("{id-user}", idUser));
		followsUserRequest.append(accessToken);
		String followsUser = null;

		try {
			followsUser = Request.Get(followsUserRequest.toString()).execute().returnContent().toString();
			JSONParser parser = new JSONParser();
			JSONObject followsUserObject = (JSONObject) parser.parse(followsUser);
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

	public static LargeUser getLargeUser(String idUser, String accessToken) throws ServiceLayerException {
		StringBuilder largeUserRequest = new StringBuilder(TAKE_LARGE_USER.replace("{id-user}", idUser));
		largeUserRequest.append(accessToken);
		String largeUser = null;
		try {
			largeUser = Request.Get(largeUserRequest.toString()).execute().returnContent().toString();
		} catch (IOException e) {
			LOG.error("Trouble with getting responce from Instagram.com", e);
			throw new ServiceLayerException("Trouble with getting responce from Instagram.com", e);
		}
		JSONParser parser = new JSONParser();
		JSONObject largeUserObject;
		try {
			largeUserObject = (JSONObject) parser.parse(largeUser);
		} catch (ParseException e) {
			LOG.error("Trouble with parsing json", e);
			throw new ServiceLayerException("Trouble with parsing json", e);
		}
		return LargeUser.newInstance((JSONObject) largeUserObject.get("data"));
	}

	public static List<Media> getUserMedia(LargeUser user, String accessToken) throws ServiceLayerException {
		List<Media> mediaList = null;
		StringBuilder userMediaRequest = new StringBuilder(TAKE_USER_FOLLOWS.replace("{id-user}", user.getId()));
		userMediaRequest.append(accessToken);
		userMediaRequest.append("&count=" + user.getMediaNumber());
		String userMedia = null;

		try {
			userMedia = Request.Get(userMediaRequest.toString()).execute().returnContent().toString();
			JSONParser parser = new JSONParser();
			JSONObject userMediaObject = (JSONObject) parser.parse(userMedia);
			mediaList = Media.getMediaList((JSONArray) userMediaObject.get("data"));
		} catch (IOException e) {
			LOG.error("Trouble with getting responce from Instagram.com", e);
			throw new ServiceLayerException("Trouble with getting responce from Instagram.com", e);
		} catch (ParseException e) {
			LOG.error("Trouble with parsing json", e);
			throw new ServiceLayerException("Trouble with parsing json", e);
		}
		return mediaList;
	}

	public static List<Like> getMediaLikes(Media media, String accessToken) throws ServiceLayerException {
		List<Like> likeList = null;
		StringBuilder userMediaRequest = new StringBuilder(TAKE_USER_FOLLOWS.replace("{id-media}", media.getIdMedia()));
		userMediaRequest.append(accessToken);
		String mediaLike = null;

		try {
			mediaLike = Request.Get(userMediaRequest.toString()).execute().returnContent().toString();
			JSONParser parser = new JSONParser();
			JSONObject userMediaObject = (JSONObject) parser.parse(mediaLike);
			likeList = Like.getLikesList((JSONArray) userMediaObject.get("data"));
		} catch (IOException e) {
			LOG.error("Trouble with getting responce from Instagram.com", e);
			throw new ServiceLayerException("Trouble with getting responce from Instagram.com", e);
		} catch (ParseException e) {
			LOG.error("Trouble with parsing json", e);
			throw new ServiceLayerException("Trouble with parsing json", e);
		}
		return likeList;
	}
	
	public static List<ShortUser> getUserStatistic(String idUser, String accessToken) throws ServiceLayerException{
		LargeUser largeUser = getLargeUser(idUser, accessToken);
		List<ShortUser> shortUsers = getUserFollows(largeUser.getId(), accessToken);
		for (ShortUser shortUser : shortUsers) {
			List<Media> mediaList = getUserMedia(largeUser, accessToken);
			for (Media media : mediaList) {
				List<Like> likes = getMediaLikes(media, accessToken);
				for (Like like : likes) {
					LOG.info(like);
					System.out.println(like);
				}
			}
		}
		//TODO(vlad): finish it!
		return shortUsers;
	}

}
