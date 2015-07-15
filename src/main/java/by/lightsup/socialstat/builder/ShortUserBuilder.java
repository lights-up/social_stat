package by.lightsup.socialstat.builder;

import by.lightsup.socialstat.entity.ShortUser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static by.lightsup.socialstat.entity.ShortUser.newInstance;
import static by.lightsup.socialstat.util.StringUtil.EMPTY;

public class ShortUserBuilder extends AbstractBuilder<ShortUser> {

    @Override
    public List<ShortUser> getList(JSONObject jsonObject) {
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        List<ShortUser> users = new ArrayList<>();
        for (Object obj : jsonArray) {
            users.add(newInstance((JSONObject) obj));
        }
        return users;
    }

    @Override
    public String getRequestUrl(Map<String, String> parameters) {
        return EMPTY;
    }
}
