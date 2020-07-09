package cielo.sdk.superlink.model.order;

import java.util.List;

import cielo.sdk.superlink.model.ShippingType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderShipping {

    private ShippingType type;
    private List<Service> services;

    @Getter
    @Setter
    public static class Service {

        private Integer price;

    }
    
}