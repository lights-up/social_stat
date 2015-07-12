/**
 *
 */
package by.lightsup.socialstat.entity;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Comment {
    private String idComment;
    private String text;
    private ShortUser user;

    public String getIdComment() {
        return idComment;
    }

    public void setIdComment(String idComment) {
        this.idComment = idComment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ShortUser getUser() {
        return user;
    }

    public void setUser(ShortUser user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idComment == null) ? 0 : idComment.hashCode());
        result = prime * result + ((text == null) ? 0 : text.hashCode());
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
        Comment other = (Comment) obj;
        if (idComment == null) {
            if (other.idComment != null)
                return false;
        } else if (!idComment.equals(other.idComment))
            return false;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }

    /**
     * Make Comment from json object
     * @param jsonObject 
     * @return Comment with id and text
     */
    public static Comment newInstance(JSONObject jsonObject) {
        Comment comment = new Comment();
        comment.setIdComment(jsonObject.get("id").toString());
        comment.setText(jsonObject.get("text").toString());
        comment.setUser(ShortUser.newInstance((JSONObject) jsonObject.get("from")));
        return comment;
    }

    /**Make Comment list from json array
     * @param jsonArray 
     * @return List of Comments
     */
    public static List<Comment> getListComments(JSONArray jsonArray) {
        List<Comment> comments = new ArrayList<>();
        Comment comment = null;
        for (Object obj : jsonArray) {
            JSONObject object = (JSONObject) obj;
            comment = Comment.newInstance(object);
            comments.add(comment);
        }
        return comments;
    }
}
