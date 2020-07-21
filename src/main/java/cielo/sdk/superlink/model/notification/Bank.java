package cielo.sdk.superlink.model.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Bank {

    BANCO_BRASIL(1, "Banco do Brasil"),
    BRADESCO(2, "Bradesco");

    private int code;
    private String name;
    
}