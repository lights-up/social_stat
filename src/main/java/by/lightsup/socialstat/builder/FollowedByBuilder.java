package by.lightsup.socialstat.builder;

import java.util.Map;

import static by.lightsup.socialstat.util.StringUtil.ACCESS_TOKEN_PARAMETER;
import static by.lightsup.socialstat.util.StringUtil.USER_ID_PARAMETER;
import static by.lightsup.socialstat.util.UrlUtil.USER_FOLLOWED_BY_REQUEST;
import static java.lang.String.format;

public class FollowedByBuilder extends ShortUserBuilder {

    @Override
    public String getRequestUrl(Map<String, String> parameters) {
        return format(USER_FOLLOWED_BY_REQUEST, parameters.get(USER_ID_PARAMETER), parameters.get(ACCESS_TOKEN_PARAMETER));
    }
}
