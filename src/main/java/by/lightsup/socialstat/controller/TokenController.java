package by.lightsup.socialstat.controller;

import by.lightsup.socialstat.entity.ShortUser;
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

import static by.lightsup.socialstat.util.RequestUtil.getResultJson;

@WebServlet(urlPatterns = "/gettoken")
public class TokenController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(TokenController.class);

    @Override public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
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
