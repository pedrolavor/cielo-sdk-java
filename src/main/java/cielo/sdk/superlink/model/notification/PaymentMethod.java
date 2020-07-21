package cielo.sdk.superlink.model.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentMethod {

    CARTAO_CREDITO(1, "Cartão de Crédito"),
    BOLETO_BANCARIO(2, "Boleto Bancário"),
    DEBITO_ONLINE(3, "Débito Online"),
    CARTAO_DEBITO(4, "Cartão de Débito"),
    QR_CODE(5, "QR Code");

    private int code;
    private String name;
    
}