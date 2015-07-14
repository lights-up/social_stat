package by.lightsup.socialstat.parser;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public abstract class AbstractParser {

	/**
	 * Make from String JSONObject
	 * @param json String in json format
	 * @return JSONObject parced from String
	 * @throws ParseException if trouble while parcing
	 */
    public abstract JSONObject parse(String json) throws ParseException;
}
