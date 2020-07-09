package cielo.sdk.superlink.model.order;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {

    private List<CartItem> items;
    
}