package cielo.sdk.ordermanager;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentFields {
	
	@JsonProperty("primary_product_name")
	@SerializedName("primary_product_name")
	private String primaryProductName;
	
	@JsonProperty("secondary_product_name")
	@SerializedName("secondary_product_name")
	private String secondaryProductName;
	
	@JsonProperty("number_of_quotas")
	@SerializedName("number_of_quotas")
	private int numberOfQuotas;

}
