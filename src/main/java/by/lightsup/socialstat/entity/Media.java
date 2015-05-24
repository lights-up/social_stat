package by.lightsup.socialstat.entity;

import java.util.List;

/**
 * Created by note on 24.05.2015.
 */
public class Media {
    private String id;
    private MediaType mediaType;
    private User user;
    private List<Comment> comments;
    private List<Like> likes;

    public Media() {
    }

    public Media(List<Comment> comments, String id, List<Like> likes, MediaType mediaType, User user) {
        this.comments = comments;
        this.id = id;
        this.likes = likes;
        this.mediaType = mediaType;
        this.user = user;
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

    public boolean addComment(Comment comment){
        return comments.add(comment);
    }

    public boolean addLikes(Like like) {
        return likes.add(like);
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
}
