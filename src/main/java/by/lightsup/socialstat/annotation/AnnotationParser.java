package by.lightsup.socialstat.annotation;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AnnotationParser<T> {
    private static final Logger LOG = Logger.getLogger(AnnotationParser.class);

    private static final String NEW_INSTANCE_METHOD_NAME = "newInstance";

    /**
     * Method using rclasseflection to invoke method from controller e.g. InstagramController according to the request path.
     *
     * @param clazz controller class e.g. InstagramController
     * @param request request
     * @param response response
     */
    public void invokeMethod(Class<T> clazz, HttpServletRequest request, HttpServletResponse response) {
        try {
            Method[] methods = clazz.getMethods();
            T instance = null;
            for (Method method : methods) {
                if (NEW_INSTANCE_METHOD_NAME.equals(method.getName())) {
                    instance = getInstance(method);
                }
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping mapping = method.getAnnotation(RequestMapping.class);
                    String path = mapping.path();
                    if (path.equals(request.getPathInfo())) {
                        method.invoke(instance, request, response);
                    }
                }
            }
        } catch (Exception e) {
            String message = "Exception occurred while parsing annotation";
            LOG.error(message, e);
        }
    }


    private T getInstance(Method method) throws Exception {
        return (T) method.invoke(null);
    }
}
