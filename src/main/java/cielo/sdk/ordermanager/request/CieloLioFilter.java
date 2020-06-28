package cielo.sdk.ordermanager.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import cielo.sdk.ordermanager.Order.Status;

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
public class CieloLioFilter {

    @JsonProperty("page_size")
    @SerializedName("page_size")
    private Integer pageSize;
    
    private Integer page;
    
    private Status status;
    
    private String number;

    @JsonProperty("merchant_id")
    @SerializedName("merchant_id")
    private String merchantId;

    private String reference;

    @JsonProperty("terminal_number")
    @SerializedName("terminal_number")
    private String terminalNumber;

    @JsonProperty("last_query_date")
    @SerializedName("last_query_date")
    private Date lastQueryDate;
    
}