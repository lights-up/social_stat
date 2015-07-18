package by.lightsup.socialstat.annotation;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.stream.Stream;

import static by.lightsup.socialstat.annotation.InvokedMethod.apply;

public class AnnotationParser<T> {
    private static final Logger LOG = Logger.getLogger(AnnotationParser.class);

    /**
     * Method using reflection to invoke method from controller e.g. InstagramController according to the request path.
     *
     * @param clazz    controller class e.g. InstagramController
     * @param request  request
     * @param response response
     */
    public void invokeMethod(Class<T> clazz, HttpServletRequest request, HttpServletResponse response) {
        try {
            Method[] methods = clazz.getMethods();
            Optional<Method> method = Stream.of(methods).filter(m -> apply(m, request)).findAny();
            method.get().invoke(null, request, response);
        } catch (Exception e) {
            String message = "Exception occurred while parsing annotation";
            LOG.error(message, e);
        }
    }
}
