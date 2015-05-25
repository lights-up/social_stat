package by.lightsup.socialstat.entity;

import org.json.simple.JSONObject;

/**
 * Created by note on 23.05.2015.
 */
public class User {
    private String id;
    private String userName;
    private String bio;
    private String webSite;
    private String profilePicture;
    private String fullName;
    private int mediaNumber;
    private int followedBy;
    private int follows;

    private User() {
    }

    private User(String bio, int followedBy, int follows, String fullName, String id, int mediaNumber, String profilePicture, String userName, String webSite) {
        this.bio = bio;
        this.followedBy = followedBy;
        this.follows = follows;
        this.fullName = fullName;
        this.id = id;
        this.mediaNumber = mediaNumber;
        this.profilePicture = profilePicture;
        this.userName = userName;
        this.webSite = webSite;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        if(bio == null || "".equals(bio)) {
            this.bio = "none";
        }else{
            this.bio = bio;
        }
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
        }else {
            this.fullName = fullName;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null) {
            this.id = "none";
        }else{
            this.id = id;
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
        }else{
            this.profilePicture = profilePicture;
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (mediaNumber != user.mediaNumber) return false;
        if (followedBy != user.followedBy) return false;
        if (follows != user.follows) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (bio != null ? !bio.equals(user.bio) : user.bio != null) return false;
        if (webSite != null ? !webSite.equals(user.webSite) : user.webSite != null) return false;
        if (profilePicture != null ? !profilePicture.equals(user.profilePicture) : user.profilePicture != null)
            return false;
        return !(fullName != null ? !fullName.equals(user.fullName) : user.fullName != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (bio != null ? bio.hashCode() : 0);
        result = 31 * result + (webSite != null ? webSite.hashCode() : 0);
        result = 31 * result + (profilePicture != null ? profilePicture.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + mediaNumber;
        result = 31 * result + followedBy;
        result = 31 * result + follows;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "bio='" + bio + '\'' +
                ", id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", webSite='" + webSite + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", fullName='" + fullName + '\'' +
                ", mediaNumber=" + mediaNumber +
                ", followedBy=" + followedBy +
                ", follows=" + follows +
                '}';
    }

    public static User newInstance(JSONObject object){
        User user = new User();
        JSONObject userObject = (JSONObject) object.get("user");
        user.setId(userObject.get("id").toString());
        user.setBio(userObject.get("bio").toString());
        user.setUserName(userObject.get("username").toString());
        user.setFullName(userObject.get("full_name").toString());
        user.setProfilePicture(userObject.get("profile_picture").toString());
       // user.setWebSite(userObject.get("website").toString());
        System.out.println(user.toString());
        return user;
    }
}
