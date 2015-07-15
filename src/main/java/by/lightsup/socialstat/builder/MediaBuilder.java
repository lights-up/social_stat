package by.lightsup.socialstat.builder;

import by.lightsup.socialstat.entity.Media;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

import static by.lightsup.socialstat.util.StringUtil.ACCESS_TOKEN_PARAMETER;
import static by.lightsup.socialstat.util.StringUtil.USER_ID_PARAMETER;
import static by.lightsup.socialstat.util.UrlUtil.USER_MEDIA_REQUEST;
import static java.lang.String.format;

public class MediaBuilder extends AbstractBuilder<Media> {

    @Override
    public List<Media> getList(JSONObject jsonObject) {
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        return Media.getList(jsonArray);
    }

    @Override
    public String getRequestUrl(Map<String, String> parameters) {
        return format(USER_MEDIA_REQUEST, parameters.get(USER_ID_PARAMETER), parameters.get(ACCESS_TOKEN_PARAMETER));
    }
}
