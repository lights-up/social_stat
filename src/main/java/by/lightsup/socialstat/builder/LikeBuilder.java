package by.lightsup.socialstat.builder;

import by.lightsup.socialstat.entity.Like;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

import static by.lightsup.socialstat.util.StringUtil.ACCESS_TOKEN_PARAMETER;
import static by.lightsup.socialstat.util.StringUtil.MEDIA_ID_PARAMETER;
import static by.lightsup.socialstat.util.UrlUtil.MEDIA_LIKES_REQUEST;
import static java.lang.String.format;

public class LikeBuilder extends AbstractBuilder<Like> {

    @Override
    public List<Like> getList(JSONObject jsonObject) {
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        return Like.getList(jsonArray);
    }

    @Override
    public String getRequestUrl(Map<String, String> parameters) {
        return format(MEDIA_LIKES_REQUEST, parameters.get(MEDIA_ID_PARAMETER), parameters.get(ACCESS_TOKEN_PARAMETER));
    }
}
