package cielo.sdk.superlink.model.order;

import java.util.List;

import cielo.sdk.superlink.model.Link;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkOrder {

    private String merchantId;

    private String orderNumber;

    private String softDescriptor;

    private Cart cart;

    private OrderShipping shipping;

    private Payment payment;

    private Customer customer;
    
    private List<Link> links;
    
}