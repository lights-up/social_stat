package by.lightsup.socialstat.controller;

import by.lightsup.socialstat.annotation.RequestMapping;
import by.lightsup.socialstat.builder.EntityBuilder;
import by.lightsup.socialstat.entity.ShortUser;
import by.lightsup.socialstat.handler.AbstractHandler;
import by.lightsup.socialstat.handler.FollowsHandler;
import by.lightsup.socialstat.parser.SimpleParser;
import by.lightsup.socialstat.util.RequestParameters;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static by.lightsup.socialstat.util.RequestUtil.getResultJson;

public class InstagramController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(InstagramController.class);

    /**
     * Used by AnnotationParser for reflection.
     *
     * @return {@link InstagramController}
     */
    public static InstagramController newInstance() {
        return new InstagramController();
    }

    @RequestMapping(path = "/followers")
    public void getFollowersPage(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            ShortUser user = (ShortUser) session.getAttribute("user");
            String accessToken = (String) session.getAttribute("access_token");
            AbstractHandler<ShortUser> handler = FollowsHandler.newInstance();
            List<ShortUser> followers = new EntityBuilder<>(new SimpleParser(), handler,
                    RequestParameters.newInstance(user.getId(), accessToken)).getEntityList();
            session.setAttribute("followers", followers);
            response.sendRedirect("/followers.tiles");
        } catch (IOException e) {
            String message = "Exception occurred while getting followers";
            LOG.error(message, e);
        }
    }

    @RequestMapping(path = "/gettoken")
    public void getProfilePage(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        try {
            JSONObject jsonObject = getJSONObject(request);
            JSONObject userObject = (JSONObject) jsonObject.get("user");
            ShortUser user = ShortUser.newInstance(userObject);
            String accessToken = jsonObject.get("access_token").toString();
            //request.setAttribute("user", user)
            session.setAttribute("user", user);
            session.setAttribute("access_token", accessToken);

            response.sendRedirect("/profile.tiles");
            //request.getRequestDispatcher("/profile.tiles").forward(request, response);
        } catch (IOException e) {
            String message = "Exception occurred while getting token";
            LOG.error(message, e);
        }
    }

    private JSONObject getJSONObject(HttpServletRequest request) throws IOException {
        JSONObject jsonObject = null;
        try {
            String res = getResultJson(request);
            JSONParser parser = new JSONParser();
            jsonObject = (JSONObject) parser.parse(res);
        } catch (ParseException e) {
            String message = "Exception occurred while parsing json";
            LOG.error(message, e);
        }
        return jsonObject;
    }
}
