package by.lightsup.socialstat.entity;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ShortUser {
	private String id;
	private String username;
	private String profilePicture;
	private String fullName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Create instance of ShortUser from JSONObject
	 * @param object JSONObject
	 * @return Instance of ShortUser parsed from String
	 */
	public static ShortUser newInstance(JSONObject object) {
		ShortUser user = new ShortUser();
		user.setId(object.get("id").toString());
		user.setUsername(object.get("username").toString());
		user.setProfilePicture(object.get("profile_picture").toString());
		return user;
	}
	
	 /**Make ShortUser list from json array
     * @param jsonArray 
     * @return List of ShortUser
     */
	public static List<ShortUser> getList(JSONArray jsonArray) {
		List<ShortUser> users = new ArrayList<>();
		ShortUser shortUser = new ShortUser();
		for (Object obj : jsonArray) {
			JSONObject object = (JSONObject) obj;
			shortUser = ShortUser.newInstance(object);
			users.add(shortUser);
		}
		return users;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((profilePicture == null) ? 0 : profilePicture.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		ShortUser other = (ShortUser) obj;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (profilePicture == null) {
			if (other.profilePicture != null)
				return false;
		} else if (!profilePicture.equals(other.profilePicture))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShortUser [idUser=" + id + ", username=" + username + ", profilePicture=" + profilePicture
				+ ", fullName=" + fullName + "]";
	}

}
