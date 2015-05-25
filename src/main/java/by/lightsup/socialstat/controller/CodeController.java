package by.lightsup.socialstat.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.lightsup.socialstat.util.UrlUtil.*;
import static java.lang.String.format;


public class CodeController extends HttpServlet {
    static{
        PropertyConfigurator.configure("property/log4j.properties");
    }
    private static final Logger LOG = Logger.getLogger(CodeController.class);
    //TODO:get from property file
    private static final String CLIENT_ID = "db7a523bcf7b411f94f477c83544269d";
    private static final String REDIRECT_URI = "http://localhost:8080/gettoken";

    private static final String AUTHORIZE_URL = CODE_AUTHORIZE_URL + format(AUTHORIZE_PARAMETERS_TEMPLATE, CLIENT_ID, REDIRECT_URI, RESPONSE_TYPE_CODE);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.sendRedirect(response.encodeRedirectURL(AUTHORIZE_URL));
        } catch (IOException e) {
            String message = "Exception occurred while getting authorize code";
            LOG.error(message, e);
        }
    }
}
