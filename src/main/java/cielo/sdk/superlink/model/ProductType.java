package cielo.sdk.superlink.model;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductType {

    ASSET("Asset"),
    DIGITAL("Digital"),
    SERVICE("Service"),
    PAYMENT("Payment"),
    RECURRENT("Recurrent");

    @JsonValue
    private String value;
    
}