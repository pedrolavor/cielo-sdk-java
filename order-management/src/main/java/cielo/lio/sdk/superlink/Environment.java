package cielo.lio.sdk.superlink;

/**
 * API Environment URLs
 * <p/>
 * <li>{@link #PRODUCTION}</li>
 * <li>{@link #SANDBOX}</li>
 */
public enum Environment implements cielo.lio.sdk.Environment {
	/**
	 * Environment.PRODUCTION
	 */
	PRODUCTION("https://cieloecommerce.cielo.com.br/api/public/v1"),

	/**
	 * Environment.SANDBOX
	 */
	SANDBOX("https://cieloecommerce.cielo.com.br/sandbox/api/public/v1");

	private final String url;

	Environment(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}
}