package by.lightsup.socialstat.controller;


import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.StringEntity;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.lightsup.socialstat.util.UrlUtil.*;
import static java.lang.String.format;

public class TokenController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(TokenController.class);
    //TODO:get form properties file
    private static final String CLIENT_ID = "db7a523bcf7b411f94f477c83544269d";
    private static final String REDIRECT_URI = "http://localhost:8080/gettoken";
    private static final String CLIENT_SECRET = "a180976dad27439fad63cab5317a8251";
    private static final String GRANT = "authorization_code";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter(RESPONSE_TYPE_CODE);
        String parameters = format(TOKEN_PARAMETERS_TEMPLATE, CLIENT_ID, CLIENT_SECRET, GRANT, REDIRECT_URI, code);
        try {
            HttpEntity entity = new StringEntity(parameters);
            String res = Request.Post(TOKEN_URL).body(entity).execute().returnContent().toString();
            System.out.println(res);
        } catch (IOException e) {
            String message = "Exception occurred while getting token";
            LOG.error(message, e);
        }

    }

}
