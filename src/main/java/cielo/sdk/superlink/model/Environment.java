package cielo.sdk.superlink.model;

import lombok.Getter;

@Getter
public enum Environment implements cielo.sdk.superlink.Environment {

	PRODUCTION(
		"https://cieloecommerce.cielo.com.br/api/public/v2",
		"https://cieloecommerce.cielo.com.br/api/public/v1"
	),
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