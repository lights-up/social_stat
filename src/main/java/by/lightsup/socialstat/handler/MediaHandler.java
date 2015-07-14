package by.lightsup.socialstat.handler;

import by.lightsup.socialstat.entity.Media;
import by.lightsup.socialstat.util.RequestParameters;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.List;

import static by.lightsup.socialstat.entity.Media.getMediaList;
import static by.lightsup.socialstat.util.UrlUtil.USER_MEDIA_REQUEST;
import static java.lang.String.format;
import static org.apache.http.client.fluent.Request.Get;

public class MediaHandler extends AbstractHandler<Media> {

    public static MediaHandler newInstance() {
        return new MediaHandler();
    }

    @Override
    public List<Media> handle(JSONObject jsonObject) {
        return getMediaList((JSONArray) jsonObject.get("data"));
    }

    @Override
    public String getJSONString(RequestParameters parameters) throws IOException {
        String requestString = format(USER_MEDIA_REQUEST, parameters.getId(), parameters.getAccessToken());
        return Get(requestString).execute().returnContent().toString();
    }
}
