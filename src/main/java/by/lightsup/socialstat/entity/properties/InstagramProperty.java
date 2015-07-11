package by.lightsup.socialstat.entity.properties;

import by.lightsup.socialstat.util.UrlUtil;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;

import static by.lightsup.socialstat.util.UrlUtil.TOKEN_PARAMETERS_TEMPLATE;
import static java.lang.String.format;

public class InstagramProperty {

	private static final Logger LOG = Logger.getLogger(InstagramProperty.class);
	private static final String PROPERTY_FILE_NAME = "instagram";
	private static final ResourceBundle bundle = getBundle();

	private final String clientId;
	private final String redirectURI;
	private final String authorizeURL;
	private final String responseType;
	private final String clientSecret;
	private final String grantType;
	private final String tokenURL;

	public static InstagramProperty newInstance() {
		return new Builder().clientId(bundle.getString("clientId")).redirectURI(bundle.getString("redirectURI"))
				.authorizeURL(bundle.getString("authorizeURL")).responseType(bundle.getString("responseType"))
				.clientSecret(bundle.getString("clientSecret")).grantType(bundle.getString("grantType"))
				.tokenURL(bundle.getString("tokenURL")).build();
	}

	private InstagramProperty(Builder builder) {
		this.clientId = builder.clientId;
		this.redirectURI = builder.redirectURI;
		this.authorizeURL = builder.authorizeURL;
		this.responseType = builder.responseType;
		this.clientSecret = builder.clientSecret;
		this.grantType = builder.grantType;
		this.tokenURL = builder.tokenURL;
	}

	private static ResourceBundle getBundle() {
		ResourceBundle bundle = null;
		try {
			bundle = ResourceBundle.getBundle(PROPERTY_FILE_NAME);
		} catch (Exception e) {
			String message = "Exception occurred while getting ResourceBundle for property with basename: "
					+ PROPERTY_FILE_NAME;
			LOG.error(message, e);
		}
		return bundle;
	}

	public String constructAuthorizeURL() {
		return this.authorizeURL
				+ format(UrlUtil.AUTHORIZE_PARAMETERS_TEMPLATE, this.clientId, this.redirectURI, this.responseType);
	}

	public String constructTokenParameters(String responseCode) {
		String code = this.responseType + "=" + responseCode;
		return format(TOKEN_PARAMETERS_TEMPLATE, this.clientId, this.clientSecret, this.grantType, this.redirectURI,
				code);
	}

	public String getClientId() {
		return clientId;
	}

	public String getRedirectURI() {
		return redirectURI;
	}

	public String getAuthorizeURL() {
		return authorizeURL;
	}

	public String getResponseType() {
		return responseType;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public String getGrantType() {
		return grantType;
	}

	public String getTokenURL() {
		return tokenURL;
	}

	public static class Builder {
		private String clientId;
		private String redirectURI;
		private String authorizeURL;
		private String responseType;
		private String clientSecret;
		private String grantType;
		private String tokenURL;

		public Builder clientId(String clientId) {
			this.clientId = clientId;
			return this;
		}

		public Builder redirectURI(String redirectURI) {
			this.redirectURI = redirectURI;
			return this;
		}

		public Builder authorizeURL(String authorizeURL) {
			this.authorizeURL = authorizeURL;
			return this;
		}

		public Builder responseType(String responseType) {
			this.responseType = responseType;
			return this;
		}

		public Builder clientSecret(String clientSecret) {
			this.clientSecret = clientSecret;
			return this;
		}

		public Builder grantType(String grantType) {
			this.grantType = grantType;
			return this;
		}

		public Builder tokenURL(String tokenURL) {
			this.tokenURL = tokenURL;
			return this;
		}

		public InstagramProperty build() {
			return new InstagramProperty(this);
		}
	}
}
