package cielo.lio.sdk.superlink.model;

import java.util.Date;

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
public class Recurrent {

    private Type type;
    private Date expirationDate;

    public static enum Type {
        MONTHLY,
        BIMONTHLY,
        QUARTERLY,
        SEMI_ANNUAL,
        ANNUAL
    }

}