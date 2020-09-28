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
	
	@JsonProperty("external_id")
	@SerializedName("external_id")
	private String externalId;
	
	@JsonProperty("created_at")
	@SerializedName("created_at")
	private String createdAt;
	
	@JsonProperty("updated_at")
	@SerializedName("updated_at")
	private String updatedAt;

	private String description;
	
	private Status status;
	
	@JsonProperty("terminal_number")
	@SerializedName("terminal_number")
	private int terminalNumber;
	
	@JsonProperty("authorization_code")
	@SerializedName("authorization_code")
	private String authorizationCode;
	
	private String number;
	
	private int amount;
	
	@JsonProperty("transaction_type")
	@SerializedName("transaction_type")
	private TransactionType transactionType;

	@JsonProperty("payment_fields")
	@SerializedName("payment_fields")
	private PaymentFields paymentFileds;
	
	private Card card;
	
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