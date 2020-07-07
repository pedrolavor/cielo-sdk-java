package cielo.sdk.superlink.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
    
    private String productId;
    private Date createdDate;
    private List<Object> order;

}