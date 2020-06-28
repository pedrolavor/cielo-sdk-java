package cielo.sdk.superlink.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Shipping {

    private String name;
    private Integer price;
    private String originZipType;
    private Type type;

    public enum Type {
        CORREIOS,
        FIXED_AMOUNT,
        FREE,
        WITHOUT_SHIPPING_PICK_UP,
        WITHOUT_SHIPPING
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setPrice(BigDecimal price) {
        this.price = Integer.valueOf(
            price.multiply(BigDecimal.valueOf(100)).intValue());
    }

    public void setPrice(Double price) {
        this.price = Integer.valueOf(
            Double.valueOf(price * 100).intValue());
    }

}