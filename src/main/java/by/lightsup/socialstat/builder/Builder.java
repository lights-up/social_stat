package by.lightsup.socialstat.builder;

import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

public interface Builder<T> {

    List<T> getList(JSONObject jsonObject);

    String getRequestUrl(Map<String, String> parameters);

}
