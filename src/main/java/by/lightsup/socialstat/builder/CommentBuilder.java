package by.lightsup.socialstat.builder;

import by.lightsup.socialstat.entity.Comment;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static by.lightsup.socialstat.entity.Comment.newInstance;
import static by.lightsup.socialstat.util.StringUtil.ACCESS_TOKEN_PARAMETER;
import static by.lightsup.socialstat.util.StringUtil.MEDIA_ID_PARAMETER;
import static by.lightsup.socialstat.util.UrlUtil.MEDIA_COMMENTS_REQUEST;
import static java.lang.String.format;

public class CommentBuilder extends AbstractBuilder<Comment> {

    @Override
    public List<Comment> getList(JSONObject jsonObject) {
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        List<Comment> comments = new ArrayList<>();
        for (Object obj : jsonArray) {
            comments.add(newInstance((JSONObject) obj));
        }
        return comments;
    }

    @Override
    public String getRequestUrl(Map<String, String> parameters) {
        return format(MEDIA_COMMENTS_REQUEST, parameters.get(MEDIA_ID_PARAMETER),
                parameters.get(ACCESS_TOKEN_PARAMETER));
    }
}
