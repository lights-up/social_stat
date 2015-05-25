package by.lightsup.socialstat.controller;


import by.lightsup.socialstat.entity.Media;
import by.lightsup.socialstat.entity.User;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.StringEntity;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String code = request.getParameter(RESPONSE_TYPE_CODE);
        String parameters = format(TOKEN_PARAMETERS_TEMPLATE, CLIENT_ID, CLIENT_SECRET, GRANT, REDIRECT_URI, code);
        HttpSession session = request.getSession();
        try {
            HttpEntity entity = new StringEntity(parameters);
            String res = Request.Post(TOKEN_URL).body(entity).execute().returnContent().toString();
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(res);
            JSONObject userObject = (JSONObject) jsonObject.get("user");

            String access_token = jsonObject.get("access_token").toString();
            User user = User.newInstance(userObject);

            session.setAttribute("user", user);
            session.setAttribute("access_token", access_token);

            String feed = Request.Get(SELF_FEED+access_token).execute().returnContent().toString();
            JSONObject feedObject = (JSONObject) parser.parse(feed);
            List<Media> mediaList = Media.newMediaListInstance(feedObject);
            session.setAttribute("media", mediaList);

            request.getRequestDispatcher("/jsp/profile.jsp").forward(request, response);

        } catch (IOException e) {
            String message = "Exception occurred while getting token";
            LOG.error(message, e);
        } catch (ParseException e) {
            String message = "Exception occurred while parsing JSON";
            LOG.error(message, e);

        }
    }
}
