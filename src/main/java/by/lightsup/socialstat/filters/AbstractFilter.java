package by.lightsup.socialstat.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class AbstractFilter implements Filter {

    public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) {
        doFilter((HttpServletRequest) request, (HttpServletResponse) response, filterChain);
    }

    @Override
    public void init(FilterConfig config) {
        //do nothing
    }

    @Override
    public void destroy() {
        //do nothing
    }
}
