package by.lightsup.socialstat.filters;

import org.apache.log4j.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/", "/index.jsp", "/index"})
public class IndexPageFilter extends AbstractFilter {

    private static final Logger LOGGER = Logger.getLogger(IndexPageFilter.class);

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            String message = "Exception occurred while render index.jsp";
            LOGGER.error(message, e);
        }

    }
}
