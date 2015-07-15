package by.lightsup.socialstat.entity;

import by.lightsup.socialstat.builder.CommentBuilder;
import by.lightsup.socialstat.builder.LikeBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Media {
    private String idMedia;
    private ShortUser user;
    private List<Like> likes;
    private List<Comment> comments;

    private Media() {
        likes = new ArrayList<>();
        comments = new ArrayList<>();
    }


    /**Make instance of Media from JSONObject
     * @param jsonObject JSONObject
     * @return Instance of Media
     */
    public static Media newInstance(JSONObject jsonObject) {
        Media media = new Media();
        media.setIdMedia(jsonObject.get("id").toString());
        media.setUser(ShortUser.newInstance((JSONObject) jsonObject.get("user")));
        media.setLikes(new LikeBuilder().getList((JSONObject) jsonObject.get("likes")));
        media.setComments(new CommentBuilder().getList((JSONObject) jsonObject.get("comments")));
        return media;
    }

    public String getIdMedia() {
        return idMedia;
    }

    public void setIdMedia(String idMedia) {
        this.idMedia = idMedia;
    }

    public ShortUser getUser() {
        return user;
    }

    public void setUser(ShortUser user) {
        this.user = user;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((comments == null) ? 0 : comments.hashCode());
        result = prime * result + ((idMedia == null) ? 0 : idMedia.hashCode());
        result = prime * result + ((likes == null) ? 0 : likes.hashCode());
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
        Media other = (Media) obj;
        if (comments == null) {
            if (other.comments != null)
                return false;
        } else if (!comments.equals(other.comments))
            return false;
        if (idMedia == null) {
            if (other.idMedia != null)
                return false;
        } else if (!idMedia.equals(other.idMedia))
            return false;
        if (likes == null) {
            if (other.likes != null)
                return false;
        } else if (!likes.equals(other.likes))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }
}
