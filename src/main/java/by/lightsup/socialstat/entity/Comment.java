package by.lightsup.socialstat.entity;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Comment {
    private String id;
    private User user;
    private String text;

    public Comment() {
    }

    public Comment(String id, String text, User user) {
        this.id = id;
        this.text = text;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != null ? !id.equals(comment.id) : comment.id != null) return false;
        if (user != null ? !user.equals(comment.user) : comment.user != null) return false;
        return !(text != null ? !text.equals(comment.text) : comment.text != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", text='" + text + '\'' +
                '}';
    }

    public static List<Comment> newCommentListInstance(JSONObject commentsObject) {
        List<Comment> comments = new ArrayList<Comment>();
        JSONArray array = (JSONArray) commentsObject.get("data");
        for (Object obj : array) {
            JSONObject commentObject = (JSONObject) obj;
            Comment comment = new Comment();
            comment.setId(commentObject.get("id").toString());
            comment.setText(commentObject.get("text").toString());
            JSONObject userObject = (JSONObject) commentObject.get("from");
            User user = User.newInstance(userObject);
            comment.setUser(user);
            comments.add(comment);
        }

        return comments;
    }

}
