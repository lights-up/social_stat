package by.lightsup.socialstat.util;


public final class UrlUtil {
    private UrlUtil() {
        throw new AssertionError();
    }

    public static final String RESPONSE_TYPE_CODE = "code";
    public static final String CODE_AUTHORIZE_URL = "https://api.instagram.com/oauth/authorize/";
    public static final String TOKEN_URL = "https://api.instagram.com/oauth/access_token";
    public static final String AUTHORIZE_PARAMETERS_TEMPLATE = "?client_id=%s&redirect_uri=%s&response_type=%s";
    public static final String TOKEN_PARAMETERS_TEMPLATE = "client_id=%s&client_secret=%s&grant_type=%s&redirect_uri=%s&code=%s";
    public static final String SELF_FEED="https://api.instagram.com/v1/users/self/feed/?access_token=";
}
