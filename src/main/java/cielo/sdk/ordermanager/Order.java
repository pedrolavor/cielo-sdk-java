package cielo.sdk.ordermanager;

import java.util.ArrayList;
import java.util.List;

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
public class Order {
	
	@EqualsAndHashCode.Include
	private String id;
	
	@JsonProperty("created_at")
	@SerializedName("created_at")
	private String createdAt;
	
	private List<OrderItem> items;
	
	private String notes;
	
	private String number;
	
	private int price;
	
	private String reference;
	
	private int remaining;
	
	private Status status;
	
	private List<Transaction> transactions;
	
	@JsonProperty("updated_at")
	@SerializedName("updated_at")
	private String updatedAt;

	public enum Status {
		DRAFT,
		ENTERED,
		RE_ENTERED,
		PAID,
		CLOSED
	}

	public void addItem(OrderItem item) {
		if (this.items == null) {
			this.items = new ArrayList<OrderItem>();
		}
		this.items.add(item);
	}
	
	public void addTransaction(Transaction transaction) {
		if (this.transactions == null) {
			this.transactions = new ArrayList<Transaction>();
		}
		this.transactions.add(transaction);
	}

}