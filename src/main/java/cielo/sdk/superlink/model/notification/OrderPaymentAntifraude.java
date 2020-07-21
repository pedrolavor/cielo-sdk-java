package cielo.sdk.superlink.model.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderPaymentAntifraude {

    // Baixo risco de ser uma transação fraudulenta
    BAIXO_RISCO(1, "Baixo Risco"),

    // Médio risco de ser uma transação fraudulenta
    MEDIO_RISCO(2, "Médio Risco"),

    // Alto risco de ser uma transação fraudulenta
    ALTO_RISCO(3, "Alto Risco"),

    // Não foi possível finalizar a consulta
    NAO_FINALIZADO(4, "Não Finalizado");

    private int code;
    private String name;
    
}