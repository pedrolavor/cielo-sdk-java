package cielo.sdk.superlink.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    @JsonProperty
    private Integer price;

    private String originZipType;
    
    private ShippingType type;

    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonIgnore
    public void setPrice(BigDecimal price) {
        this.price = Integer.valueOf(
            price.multiply(BigDecimal.valueOf(100)).intValue());
    }

    @JsonIgnore
    public void setPrice(Double price) {
        this.price = Integer.valueOf(
            Double.valueOf(price * 100).intValue());
    }

}