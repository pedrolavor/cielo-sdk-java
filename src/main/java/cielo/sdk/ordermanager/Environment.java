package cielo.sdk.ordermanager;

import lombok.Getter;

@Getter
public enum Environment {
	
	PRODUCTION("https://api.cielo.com.br/order-management/v1"),
	SANDBOX("https://api.cielo.com.br/sandbox-lio/order-management/v1");

	private final String url;

	Environment(String url) {
		this.url = url;
	}
}