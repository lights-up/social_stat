package by.lightsup.socialstat.controller;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import by.lightsup.socialstat.entity.ShortUser;
import by.lightsup.socialstat.exception.ServiceLayerException;
import by.lightsup.socialstat.handler.StatisticHandler;

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

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        try {
            String res = getResultJson(request);
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(res);
            JSONObject userObject = (JSONObject) jsonObject.get("user");
            ShortUser user = ShortUser.newInstance(userObject);
            String accessToken = jsonObject.get("access_token").toString();
            try {
				StatisticHandler.getUserStatistic(user.getId(), accessToken);
			} catch (ServiceLayerException e) {
				e.printStackTrace();
			}

//            session.setAttribute("user", user);
//            session.setAttribute("access_token", access_token);

           /* String feed = Request.Get(SELF_FEED + access_token).execute().returnContent().toString();
            JSONObject feedObject = (JSONObject) parser.parse(feed);
            List<Media> mediaList = Media.newMediaListInstance(feedObject);
            session.setAttribute("media", mediaList);*/

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
