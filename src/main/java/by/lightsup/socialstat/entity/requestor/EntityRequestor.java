package by.lightsup.socialstat.entity.requestor;

import by.lightsup.socialstat.builder.AbstractBuilder;
import by.lightsup.socialstat.handler.EntityHandler;
import by.lightsup.socialstat.parser.AbstractParser;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * A base class to get lists of entities of different type.
 *
 * @param <T> entity type e.g. {@link by.lightsup.socialstat.entity.ShortUser}
 */
public class EntityRequestor<T> {

    private static final Logger LOG = Logger.getLogger(EntityRequestor.class);

    private AbstractParser parser;
    private AbstractBuilder<T> builder;
    private Map<String, String> parameters;

    /**
     * Creates an instance of {@link EntityRequestor}
     * @param parser for parsing json string
     * @param builder
     * @param parameters used in request string
     */
    public EntityRequestor(AbstractParser parser, AbstractBuilder<T> builder, Map<String, String> parameters) {
        this.parser = parser;
        this.builder = builder;
        this.parameters = parameters;
    }

    /**
     * Creates list of entity by using builder and parameters.
     * @return list of entity of type T
     */
    public List<T> getEntityList() {
        try {
            EntityHandler<T> handler = new EntityHandler<>(builder, parameters);
            String jsonString = handler.getJSONString();
            JSONObject jsonObject = parser.parse(jsonString);
            return handler.handle(jsonObject);
        } catch (IOException | ParseException e) {
            String message = "Exception occurred while getting entity list";
            LOG.error(message, e);
            return Collections.emptyList();
        }
    }
}
