package by.lightsup.socialstat.util;

public final class UrlUtil {

    private UrlUtil() {
        throw new AssertionError();
    }

    public static final String AUTHORIZE_PARAMETERS_TEMPLATE = "?%s&%s&response_type=%s";
    public static final String TOKEN_PARAMETERS_TEMPLATE = "%s&%s&%s&%s&%s";
    public static final String SELF_FEED = "https://api.instagram.com/v1/users/self/feed/?access_token=";
    public static final String LARGE_USER_REQUEST = "https://api.instagram.com/v1/users/%s/?access_token=%s";
    public static final String USER_FOLLOWS_REQUEST = "https://api.instagram.com/v1/users/%s/follows?access_token=%s";
    public static final String USER_MEDIA_REQUEST = "https://api.instagram.com/v1/users/%s/media/recent/?access_token=%s";
    public static final String MEDIA_LIKES_REQUEST = "https://api.instagram.com/v1/media/%s/likes?access_token=%s";
    public static final String MEDIA_COMMENTS_REQUEST = "https://api.instagram.com/v1/media/%s/comments?access_token=%s";
    public static final String USER_FOLLOWED_BY_REQUEST = "https://api.instagram.com/v1/users/%s/followed-by?access_token=%s";
}
