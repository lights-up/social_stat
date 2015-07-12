package by.lightsup.socialstat.util;

public final class UrlUtil {

    private UrlUtil() {
        throw new AssertionError();
    }

    public static final String AUTHORIZE_PARAMETERS_TEMPLATE = "?%s&%s&response_type=%s";
    public static final String TOKEN_PARAMETERS_TEMPLATE = "%s&%s&%s&%s&%s";
    public static final String SELF_FEED = "https://api.instagram.com/v1/users/self/feed/?access_token=";
    public static final String TAKE_LARGE_USER = "https://api.instagram.com/v1/users/{user-id}/?access_token=";
    public static final String TAKE_USER_FOLLOWS = "https://api.instagram.com/v1/users/{user-id}/follows?access_token=";
    public static final String TAKE_USER_MEDIA = "https://api.instagram.com/v1/users/{user-id}/media/recent/?access_token=";
    public static final String TAKE_MEDIA_LIKES = "https://api.instagram.com/v1/media/{media-id}/likes?access_token=";
}
