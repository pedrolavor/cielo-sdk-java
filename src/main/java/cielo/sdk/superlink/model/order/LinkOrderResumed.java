package cielo.sdk.superlink.model.order;

import java.util.Date;
import java.util.List;

import cielo.sdk.superlink.model.Link;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkOrderResumed {

    private String orderNumber;
    private Date createdDate;
    private PaymentResumed payment;
    private List<Link> links;
    
}