package by.lightsup.socialstat.parser;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public abstract class AbstractParser {

    public abstract JSONObject parse(String json) throws ParseException;
}
