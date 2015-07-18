package by.lightsup.socialstat.handler;

import by.lightsup.socialstat.builder.AbstractBuilder;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.apache.http.client.fluent.Request.Get;

public class EntityHandler<T> {

    private AbstractBuilder<T> builder;
    private Map<String, String> parameters;

    public EntityHandler(AbstractBuilder<T> builder, Map<String, String> parameters) {
        this.builder = builder;
        this.parameters = parameters;
    }

    public List<T> handle(JSONObject jsonObject) {
        return builder.getList(jsonObject);
    }

    public String getJSONString() throws IOException {
        return Get(builder.getRequestUrl(parameters)).execute().returnContent().toString();
    }
}

