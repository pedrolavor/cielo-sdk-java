package cielo.sdk.superlink.model;

import lombok.Getter;

@Getter
public enum Environment implements cielo.sdk.superlink.Environment {

	PRODUCTION(
		"https://cieloecommerce.cielo.com.br/api/public/v2",
		"https://cieloecommerce.cielo.com.br/api/public/v1"
	);
	// there's no sandbox!

	private final String accessTokenUrl;
	private final String resourceUrl;

	Environment(String accessTokenUrl, String resourceUrl) {
		this.accessTokenUrl = accessTokenUrl;
		this.resourceUrl = resourceUrl;
	}
}