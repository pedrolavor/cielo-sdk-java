package cielo.lio.sdk.superlink;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
  
}