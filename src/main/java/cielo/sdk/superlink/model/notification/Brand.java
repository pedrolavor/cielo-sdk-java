package cielo.sdk.superlink.model.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Brand {

    VISA(1, "Visa"),
    MASTERCARD(2, "Mastercard"),
    AMERICAN_EXPRESS(3, "American Express"),
    DINERS(4, "Diners"),
    ELO(5, "Elo"),
    AURA(6, "Aura"),
    JCB(7, "JCB"),
    DISCOVER(8, "Discover"),
    HIPERCARD(9, "Hipercard");

    private int code;
    private String name;
    
}