package cielo.sdk.superlink.model.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ShippingType {
    
    CORREIOS(1, "Correios"),
    FRETE_FIXO(2, "Frete Fixo"),
    FRETE_GRATIS(3, "Frete Grátis"),
    RETIRAR(4, "Retirar em mãos/loja"),
    SEM_FRETE(5, "Sem cobrança de frete (serviços ou produtos digitais)");

    private int code;
    private String name;

}