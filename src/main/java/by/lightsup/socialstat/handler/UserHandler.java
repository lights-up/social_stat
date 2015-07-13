package by.lightsup.socialstat.handler;

import by.lightsup.socialstat.entity.LargeUser;
import by.lightsup.socialstat.util.RequestParameters;
import org.apache.http.client.fluent.Request;
import org.json.simple.JSONObject;

import java.util.List;

import static by.lightsup.socialstat.util.UrlUtil.LARGE_USER_REQUEST;
import static java.lang.String.format;
import static java.util.Collections.singletonList;

public class UserHandler extends AbstractHandler<LargeUser> {

    public static UserHandler newInstance() {
        return new UserHandler();
    }

    @Override public List<LargeUser> handle(JSONObject object) {
        return singletonList(LargeUser.newInstance((JSONObject) object.get("data")));
    }

    @Override public String getJSONString(RequestParameters parameters) {
        try {
            String requestString = format(LARGE_USER_REQUEST, parameters.getId(), parameters.getAccessToken());
            return Request.Get(requestString).execute().returnContent().toString();
        }catch (Exception e) {

        }
        return "";
    }
}
