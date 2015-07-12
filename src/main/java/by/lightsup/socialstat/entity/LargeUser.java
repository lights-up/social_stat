package by.lightsup.socialstat.entity;

import org.json.simple.JSONObject;

/**
 * Created by note on 23.05.2015.
 */
public class LargeUser {
	private String idUser;
	private String username;
	private String profilePicture;
	private String fullName;
	private int mediaNumber;
	private int followedBy;
	private int follows;

	private LargeUser() {
	}

	public int getFollowedBy() {
		return followedBy;
	}

	public void setFollowedBy(int followedBy) {
		this.followedBy = followedBy;
	}

	public int getFollows() {
		return follows;
	}

	public void setFollows(int follows) {
		this.follows = follows;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		if (fullName == null) {
			this.fullName = "none";
		} else {
			this.fullName = fullName;
		}
	}

	public String getId() {
		return idUser;
	}

	public void setId(String id) {
		if (id == null) {
			this.idUser = "none";
		} else {
			this.idUser = id;
		}
	}

	public int getMediaNumber() {
		return mediaNumber;
	}

	public void setMediaNumber(int mediaNumber) {
		this.mediaNumber = mediaNumber;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		if (profilePicture == null) {
			this.profilePicture = "none";
		} else {
			this.profilePicture = profilePicture;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + followedBy;
		result = prime * result + follows;
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + mediaNumber;
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
		LargeUser other = (LargeUser) obj;
		if (followedBy != other.followedBy)
			return false;
		if (follows != other.follows)
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (mediaNumber != other.mediaNumber)
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

	/*
	 * "id": "1574083", 
	 * "username": "snoopdogg",
	 * "full_name": "Snoop Dogg",
	 * "profile_picture":"http://distillery.s3.amazonaws.com/profiles/profile_1574083_75sq_1295469061.jpg",
	 * "bio": "This is my bio",
	 *  "website": "http://snoopdogg.com", 
	 *  "counts": {
	 * 			"media": 1320, 
	 * 			"follows": 420, 
	 * 			"followed_by": 3410 
	 * 			}
	 */
	public static LargeUser newInstance(JSONObject object) {
		LargeUser user = new LargeUser();
		user.setId(object.get("id").toString());
		user.setUsername(object.get("username").toString());
		user.setProfilePicture(object.get("profile_picture").toString());
		JSONObject jsonObject = (JSONObject) object.get("counts");
		user.setFollows(Integer.valueOf(jsonObject.get("follows").toString()));
		user.setFollowedBy(Integer.valueOf(jsonObject.get("followed_by").toString()));
		user.setMediaNumber(Integer.valueOf(jsonObject.get("media").toString()));
		return user;
	}
}