package by.lightsup.socialstat.controller;

import by.lightsup.socialstat.annotation.RequestMapping;
import by.lightsup.socialstat.builder.FollowedByBuilder;
import by.lightsup.socialstat.builder.FollowsBuilder;
import by.lightsup.socialstat.entity.ShortUser;
import by.lightsup.socialstat.entity.requestor.EntityRequestor;
import by.lightsup.socialstat.parser.SimpleParser;
import com.google.common.collect.ImmutableMap;
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
import java.util.Map;

import static by.lightsup.socialstat.util.RequestUtil.getResultJson;
import static by.lightsup.socialstat.util.StringUtil.ACCESS_TOKEN_PARAMETER;
import static by.lightsup.socialstat.util.StringUtil.USER_ID_PARAMETER;

/**
 * Class-controller to match requests. Methods should be static to invoke by reflection.
 */
public class InstagramController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(InstagramController.class);

    @RequestMapping(path = "/follow")
    public static void getFollowersPage(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            String userId = (String) session.getAttribute(USER_ID_PARAMETER);
            String accessToken = (String) session.getAttribute(ACCESS_TOKEN_PARAMETER);
            Map<String, String> parameters = ImmutableMap.of(USER_ID_PARAMETER, userId, ACCESS_TOKEN_PARAMETER, accessToken);
            List<ShortUser> follow = new EntityRequestor<>(new SimpleParser(), new FollowsBuilder(), parameters).getEntityList();
            request.setAttribute("follow", follow);
            request.getRequestDispatcher("/followers.tiles").forward(request, response);
        } catch (IOException | ServletException e) {
            String message = "Exception occurred while getting followers";
            LOG.error(message, e);
        }
    }

    @RequestMapping(path = "/followed-by")
    public static void getFollowedByPage(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            String userId = (String) session.getAttribute(USER_ID_PARAMETER);
            String accessToken = (String) session.getAttribute(ACCESS_TOKEN_PARAMETER);
            Map<String, String> parameters = ImmutableMap.of(USER_ID_PARAMETER, userId, ACCESS_TOKEN_PARAMETER, accessToken);
            List<ShortUser> followedBy = new EntityRequestor<>(new SimpleParser(), new FollowedByBuilder(), parameters).getEntityList();
            request.setAttribute("follow", followedBy);
            request.getRequestDispatcher("/followers.tiles").forward(request, response);
        } catch (IOException | ServletException e) {
            String message = "Exception occurred while getting followers by users";
            LOG.error(message, e);
        }
    }

    @RequestMapping(path = "/gettoken")
    public static void getProfilePage(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        try {
            JSONObject jsonObject = getJSONObject(request);
            JSONObject userObject = (JSONObject) jsonObject.get("user");
            ShortUser user = ShortUser.newInstance(userObject);
            String accessToken = jsonObject.get("access_token").toString();
            session.setAttribute("user", user);
            session.setAttribute(USER_ID_PARAMETER, user.getId());
            session.setAttribute(ACCESS_TOKEN_PARAMETER, accessToken);

            response.sendRedirect("/profile.tiles");
        } catch (IOException e) {
            String message = "Exception occurred while getting token";
            LOG.error(message, e);
        }
    }

    private static JSONObject getJSONObject(HttpServletRequest request) throws IOException {
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
