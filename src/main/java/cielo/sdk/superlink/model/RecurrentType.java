package cielo.sdk.superlink.model;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RecurrentType {

    MONTHLY("Monthly"),
    BIMONTHLY("Bimonthly"),
    QUARTERLY("Quaterly"),
    SEMI_ANNUAL("SemiAnnual"),
    ANNUAL("Annual");

    @JsonValue
    private String value;
    
}