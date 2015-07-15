package by.lightsup.socialstat.builder;

import by.lightsup.socialstat.entity.ShortUser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

import static by.lightsup.socialstat.util.StringUtil.ACCESS_TOKEN_PARAMETER;
import static by.lightsup.socialstat.util.StringUtil.USER_ID_PARAMETER;
import static by.lightsup.socialstat.util.UrlUtil.USER_FOLLOWS_REQUEST;
import static java.lang.String.format;

public class FollowsBuilder extends AbstractBuilder<ShortUser> {

    @Override
    public List<ShortUser> getList(JSONObject jsonObject) {
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        return ShortUser.getList(jsonArray);
    }

    @Override
    public String getRequestUrl(Map<String, String> parameters) {
        return format(USER_FOLLOWS_REQUEST, parameters.get(USER_ID_PARAMETER), parameters.get(ACCESS_TOKEN_PARAMETER));
    }
}
