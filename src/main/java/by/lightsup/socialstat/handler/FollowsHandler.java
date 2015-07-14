package by.lightsup.socialstat.handler;

import by.lightsup.socialstat.entity.ShortUser;
import by.lightsup.socialstat.util.RequestParameters;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.List;

import static by.lightsup.socialstat.entity.ShortUser.getList;
import static by.lightsup.socialstat.util.UrlUtil.USER_FOLLOWS_REQUEST;
import static java.lang.String.format;
import static org.apache.http.client.fluent.Request.Get;

public class FollowsHandler extends AbstractHandler<ShortUser> {

    public static FollowsHandler newInstance() {
        return new FollowsHandler();
    }

    @Override
    public List<ShortUser> handle(JSONObject jsonObject) {
        return getList((JSONArray) jsonObject.get("data"));
    }

    @Override
    public String getJSONString(RequestParameters parameters) throws IOException {
            String requestString = format(USER_FOLLOWS_REQUEST, parameters.getId(), parameters.getAccessToken());
            return Get(requestString).execute().returnContent().toString();
    }
}
