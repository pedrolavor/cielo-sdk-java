package cielo.sdk.superlink.model.order;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {

    private String status;
    private PaymentAntifraud antifraud;
    private String tid;
    private int numberOfPayments;
    private Date createdDate;
    private Date finishedDate;
    private String cardMaskedNumber;
    
}