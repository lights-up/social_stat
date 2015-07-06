package by.lightsup.socialstat.controller;


import by.lightsup.socialstat.entity.Media;
import by.lightsup.socialstat.entity.User;
import org.apache.http.client.fluent.Request;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static by.lightsup.socialstat.util.RequestUtil.getResultJson;
import static by.lightsup.socialstat.util.UrlUtil.SELF_FEED;


@WebServlet(urlPatterns = "/gettoken")
public class TokenController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(TokenController.class);


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        try {
            String res = getResultJson(request, response);
            System.out.println(res);
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(res);
            JSONObject userObject = (JSONObject) jsonObject.get("user");

            String access_token = jsonObject.get("access_token").toString();
            User user = User.newInstance(userObject);

            session.setAttribute("user", user);
            session.setAttribute("access_token", access_token);

            String feed = Request.Get(SELF_FEED + access_token).execute().returnContent().toString();
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
