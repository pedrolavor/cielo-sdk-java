package cielo.lio.sdk.order;

/**
 * API Environment URLs
 * <p/>
 * <li>{@link #PRODUCTION}</li>
 * <li>{@link #SANDBOX}</li>
 */
public enum Environment {
	/**
	 * Environment.PRODUCTION
	 */
	PRODUCTION("https://api.cielo.com.br/order-management/v1"),

	/**
	 * Environment.SANDBOX
	 */
	SANDBOX("https://api.cielo.com.br/sandbox-lio/order-management/v1");

	private final String url;

	Environment(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}
}