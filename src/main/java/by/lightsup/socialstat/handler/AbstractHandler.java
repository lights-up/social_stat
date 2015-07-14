package by.lightsup.socialstat.handler;

import by.lightsup.socialstat.util.RequestParameters;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.List;

public abstract class AbstractHandler<T> {

    public abstract List<T> handle(JSONObject jsonObject);

    public abstract String getJSONString(RequestParameters parameters) throws IOException;
}
