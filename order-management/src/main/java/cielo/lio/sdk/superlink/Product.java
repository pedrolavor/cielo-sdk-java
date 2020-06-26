package cielo.lio.sdk.superlink;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

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
  
}