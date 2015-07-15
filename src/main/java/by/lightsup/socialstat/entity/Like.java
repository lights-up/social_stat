package by.lightsup.socialstat.entity;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Like {
	private String idLike;
	private ShortUser user;

	/**
	 * Make Like from json object
	 * @param jsonObject
	 * @return Like from json object
	 */
	public static Like newInstance(JSONObject jsonObject) {
		Like like = new Like();
		like.setUser(ShortUser.newInstance(jsonObject));
		like.setId(jsonObject.get("id").toString());
		return like;
	}
	/**Make Like list from json array
	 * @param jsonArray
	 * @return List of Like
	 */
	public static List<Like> getList(JSONArray jsonArray) {
		List<Like> likes = new ArrayList<>();
		for (Object obj : jsonArray) {
			likes.add(newInstance((JSONObject) obj));
		}
		return likes;
	}

	public ShortUser getUser() {
		return user;
	}

	public void setUser(ShortUser fromUser) {
		this.user = fromUser;
	}

	public String getId() {
		return idLike;
	}

	public void setId(String idString) {
		this.idLike = idString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLike == null) ? 0 : idLike.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Like other = (Like) obj;
		if (idLike == null) {
			if (other.idLike != null)
				return false;
		} else if (!idLike.equals(other.idLike))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
