package cielo.lio.sdk.superlink;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recurrent {

  private Type type;
  private Date expirationDate;

  public enum Type {
    MONTHLY,
    BIMONTHLY,
    QUARTERLY,
    SEMI_ANNUAL,
    ANNUAL    
  }
  
}