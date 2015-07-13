package by.lightsup.socialstat.builder;

import by.lightsup.socialstat.handler.AbstractHandler;
import by.lightsup.socialstat.parser.AbstractParser;
import by.lightsup.socialstat.util.RequestParameters;
import org.json.simple.JSONObject;

import java.util.List;

public class EntityBuilder<T> {

    private AbstractParser parser;
    private AbstractHandler<T> handler;
    private RequestParameters parameters;

    public EntityBuilder(AbstractParser parser, AbstractHandler<T> handler, RequestParameters parameters) {
        this.parser = parser;
        this.handler = handler;
        this.parameters = parameters;
    }

    public List<T> getEntityList() {
        String jsonString = handler.getJSONString(parameters);
        JSONObject object = parser.parse(jsonString);
        return handler.handle(object);
    }
}
