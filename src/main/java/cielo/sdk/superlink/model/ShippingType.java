package cielo.sdk.superlink.model;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShippingType {
    
    CORREIOS("Correios"),
    FIXED_AMOUNT("FixedAmount"),
    FREE("Free"),
    WITHOUT_SHIPPING_PICK_UP("WithoutShippingPickUp"),
    WITHOUT_SHIPPING("WithoutShipping");

    @JsonValue
    private String value;

}