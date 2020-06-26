package cielo.lio.sdk.superlink;

import lombok.Getter;

/**
 * API Environment URLs
 * <p/>
 * <li>{@link #PRODUCTION}</li>
 * <li>{@link #SANDBOX}</li>
 */
@Getter
public enum Environment {
	/**
	 * Environment.PRODUCTION
	 */
	PRODUCTION(
		"https://cieloecommerce.cielo.com.br/api/public/v2",
		"https://cieloecommerce.cielo.com.br/api/public/v1"
	),

	/**
	 * Environment.SANDBOX
	 */
	SANDBOX(
		"https://cieloecommerce.cielo.com.br/sandbox/api/public/v2",
		"https://cieloecommerce.cielo.com.br/sandbox/api/public/v1"
	);

	private final String accessTokenUrl;
	private final String resourceUrl;

	Environment(String accessTokenUrl, String resourceUrl) {
		this.accessTokenUrl = accessTokenUrl;
		this.resourceUrl = resourceUrl;
	}
}