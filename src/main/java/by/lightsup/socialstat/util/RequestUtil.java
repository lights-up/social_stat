package by.lightsup.socialstat.util;


import by.lightsup.socialstat.entity.properties.InstagramProperty;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.apache.http.client.fluent.Request.Post;

public class RequestUtil {

    private static final Logger LOGGER = Logger.getLogger(RequestUtil.class);

    private static final InstagramProperty instagramProperty = InstagramProperty.newInstance();

    private RequestUtil() {
        throw new AssertionError();
    }

    public static void authorizeCodeRequest(HttpServletResponse response) {
        try {
            response.sendRedirect(response.encodeRedirectURL(instagramProperty.constructAuthorizeURL()));
        } catch (IOException e) {
            String message = "Exception occurred while getting code";
            LOGGER.error(message, e);
        }
    }

    public static String getResultJson(HttpServletRequest request) throws IOException {
        String responseCode = request.getParameter(instagramProperty.getResponseType());
        HttpEntity entity = new StringEntity(instagramProperty.constructTokenParameters(responseCode));
        String result = Post(instagramProperty.getTokenURL()).body(entity).execute().returnContent().toString();
        return result;
    }
}
