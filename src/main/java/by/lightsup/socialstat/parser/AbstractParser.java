package by.lightsup.socialstat.parser;

import org.json.simple.JSONObject;

public abstract class AbstractParser {

    public abstract JSONObject parse(String json);
}
