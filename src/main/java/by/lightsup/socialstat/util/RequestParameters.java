package by.lightsup.socialstat.util;

public class RequestParameters {

    private String id;
    private String accessToken;
    private String count;

    private RequestParameters(String id, String accessToken, String count) {
        this.id = id;
        this.accessToken = accessToken;
        this.count = count;
    }

    private RequestParameters(String id, String accessToken) {
        this.id = id;
        this.accessToken = accessToken;
    }

    public static RequestParameters newInstance(String id, String accessToken, String count) {
        return new RequestParameters(id, accessToken, count);
    }

    public static RequestParameters newInstance(String id, String accessToken) {
        return new RequestParameters(id, accessToken);
    }

    public String getId() {
        return id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getCount() {
        return count;
    }
}
