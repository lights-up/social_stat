package by.lightsup.socialstat.util;


public final class UrlUtil {

    private UrlUtil() {
        throw new AssertionError();
    }

    public static final String AUTHORIZE_PARAMETERS_TEMPLATE = "?%s&%s&response_type=%s";
    public static final String TOKEN_PARAMETERS_TEMPLATE = "%s&%s&%s&%s&%s";
    public static final String SELF_FEED = "https://api.instagram.com/v1/users/self/feed/?access_token=";
}
