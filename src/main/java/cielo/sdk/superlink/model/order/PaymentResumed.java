package cielo.sdk.superlink.model.order;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResumed {
    
    private Integer price;

    private int numberOfPayments;

    @JsonFormat(timezone = "GMT-3")
    private Date createdDate;
    
    private PaymentStatus status;

}