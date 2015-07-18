package by.lightsup.socialstat.builder;

import by.lightsup.socialstat.entity.ShortUser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static by.lightsup.socialstat.entity.ShortUser.newInstance;

public abstract class ShortUserBuilder implements Builder<ShortUser> {

    @Override
    public List<ShortUser> getList(JSONObject jsonObject) {
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        List<ShortUser> users = new ArrayList<>();
        for (Object obj : jsonArray) {
            users.add(newInstance((JSONObject) obj));
        }
        return users;
    }

    public abstract String getRequestUrl(Map<String, String> parameters);
}
