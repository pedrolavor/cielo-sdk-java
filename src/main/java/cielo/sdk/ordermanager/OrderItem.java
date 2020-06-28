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
public class OrderItem {

	@EqualsAndHashCode.Include
	private String id;
	
	@JsonProperty("created_at")
	@SerializedName("created_at")
	private String createdAt;
	
	private String description;
	
	private String details;
	
	private String name;

	private int quantity;
	
	private String sku;
	
	@JsonProperty("unit_of_measure")
	@SerializedName("unit_of_measure")
	private UnitOfMeasure unitOfMeasure;
	
	@JsonProperty("unit_price")
	@SerializedName("unit_price")
	private int unitPrice;
	
	@JsonProperty("updated_at")
	@SerializedName("updated_at")
	private String updatedAt;
	
	public enum UnitOfMeasure {
		CRATE_OF_12,
		DAYS,
		EACH,
		GALLON,
		HOURS,
		LITRE,
		OTHER,
		SECONDS,
		SIX_PACK
	}

}