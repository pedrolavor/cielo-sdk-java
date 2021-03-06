package cielo.sdk.ordermanager.request;

/**
 * An exception that can be catch by the app
 */
public class CieloRequestException extends Exception {
	private static final long serialVersionUID = 1L;
	private final CieloError error;

	public CieloRequestException(String message, CieloError error, Throwable cause) {
		super(message, cause);

		this.error = error;
	}

	/**
	 * The error related with this exception
	 *
	 * @return The {@link CieloError} with the error codes and message.
	 */
	public CieloError getError() {
		return error;
	}
}