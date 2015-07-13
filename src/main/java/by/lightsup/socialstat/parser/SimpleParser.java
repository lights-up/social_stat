package by.lightsup.socialstat.parser;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SimpleParser extends AbstractParser {

    private static final Logger LOG = Logger.getLogger(SimpleParser.class);

    @Override public JSONObject parse(String json) {
        JSONObject jsonObject = null;
        try {
            JSONParser parser = new JSONParser();
            jsonObject = (JSONObject) parser.parse(json);
        } catch (ParseException e) {
            String message = "Exception occurred while parsing json";
            LOG.error(message, e);
        }
        return jsonObject;
    }
}
