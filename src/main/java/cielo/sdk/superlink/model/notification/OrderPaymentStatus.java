package cielo.sdk.superlink.model.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderPaymentStatus {

    /*
    * PENDENTE
    * Para todos os meios de pagamento.
    * Indica que o pagamento ainda está sendo processado;
    * OBS: se boleto, indica que o boleto não teve o status alterado pelo lojista.
    */
    PENDING(1, "Pending"),

    /*
    * PAGO
    * Para todos os meios de pagamento.
    * Transação capturada e o dinheiro será depositado em conta.
    */
    PAID(2, "Paid"),

    /*
    * NEGADO
    * Somente para Cartão de Crédito.
    * Transação não autorizada pelo responsável do meio de pagamento.
    */
    DENIED(3, "Denied"),

    /*
    * EXPIRADO
    * Cartão de Crédito e Boleto.
    * Transação deixa de ser válida para captura (15 duas após autorização)
    */
    EXPIRED(4, "Expired"),

    /*
    * CANCELADO
    * Somente para Cartão de Crédito.
    * Transação foi cancelada pelo lojista.
    */
    VOIDED(5, "Voided"),

    /*
    * NÃO FINALIZADO
    * Para todos os meios de pagamento.
    * Pagamento esperando Status - Pode indicar erro ou falha de processamento.
    * Entre em contato com o Suporte Cielo.
    */
    UNFINISHED(6, "Unfinished"),

    /*
    * AUTORIZADO
    * Somente para Cartão de Crédito.
    * Transação autorizada pelo emissor do cartão.
    * Deve ser capturada para que o dinheiro seja depositado em conta.
    */
    AUTHORIZED(7, "Authorized"),

    /*
    * CHARGEBACK
    * Somente para Cartão de Crédito.
    * Transação cancelada pelo consumidor junto ao emissor do cartão.
    * O dinheiro não será depositado em conta.
    */
    CHARGEBACK(8, "ChargeBack");

    private int code;
    private String name;

    public static OrderPaymentStatus parse(int code) {
        for(OrderPaymentStatus status : OrderPaymentStatus.values()) {
            if(status.getCode() == code)
                return status;
        }
        return null;
    }
    
}