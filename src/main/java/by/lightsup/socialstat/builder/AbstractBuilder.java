package by.lightsup.socialstat.builder;

import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

public abstract class AbstractBuilder<T> {

    public abstract List<T> getList(JSONObject jsonObject);

    public abstract String getRequestUrl(Map<String, String> parameters);

}
