package by.lightsup.socialstat.handler;

import by.lightsup.socialstat.entity.Like;
import by.lightsup.socialstat.util.RequestParameters;
import org.apache.http.client.fluent.Request;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

import static by.lightsup.socialstat.util.UrlUtil.MEDIA_LIKES_REQUEST;
import static java.lang.String.format;

public class LikeHandler extends AbstractHandler<Like> {

    public static LikeHandler newInstance() {
        return new LikeHandler();
    }

    @Override public List<Like> handle(JSONObject jsonObject) {
        return Like.getLikesList((JSONArray) jsonObject.get("data"));
    }

    @Override public String getJSONString(RequestParameters parameters) {
        try {
            String requestString = format(MEDIA_LIKES_REQUEST, parameters.getId(), parameters.getAccessToken());
            return Request.Get(requestString).execute().returnContent().toString();
        } catch (Exception e) {

        }
        return "";
    }
}
