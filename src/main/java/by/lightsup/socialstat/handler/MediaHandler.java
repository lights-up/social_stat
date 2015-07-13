package by.lightsup.socialstat.handler;

import by.lightsup.socialstat.entity.Media;
import by.lightsup.socialstat.util.RequestParameters;
import org.apache.http.client.fluent.Request;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

import static by.lightsup.socialstat.util.UrlUtil.USER_MEDIA_REQUEST;
import static java.lang.String.format;

public class MediaHandler extends AbstractHandler<Media> {

    public static MediaHandler newInstance() {
        return new MediaHandler();
    }

    @Override public List<Media> handle(JSONObject jsonObject) {
        return Media.getMediaList((JSONArray) jsonObject.get("data"));
    }

    @Override public String getJSONString(RequestParameters parameters) {
        try {
            String requestString = format(USER_MEDIA_REQUEST, parameters.getId(), parameters.getAccessToken());
            return Request.Get(requestString).execute().returnContent().toString();
        }catch (Exception e) {

        }
        return "";
    }
}
