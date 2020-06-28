package cielo.sdk.ordermanager.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import cielo.sdk.ordermanager.Order.Status;

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

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPage() {
        return page;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public void setTerminalNumber(String terminalNumber) {
        this.terminalNumber = terminalNumber;
    }

    public String getTerminalNumber() {
        return terminalNumber;
    }

    public void setLastQueryDate(Date lastQueryDate) {
        this.lastQueryDate = lastQueryDate;
    }

    public Date getLastQueryDate() {
        return lastQueryDate;
    }
    
}