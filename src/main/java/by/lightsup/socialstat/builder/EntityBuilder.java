package by.lightsup.socialstat.builder;

import by.lightsup.socialstat.handler.AbstractHandler;
import by.lightsup.socialstat.parser.AbstractParser;
import by.lightsup.socialstat.util.RequestParameters;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class EntityBuilder<T> {

    private static final Logger LOG = Logger.getLogger(EntityBuilder.class);

    private AbstractParser parser;
    private AbstractHandler<T> handler;
    private RequestParameters parameters;

    public EntityBuilder(AbstractParser parser, AbstractHandler<T> handler, RequestParameters parameters) {
        this.parser = parser;
        this.handler = handler;
        this.parameters = parameters;
    }

    public List<T> getEntityList() {
        try {
            String jsonString = handler.getJSONString(parameters);
            JSONObject object = parser.parse(jsonString);
            return handler.handle(object);
        } catch (IOException | ParseException e) {
            String message = "Exception occurred while getting entity list";
            LOG.error(message, e);
            return Collections.emptyList();
        }
    }
}
