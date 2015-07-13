package by.lightsup.socialstat.handler;

import by.lightsup.socialstat.entity.ShortUser;
import by.lightsup.socialstat.util.RequestParameters;
import by.lightsup.socialstat.util.UrlUtil;
import org.apache.http.client.fluent.Request;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

import static by.lightsup.socialstat.util.UrlUtil.USER_FOLLOWS_REQUEST;
import static java.lang.String.format;

public class FollowsHandler extends AbstractHandler<ShortUser> {

    public static FollowsHandler newInstance() {
        return new FollowsHandler();
    }

    @Override public List<ShortUser> handle(JSONObject jsonObject) {
        return ShortUser.getShortUserList((JSONArray) jsonObject.get("data"));
    }

    @Override public String getJSONString(RequestParameters parameters) {
        try {
            String requestString = format(USER_FOLLOWS_REQUEST, parameters.getId(), parameters.getAccessToken());
            return Request.Get(requestString).execute().returnContent().toString();
        }catch (Exception e) {

        }
        return "";
    }
}
