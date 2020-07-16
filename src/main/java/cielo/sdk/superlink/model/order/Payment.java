package cielo.sdk.superlink.model.order;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {

    private String status;

    private PaymentAntifraud antifraud;

    private String tid;

    private int numberOfPayments;

    @JsonFormat(timezone = "GMT-3")
    private Date createdDate;

    @JsonFormat(timezone = "GMT-3")
    private Date finishedDate;
    
    private String cardMaskedNumber;
    
}