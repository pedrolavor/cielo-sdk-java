package cielo.sdk.superlink.model.order;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResumed {
    
    private Integer price;
    private int numberOfPayments;
    private Date createdDate;
    private PaymentStatus status;

}