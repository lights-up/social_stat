package by.lightsup.socialstat.entity;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by note on 24.05.2015.
 */
public class Media {
    private String id;
    private MediaType mediaType;
    private MediaContent mediaContent;
    private User user;
    private List<Comment> comments;
    private List<Like> likes;

    private Media() {
    }

    public MediaContent getMediaContent() {
        return mediaContent;
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.mediaContent = mediaContent;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean addComment(Comment comment) {
        return comments.add(comment);
    }

    public boolean addLikes(Like like) {
        return likes.add(like);
    }

    public int getNumberLikes() {
        return likes.size();
    }

    public int getNumberComments() {
        return comments.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Media media = (Media) o;

        if (id != null ? !id.equals(media.id) : media.id != null) return false;
        if (mediaType != media.mediaType) return false;
        if (user != null ? !user.equals(media.user) : media.user != null) return false;
        if (comments != null ? !comments.equals(media.comments) : media.comments != null) return false;
        return !(likes != null ? !likes.equals(media.likes) : media.likes != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (mediaType != null ? mediaType.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (likes != null ? likes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Media{" +
                "comments=" + comments +
                ", id='" + id + '\'' +
                ", mediaType=" + mediaType +
                ", user=" + user +
                ", likes=" + likes +
                '}';
    }

    public static List<Media> newMediaListInstance(JSONObject feedObject) {
        List<Media> mediaList = new ArrayList<Media>();
        JSONArray array = (JSONArray) feedObject.get("data");
        for (Object data : array) {
            JSONObject mediaObject = (JSONObject) data;
            Media media = new Media();
            media.setMediaType(MediaType.valueOf(mediaObject.get("type").toString().toUpperCase()));
            JSONObject commnetObject = (JSONObject) mediaObject.get("comments");
            JSONObject likeObject = (JSONObject) mediaObject.get("likes");

            media.setComments(Comment.newCommentListInstance(commnetObject));
            media.setLikes(Like.newLikeListInstance(likeObject));

            //TODO: Dev MediaContentType
            JSONObject imageObject = (JSONObject) mediaObject.get("images");
            MediaContent mediaContent = MediaContent.newInstance(imageObject);
            media.setMediaContent(mediaContent);
            JSONObject userObject = (JSONObject) mediaObject.get("user");
            media.setId(mediaObject.get("id").toString());
            media.setUser(User.newInstance(userObject));
            mediaList.add(media);
        }

        return mediaList;
    }
}
