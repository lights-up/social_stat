package by.lightsup.socialstat.annotation;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


public interface InvokedMethod {

    static boolean apply(Method method, HttpServletRequest request) {
        return method.isAnnotationPresent(RequestMapping.class) && method.getAnnotation(RequestMapping.class).path().equals(request.getPathInfo());
    }
}
