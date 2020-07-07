package cielo.sdk.superlink.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentOrder {

    private String orderNumber;
    private Date createdDate;
    private Object payment;
    private List<Link> links;
    
}