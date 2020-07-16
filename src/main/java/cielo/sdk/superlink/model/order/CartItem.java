package cielo.sdk.superlink.model.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {

    private String name;
    
    private Integer unitPrice;

    private int quantity;

    private String type;

    private String sku;

}