package by.lightsup.socialstat.servlet;

import by.lightsup.socialstat.annotation.AnnotationParser;
import by.lightsup.socialstat.controller.InstagramController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/watch/*")
public class DispatcherServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        AnnotationParser<InstagramController> parser = new AnnotationParser<>();
        parser.invokeMethod(InstagramController.class, request, response);
    }
}
