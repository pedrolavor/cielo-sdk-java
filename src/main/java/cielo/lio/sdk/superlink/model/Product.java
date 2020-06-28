package cielo.lio.sdk.superlink.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @EqualsAndHashCode.Include
    private String id;
    private String shortUrl;
    private Type type;
    private String name;
    private String softDescriptor;
    private String description;
    private boolean showDescription;
    private String sku;
    private Integer price;
    private Integer weight;
    private Integer quantity;
    private Integer maxNumberOfInstallments;
    private Date expirationDate;
    private Shipping shipping;
    private Recurrent recurrent;
    private List<Link> links;

    public enum Type {
        ASSET,
        DIGITAL,
        SERVICE,
        PAYMENT,
        RECURRENT
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

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = Integer.valueOf(
            weight.multiply(BigDecimal.valueOf(100)).intValue());
    }

    public void setWeight(Double weight) {
        this.weight = Integer.valueOf(
            Double.valueOf(weight * 100).intValue());
    }

}