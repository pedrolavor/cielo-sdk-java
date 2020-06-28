package cielo.sdk.ordermanager;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Transaction {
	
	@EqualsAndHashCode.Include
	private String id;
	
	private int amount;
	
	@JsonProperty("authorization_code")
	@SerializedName("authorization_code")
	private String authorizationCode;
	
	private Card card;
	
	@JsonProperty("created_at")
	@SerializedName("created_at")
	private String createdAt;
	
	private String description;
	
	private int number;

	@JsonProperty("payment_product")
	@SerializedName("payment_product")
	private PaymentProduct paymentProduct;
	
	private Status status;
	
	@JsonProperty("terminal_number")
	@SerializedName("terminal_number")
	private int terminalNumber;
	
	@JsonProperty("transaction_type")
	@SerializedName("transaction_type")
	private TransactionType transactionType;
	
	@JsonProperty("updated_at")
	@SerializedName("updated_at")
	private String updatedAt;
	
	public enum Status {
		CANCELLED,
		CONFIRMED,
		PENDING
	}
	
	public enum TransactionType {
		CANCELLATION,
		PAYMENT
	}

}