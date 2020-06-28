package cielo.sdk.ordermanager;

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
public class Card {
	
	private String bin;
	
	private Brand brand;
	
	private String last;
	
	public enum Brand {
		AMEX,
		AURA,
		DINERS,
		DISCOVER,
		ELO,
		JCB,
		MASTERCARD,
		VISA
	}
}