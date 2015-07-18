package by.lightsup.socialstat.builder;

import static by.lightsup.socialstat.entity.Media.newInstance;
import static by.lightsup.socialstat.util.StringUtil.ACCESS_TOKEN_PARAMETER;
import static by.lightsup.socialstat.util.StringUtil.MEDIA_ID_PARAMETER;
import static by.lightsup.socialstat.util.UrlUtil.BY_ID_MEDIA_REQUEST;
import static java.lang.String.format;
import static java.util.Collections.singletonList;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import by.lightsup.socialstat.entity.Media;

public class MediaByIdBuilder implements Builder<Media> {

	public MediaByIdBuilder() {
	}

	@Override
	public List<Media> getList(JSONObject jsonObject) {
		return singletonList(newInstance(jsonObject));
	}

	@Override
	public String getRequestUrl(Map<String, String> parameters) {
		 return format(BY_ID_MEDIA_REQUEST, parameters.get(MEDIA_ID_PARAMETER), parameters.get(ACCESS_TOKEN_PARAMETER));
	}

}
