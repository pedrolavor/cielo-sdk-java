package cielo.sdk.superlink.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    private ProductType type;

    private String name;

    private String softDescriptor;

    private String description;

    private boolean showDescription;

    private String sku;

    @JsonProperty
    private Integer price;

    @JsonProperty
    private Integer weight;

    private Integer quantity;

    private Integer maxNumberOfInstallments;

    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd hh:mm:ss")
    private Date expirationDate;

    private Shipping shipping;

    private Recurrent recurrent;

    private List<Link> links;

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

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @JsonIgnore
    public void setWeight(BigDecimal weight) {
        this.weight = Integer.valueOf(
            weight.multiply(BigDecimal.valueOf(100)).intValue());
    }

    @JsonIgnore
    public void setWeight(Double weight) {
        this.weight = Integer.valueOf(
            Double.valueOf(weight * 100).intValue());
    }

}