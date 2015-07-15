package by.lightsup.socialstat.builder;

import by.lightsup.socialstat.entity.LargeUser;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

import static by.lightsup.socialstat.entity.LargeUser.newInstance;
import static by.lightsup.socialstat.util.StringUtil.ACCESS_TOKEN_PARAMETER;
import static by.lightsup.socialstat.util.StringUtil.USER_ID_PARAMETER;
import static by.lightsup.socialstat.util.UrlUtil.LARGE_USER_REQUEST;
import static java.lang.String.format;
import static java.util.Collections.singletonList;

public class LargeUserBuilder extends AbstractBuilder<LargeUser> {

    @Override
    public List<LargeUser> getList(JSONObject jsonObject) {
        return singletonList(newInstance(jsonObject));
    }

    @Override
    public String getRequestUrl(Map<String, String> parameters) {
        return format(LARGE_USER_REQUEST, parameters.get(USER_ID_PARAMETER), parameters.get(ACCESS_TOKEN_PARAMETER));
    }
}
