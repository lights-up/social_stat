package by.lightsup.socialstat.filters;

import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.lightsup.socialstat.util.RequestUtil.authorizeCodeRequest;

@WebFilter(urlPatterns = "/getcode")
public class CodeFilter extends AbstractFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        authorizeCodeRequest(request, response);
    }
}
