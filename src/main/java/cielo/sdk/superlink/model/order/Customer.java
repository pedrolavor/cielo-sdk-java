package cielo.sdk.superlink.model.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    
    private String identity;
    
    private String fullName;

    private String email;

    private String phone;
    
}