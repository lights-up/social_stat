package by.lightsup.socialstat.parser;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Optional;

public class SimpleParser extends AbstractParser {

    private static final Logger LOG = Logger.getLogger(SimpleParser.class);

    @Override
    public JSONObject parse(String json) throws ParseException {
            JSONParser parser = new JSONParser();
            return (JSONObject) parser.parse(json);
    }
}
