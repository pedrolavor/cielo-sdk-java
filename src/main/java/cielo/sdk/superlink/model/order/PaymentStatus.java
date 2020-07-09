package cielo.sdk.superlink.model.order;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatus {

    PENDING("Pending"),       // Pendente
    PAID("Paid"),             // Pago
    DENIED("Denied"),         // Negado
    EXPIRED("Expired"),       // **
    VOIDED("Voided"),         // Cancelado
    UNFINISHED("Unfinished"), // **
    AUTHORIZED("Authorized"), // Autorizado
    CHARGEBACK("ChargeBack"); // Chargeback

    @JsonValue
    private String value;
    
}