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
public class PaymentProduct {
	
	private String name;
	
	private int number;
	
	private PaymentProduct sub;
}
