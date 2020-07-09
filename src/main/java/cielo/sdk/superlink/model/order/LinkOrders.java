package cielo.sdk.superlink.model.order;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkOrders {

    private String productId;
    private Date createdDate;
    private List<LinkOrderResumed> orders;
    
}